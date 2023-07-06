package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.Constructor;
import de.dhbw.compiler.ast.Method;
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
     *
     * @param v the visitor that handles the actual bytecode creation and everything (like constantPool, etc.) related
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
     * @param stmt the Block to be translated to bytecode
     */
    public void visit(Block stmt) {
        stmt.stmts.forEach(s -> s.accept(this));
    }

    /**
     * takes an object of the type Return and translates it to bytecode.
     * First the expression that is to be returned is visited and afterward the corresponding (VOID, Integer or other)
     * return statement is translated to bytecode
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
     * @param stmt the StmtExprStmt to be translated to bytecode
     */
    public void visit(StmtExprStmt stmt) {
        stmt.statementExpression.accept(this);
    }

    /**
     * since the LocalVarDecl does not require any bytecode changes,
     * only the information which variablename corresponds to which number is stored in the loclVarStack
     * @param stmt the LocalVarDecl to be processed
     */
    public void visit(LocalVarDecl stmt) {
        vars.addVar(stmt.name);
    }

    public void visit(Assign stmtExpr) {
        // TODO only deals with local vars at this moment
        // TODO field vars

        String targetName = "";
        if (stmtExpr.target instanceof LocalOrFieldVar)
            targetName = ((LocalOrFieldVar) stmtExpr.target).name;

        // TODO find out other type of lhs of assign
        if(stmtExpr.target instanceof InstVar)
            targetName = ((InstVar) stmtExpr.target).varName;
        System.out.println("targetName: " + targetName);

        if (vars.contains(targetName)) {
            System.out.println("visiting local var");
            stmtExpr.value.accept(this);

            if (stmtExpr.value.getType() instanceof PrimitiveType) {
                v.visitVarInsn(ISTORE, vars.getVar(targetName));
            }
            // TODO if we have any other type than int-derivative and other, we need to add this here
            else {
                v.visitVarInsn(ASTORE, vars.getVar(targetName));
            }
        } else if(stmtExpr.target instanceof InstVar){
            System.out.println("visiting instVar");
            //v.visitVarInsn(ALOAD, 0);       // load "this" onto stack
            visitExpressionInstVar((InstVar) stmtExpr.target, false);
            stmtExpr.value.accept(this);// load new variable value onto stack
            v.visitFieldInsn(PUTFIELD, lastClass, targetName, getFieldDescriptor(stmtExpr.target)); //TODO implement method to generate field descriptor from fieldName
        }
        else{
            v.visitVarInsn(ALOAD, 0);
            stmtExpr.value.accept(this);
            v.visitFieldInsn(PUTFIELD, className, targetName, getFieldDescriptor(stmtExpr.target));
            System.out.println("stmt.expr target type: " + stmtExpr.target.getClass());
        }
    }

    // TODO for the following two methods we might need a method stack or class stack to determine the references to methods based on their names

    public void visit(MethodCall stmtExpr) {
        stmtExpr.thisExpr.accept(this);
        stmtExpr.args.forEach(p -> p.accept(this));
        v.visitMethodInsn(INVOKEVIRTUAL, stmtExpr.thisExpr.getType().getName(), stmtExpr.name, getDescriptor(stmtExpr.getType(), stmtExpr.args), false);
    }

    public void visit(New stmtExpr) {
        ObjectType voidType = new ObjectType("V");  // was VOID
        v.visitTypeInsn(NEW, stmtExpr.getType().getName());
        stmtExpr.expressions.forEach(p -> p.accept(this));
        v.visitInsn(Opcodes.DUP);   // invoke-special pops the top, but doesn't return it back -> duplicate first
        v.visitMethodInsn(INVOKESPECIAL, stmtExpr.getType().getName(), "<init>", getDescriptor(voidType, stmtExpr.expressions), false);
    }


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


    public void visitExpression(InstVar expr){
        visitExpressionInstVar(expr, true);
    }

    public void visitExpressionInstVar(InstVar expr, boolean withField) {
        System.out.println("visiting instvar with: "+ expr.thisExpr.getType().getName());
        expr.thisExpr.accept(this);
        lastClass = expr.thisExpr.getType().getName();
        if(withField)
            v.visitFieldInsn(Opcodes.GETFIELD, lastClass, expr.varName, getFieldDescriptor(expr));
    }

    public void visitExpression(JBoolean expr) {
        if (expr.value.equals("true"))
            v.visitInsn(Opcodes.ICONST_1);
        else
            v.visitInsn(Opcodes.ICONST_0);
    }

    // TODO could be optimized
    public void visitExpression(JCharacter expr) {
        int value = (int) expr.value.toCharArray()[0];
        v.visitLdcInsn(value);
    }


    // TODO could be optimized
    public void visitExpression(JInteger expr) {
        v.visitLdcInsn(Integer.valueOf(expr.value));
    }

    public void visitExpression(JNull expr) {
        v.visitInsn(Opcodes.ACONST_NULL);

    }

    public void visitExpression(JString expr) {
        v.visitLdcInsn(expr.value);
    }

    public void visitExpression(LocalOrFieldVar expr) {
        int varIndex = vars.getIndex(expr.name);
        if (varIndex == -1) {
            v.visitVarInsn(Opcodes.ALOAD, 0);
            v.visitFieldInsn(Opcodes.GETFIELD, className, expr.name, getFieldDescriptor(expr));// TODO -> after merged typing into ast -> get type from instVar

        } else {
            if (isReference(expr.getType())) {
                v.visitVarInsn(Opcodes.ALOAD, varIndex);
            } else {
                v.visitVarInsn(Opcodes.ILOAD, varIndex);
            }
        }
    }

    public void visitExpression(StmtExprExpr expr) {
        expr.statementExpression.accept(this);
    }

    public void visitExpression(Super expr) {
        v.visitVarInsn(ALOAD, 0);
        v.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
    }

    public void visitExpression(This expr) {
        v.visitVarInsn(Opcodes.ALOAD, 0);
    }

    public void visitExpression(Unary expr) {
        Label jumpTrue = new Label();
        Label jumpFalse = new Label();
        Label jumpEnd = new Label();
        int varIndex;
        if (expr.argument instanceof LocalOrFieldVar)
            varIndex = vars.getIndex(((LocalOrFieldVar) expr.argument).name);
        else if (expr.argument instanceof InstVar)
            varIndex = -2;
        else
            throw new IllegalArgumentException("not allowed here: " + expr.argument.toString());


        switch (expr.operator) {
            case "!" -> {
                expr.argument.accept(this);
                v.visitJumpInsn(Opcodes.IFNE, jumpFalse);
                v.visitLabel(jumpTrue);
                v.visitInsn(Opcodes.ICONST_1);
                v.visitJumpInsn(Opcodes.GOTO, jumpEnd);
                v.visitLabel(jumpFalse);
                v.visitInsn(Opcodes.ICONST_0);
                v.visitLabel(jumpEnd);
            }
        }


    }

    private String getDescriptor(Type returnType, List<Expression> paramTypes) {
        var start = new StringBuilder("(");
        for (var expr : paramTypes) start.append(getFieldDescriptor(expr));
        start.append(")");
        start.append(returnType.getName());

        return start.toString();
    }


    private Boolean isReference(Type t) {
        return t instanceof ObjectType;
    }

    public String getFieldDescriptor(Expression field) {
        if (field.getType() instanceof ObjectType) {
            return String.format("L%s;", field.getType().getName());
        } else {
            return field.getType().getName();
        }
    }

}
