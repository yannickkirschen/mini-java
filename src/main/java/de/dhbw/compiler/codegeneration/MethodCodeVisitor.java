package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.MethodCall;
import de.dhbw.compiler.ast.stmtexprs.New;
//import de.dhbw.compiler.typecheck.model.TypedType;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

/**
 * Visitor that handles writing the bytecode for one method
 */
public class MethodCodeVisitor implements Opcodes {
    MethodVisitor v;
    String className;
    String lastClass;
    MethodVarStack vars;

    /**
     * @param v         the visitor that handles the actual bytecode creation and everything (like constantPool, etc.) related
     * @param className name of the class the method belongs to
     */
    public MethodCodeVisitor(MethodVisitor v, String className) {
        this.v = v;
        this.className = className;
        this.vars = new MethodVarStack();
    }

    /**
     * Takes an object of the type constructor and translates it to bytecode.
     * The method is the main entrypoint for method-bytecode-generation
     * The method puts this and the passed parameters to the localVarStack,
     * visits the mandatory super() call as well as the body containing the statements (if a body is given)
     * The super() call is hardcoded, since inheriting is not included in our java-subset and therefor the only possible super() call is to java.lang.Object
     *
     * @param m the Constructor to be translated to bytecode
     */
    public void visit(Constructor m) {
        v.visitCode();
        // TODO check if type is actually classname
        vars.addVar("this");
        m.parameterList.forEach(p -> vars.addVar(p.name));
        new Super().accept(this);
        if (m.getBody() != null)
            m.getBody().accept(this);
        v.visitInsn(RETURN);
        v.visitMaxs(0, 0);
        v.visitEnd();
    }

    /**
     * Takes an object of the type Method and translates it to bytecode
     * The method adds this and the passed parameters to the localVars and visits the body of the method.
     * If the methods returntype is VOID, a default VOID-return is added.
     * If the method does not return VOID, it is assumed the program is valid and the return is part of the body.
     *
     * @param m the Method to be translated to bytecode
     */
    public void visit(Method m) {
        v.visitCode();
        vars.addVar("this");
        m.parameters.forEach(p -> vars.addVar(p.name));
        m.statement.accept(this);

        if (m.getType().equals(PrimitiveType.VOID))
            v.visitInsn(RETURN);

        v.visitMaxs(0, 0);
        v.visitEnd();
    }

    /**
     * takes an object of the type Block and translates it to bytecode
     * by iterating over all the statements in the block and calling their respective accept-methods
     *
     * @param stmt the Block to be translated to bytecode
     */
    public void visit(Block stmt) {
        stmt.stmts.forEach(s -> s.accept(this));
    }

    /**
     * takes an object of the type Return and translates it to bytecode.
     * First the expression that is to be returned is visited and afterward the corresponding (VOID, Integer or other)
     * return statement is translated to bytecode
     *
     * @param ret the Return to be translated to bytecode
     */
    public void visit(Return ret) {
        ret.expression.accept(this);
        // TODO can we do void-return?
        if (ret.expression == null) {
            v.visitInsn(RETURN);
        }
        // return opcode for bool, int, char, byte, short
        else if (ret.expression.getType() instanceof PrimitiveType) {
            v.visitInsn(IRETURN);
        } else {
            v.visitInsn(ARETURN);
        }
    }

    /**
     * takes an object of the type If and translates it to bytecode.
     * First the condition is visited. Afterward the ifBody and, if present, the elseBody are visited.
     * Last but not least, using Labels provided by the ASM-package, the control-flow is set up in such a way
     * that the ifBody is used if the condition evaluates to TRUE otherwise the elseBody
     *
     * @param stmt the If to be translated to bytecode
     */
    public void visit(If stmt) {

        Label end = new Label();
        Label elseBranch = new Label();

        stmt.condition.accept(this);

        v.visitJumpInsn(IFEQ, stmt.elseBody != null ? elseBranch : end);      // if result of above visit is false (i.e. 0) -> go to else label, otherwise continue here
        stmt.ifBody.accept(this);
        v.visitJumpInsn(GOTO, end);
        v.visitLabel(elseBranch);
        if (stmt.elseBody != null) stmt.elseBody.accept(this);
        v.visitLabel(end);
    }

    /**
     * takes an object of the type While and translates it to bytecode.
     * First the condition is visited. Afterward the whileBody is visited.
     * Thirdly, using Labels provided by the ASM-package,
     * the controlflow is set up such that the whileBody is evaluated as long as the condition evaluates to TRUE.
     *
     * @param stmt the While to be translated to bytecode
     */
    public void visit(While stmt) {
        Label whileStart = new Label();
        Label end = new Label();


        v.visitLabel(whileStart);
        stmt.condition.accept(this);
        v.visitJumpInsn(IFEQ, end);
        stmt.statement.accept(this);
        // TODO find out if we have to clear whatever to body put onto the operator stack?
        v.visitJumpInsn(GOTO, whileStart);
        v.visitLabel(end);
    }

    /**
     * visits the statementExpression of the passed StmtExprStmt
     *
     * @param stmt the StmtExprStmt to be translated to bytecode
     */
    public void visit(StmtExprStmt stmt) {
        stmt.statementExpression.accept(this);
    }

    /**
     * since the LocalVarDecl does not require any bytecode changes,
     * only the information which variablename corresponds to which number is stored in the loclVarStack
     *
     * @param stmt the LocalVarDecl to be processed
     */
    public void visit(LocalVarDecl stmt) {
        vars.addVar(stmt.name);
    }

    /**
     * visits an assign-statement-expression.
     * The method basically works through the following process>
     * > determine the string-value of the variable that is meant to attain a new value.
     * Since it is ensured by the parser/typechecker that the only possible types for stmtExpr.target ar LocalOrFieldVar or InstVar,
     * it is sufficient to just check these to, to properly extract the name
     * > if the name is in the localVarStack (vars), the rhs of the assign is simply visited and,
     * depending on the type (Integer-like or other) of the Assign the ISTORE or ASTORE opcode is called,
     * such that the new value is stored with the corresponding variable-constant-pool-number (extracted from 'vars') is stored.
     * > If the lhs of the Assign is an InstVar, the process differs a bit.
     * Firstly the instVar is visited.
     * The second step involves once again visiting the rhs of the assign.
     * Lastly, using the PUTFIELD-Opcode, the value of the assign (which at runtime is at the top of the stack) is stored in the instVar.
     * > The last case is now that the assign's lhs is a fieldVar.
     * This is handled by putting "this" onto that stack (since a fieldVar is basically a "this.var", which very similiar to an InstVar)
     * Afterward the value visited and the value put using PUTFIELD again (with slightly different parameters)
     *
     * @param stmtExpr the Assign to be processed
     */
    public void visit(Assign stmtExpr) {
        String targetName = "";
        if (stmtExpr.target instanceof LocalOrFieldVar)
            targetName = ((LocalOrFieldVar) stmtExpr.target).name;
        if (stmtExpr.target instanceof InstVar)
            targetName = ((InstVar) stmtExpr.target).varName;

        if (vars.contains(targetName)) {
            stmtExpr.value.accept(this);

            if (stmtExpr.value.getType() instanceof PrimitiveType) {
                v.visitVarInsn(ISTORE, vars.getVar(targetName));
            } else {
                v.visitVarInsn(ASTORE, vars.getVar(targetName));
            }
        } else if (stmtExpr.target instanceof InstVar) {
            visitExpressionInstVar((InstVar) stmtExpr.target, false);
            stmtExpr.value.accept(this);// load new variable value onto stack
            v.visitFieldInsn(PUTFIELD, lastClass, targetName, getFieldDescriptor(stmtExpr.target)); //TODO implement method to generate field descriptor from fieldName
        } else {
            v.visitVarInsn(ALOAD, 0);
            stmtExpr.value.accept(this);
            v.visitFieldInsn(PUTFIELD, className, targetName, getFieldDescriptor(stmtExpr.target));
        }
    }

    // TODO for the following two methods we might need a method stack or class stack to determine the references to methods based on their names
    // I think this is resolved by extracting the type from the "thisExpr"

    /**
     * visits a method call.
     * First the lhs (i.e. the bit to the left of the dot in a method call) is visited.
     * Afterward the arguments are visited, such that at runtime the respective values are on the stack.
     * Lastly the actual method-call-opcode is visited.
     *
     * @param stmtExpr the MethodCall to be processed
     */
    public void visit(MethodCall stmtExpr) {
        stmtExpr.thisExpr.accept(this);
        stmtExpr.args.forEach(p -> p.accept(this));
        v.visitMethodInsn(INVOKEVIRTUAL, stmtExpr.thisExpr.getType().getName(), stmtExpr.name, getDescriptor(stmtExpr.getType(), stmtExpr.args), false);
    }

    /**
     * visits an object instantiation with "new".
     * First the NEW opcode is visited, which at runtime triggers the construction of an index in the runtime-constant pool.
     * Afterward the parameters for the constructor are visited and thus at runtime their values placed on the stack.
     * The last step is the invocation of the constructor of the class that was created using the INVOKESPECIAL opcode.
     *
     * @param stmtExpr the New to be processed
     */
    public void visit(New stmtExpr) {
        ObjectType voidType = new ObjectType("V");  // was VOID
        v.visitTypeInsn(NEW, stmtExpr.getType().getName());

        v.visitInsn(Opcodes.DUP);   // invoke-special pops the top, but doesn't return it back -> duplicate first
        stmtExpr.expressions.forEach(p -> p.accept(this));
        v.visitMethodInsn(INVOKESPECIAL, stmtExpr.getType().getName(), "<init>", getDescriptor(voidType, stmtExpr.expressions), false);
    }


    /**
     * visits the Binary expr described by the parameter.
     * First the lhs and rhs are visited and thus at runtime their respective values will be on the operand stack.
     * Based on the operator of the expression the corresponding opcode is then visited. At runtime this will trigger the corresponding operation.
     *
     * @param expr the Binary to be processed
     */
    public void visitExpression(Binary expr) {
        expr.left.accept(this);
        expr.right.accept(this);
        switch (expr.operator) {
            case "+" -> v.visitInsn(Opcodes.IADD);
            case "-" -> v.visitInsn(Opcodes.ISUB);
            case "*" -> v.visitInsn(Opcodes.IMUL);
            case "/" -> v.visitInsn(Opcodes.IDIV);
            default -> visitBoolExpression(expr.operator, expr.right);
        }
    }

    /**
     * visits boolesche binary expressions
     * This method is an extension of the {@link #visitExpression(Binary) visitBinary} method, for this reason the expressions are already visited
     * The encapsulation of bool expressions is needed to separate the boolesche return values implemented using labels and jump instructions from the int based return values
     * In case of && and || instructions we need to visit the expressions separately
     *
     * @param operator the Binary operator
     * @param right the right expression to be processed
     */

    private void visitBoolExpression(String operator, Expression right) {

        Label jumpTrue = new Label();
        Label jumpFalse = new Label();
        Label jumpEnd = new Label();

        switch (operator) {
            case "<" -> v.visitJumpInsn(Opcodes.IF_ICMPGE, jumpFalse);
            case "<=" -> v.visitJumpInsn(Opcodes.IF_ICMPGT, jumpFalse);
            case ">" -> v.visitJumpInsn(Opcodes.IF_ICMPLE, jumpFalse);
            case ">=" -> v.visitJumpInsn(Opcodes.IF_ICMPLT, jumpFalse);
            case "==" -> {
                if (right.getType() instanceof PrimitiveType) {              // checking only right side should be enough, cause type checker runs before
                    v.visitJumpInsn(Opcodes.IF_ICMPNE, jumpFalse);
                } else {
                    v.visitJumpInsn(Opcodes.IF_ACMPNE, jumpFalse);
                }
            }
            case "!=" -> {
                if (right.getType() instanceof PrimitiveType) {              // checking only right side should be enough, cause type checker runs before
                    v.visitJumpInsn(Opcodes.IF_ICMPEQ, jumpFalse);
                } else {
                    v.visitJumpInsn(Opcodes.IF_ACMPEQ, jumpFalse);
                }
            }
            case "&&" -> {
                v.visitInsn(Opcodes.POP);
                v.visitJumpInsn(Opcodes.IFEQ, jumpFalse);
                right.accept(this);
                v.visitJumpInsn(Opcodes.IFEQ, jumpFalse);
            }
            case "||" -> {
                v.visitInsn(Opcodes.POP);
                v.visitJumpInsn(Opcodes.IFNE, jumpTrue);
                right.accept(this);
                v.visitJumpInsn(Opcodes.IFEQ, jumpFalse);
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + operator);
        }
        v.visitLabel(jumpTrue);
        v.visitInsn(Opcodes.ICONST_1); // true
        v.visitJumpInsn(Opcodes.GOTO, jumpEnd);
        v.visitLabel(jumpFalse);
        v.visitInsn(Opcodes.ICONST_0); // false
        v.visitLabel(jumpEnd);
    }

    /**
     * calls {@link #visitExpressionInstVar(InstVar, boolean) visitExpressionInstVar} with the parameters expr and true
     *
     * @param expr the InstVar expression to be processed
     */
    public void visitExpression(InstVar expr) {
        visitExpressionInstVar(expr, true);
    }

    /**
     * visits the parameter expr as an instance variable
     *
     * @param expr  the InstVar expression to be processed
     * @param withField Boolean
     */
    public void visitExpressionInstVar(InstVar expr, boolean withField) {
        expr.thisExpr.accept(this);
        lastClass = expr.thisExpr.getType().getName();
        if (withField)
            v.visitFieldInsn(Opcodes.GETFIELD, lastClass, expr.varName, getFieldDescriptor(expr));
    }

    /**
     * visits parameter expr and loads corresponding value for true or false on the operand stack
     *
     * @param expr the JBoolean expression to be processed
     */
    public void visitExpression(JBoolean expr) {
        if (expr.value.equals("true"))
            v.visitInsn(Opcodes.ICONST_1);
        else
            v.visitInsn(Opcodes.ICONST_0);
    }

    /**
     * visits the parameter expr and loads the corresponding ascii value on the operand stack
     *
     * @param expr the JCharacter expression to be processed
     */
    public void visitExpression(JCharacter expr) {
        int value = (int) expr.value.toCharArray()[0];
        v.visitLdcInsn(value);
    }


    /**
     * visits the parameter expr and loads the corresponding integer value on the operand stack
     *
     * @param expr the JInteger expression to be processed
     */
    public void visitExpression(JInteger expr) {
        v.visitLdcInsn(Integer.valueOf(expr.value));
    }

    /**
     * loads null value on the operand stack
     *
     * @param expr the JNull expression to be processed
     */
    public void visitExpression(JNull expr) {
        v.visitInsn(Opcodes.ACONST_NULL);

    }

    /**
     * visits the parameter expr and loads the corresponding string value on the operand stack
     *
     * @param expr the JString expression to be processed
     */
    public void visitExpression(JString expr) {
        v.visitLdcInsn(expr.value);
    }

    /**
     * takes an LocalOrFieldVar object and tries to get the MethodVarStack index of this variable
     * In case of the index equals -1 it´s a field, and it will be loaded to the operand stack using it´s name
     * Otherwise it loads the local variable using the provided index
     *
     * @param expr the LocalOrFieldVar expression to be processed
     */
    public void visitExpression(LocalOrFieldVar expr) {
        int varIndex = vars.getIndex(expr.name);
        if (varIndex == -1) {
            v.visitVarInsn(Opcodes.ALOAD, 0);
            v.visitFieldInsn(Opcodes.GETFIELD, className, expr.name, getFieldDescriptor(expr));

        } else {
            if (isReference(expr.getType())) {
                v.visitVarInsn(Opcodes.ALOAD, varIndex);
            } else {
                v.visitVarInsn(Opcodes.ILOAD, varIndex);
            }
        }
    }

    /**
     * calls the visitor method from the statementExpression of the parameter expr
     *
     * @param expr the StmtExprExpr expression to be processed
     */

    public void visitExpression(StmtExprExpr expr) {
        expr.statementExpression.accept(this);
    }

    /**
     * loads "this" on the operand stack and calls the Object constructor
     *
     * @param expr the "Super" expression to be processed
     */
    public void visitExpression(Super expr) {
        v.visitVarInsn(ALOAD, 0);
        v.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
    }

    /**
     * loads "this" on the operand stack
     *
     * @param expr the "This" expression to be processed
     */
    public void visitExpression(This expr) {
        v.visitVarInsn(Opcodes.ALOAD, 0);
    }

    /**
     * visits the parameter expr and loads the negated value on the operand stack
     *
     * @param expr the Unary to be processed
     */
    public void visitExpression(Unary expr) {
        //Label jumpTrue = new Label();
        Label jumpFalse = new Label();
        Label jumpEnd = new Label();
        expr.argument.accept(this);
        v.visitJumpInsn(Opcodes.IFNE, jumpFalse);
        //v.visitLabel(jumpTrue);
        v.visitInsn(Opcodes.ICONST_1);
        v.visitJumpInsn(Opcodes.GOTO, jumpEnd);
        v.visitLabel(jumpFalse);
        v.visitInsn(Opcodes.ICONST_0);
        v.visitLabel(jumpEnd);
    }

    /**
     * builds the descriptor of a method in a jvm readable format
     *
     * @param returnType the return type of the method
     * @param paramTypes a list containing all method parameter
     * @return String
     */
    private String getDescriptor(Type returnType, List<Expression> paramTypes) {
        var start = new StringBuilder("(");
        for (var expr : paramTypes) start.append(getFieldDescriptor(expr));
        start.append(")");
        start.append(returnType.getName());

        return start.toString();
    }


    /**
     * checks if Type t is an instance of ObjectType else return false
     *
     * @param t the Type to be checked
     * @return Boolean
     */
    private Boolean isReference(Type t) {
        return t instanceof ObjectType;
    }

    /**
     * builds a jvm readable field descriptor
     *
     * @param field LocalOrFieldVar
     * @return String
     */
    public String getFieldDescriptor(Expression field) {
        if (field.getType() instanceof ObjectType) {
            return String.format("L%s;", field.getType().getName());
        } else {
            return field.getType().getName();
        }
    }

}
