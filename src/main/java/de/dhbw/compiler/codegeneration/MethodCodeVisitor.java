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

public class MethodCodeVisitor implements Opcodes {

    MethodVisitor v;
    String methodName;
    String className;
    MethodVarStack vars;
    public MethodCodeVisitor(MethodVisitor v, String className){
        this.v = v;
        this.className = className;
        this.vars = new MethodVarStack();
    }

    public void visit(Constructor m){
        v.visitCode();
        // TODO check if type is actually classname
        methodName = m.getType().toString();
        vars.addVar("this");
        m.parameterList.forEach(p -> vars.addVar(p.name));
        new Super().accept(this);
        if(m.getBody() != null)
            m.getBody().accept(this);
        v.visitInsn(RETURN);
        v.visitMaxs(0,0);
        v.visitEnd();
    }

    public void visit(Method m){
        v.visitCode();
        methodName = m.name;
        vars.addVar("this");
        m.parameters.forEach(p -> vars.addVar(p.name));
        m.statement.accept(this);

        v.visitMaxs(0,0);
        v.visitEnd();
    }
    public void visit(Block stmt) {
        stmt.stmts.forEach(s -> s.accept(this));
    }

    public void visit(Return ret){
        System.out.println("ret.expr: " + ret.expression);
        ret.expression.accept(this);


        // TODO can we do void-return?
        if(ret.expression == null){
            v.visitInsn(RETURN);
        }
        // return opcode for bool, int, char, byte, short
        else if(ret.expression.getType() instanceof PrimitiveType){
            v.visitInsn(IRETURN);
        }
        else{
            v.visitInsn(ARETURN);
        }
    }

    public void visit(If stmt){

        Label elseBranch = new Label();
        Label end = new Label();

        stmt.condition.accept(this);

        v.visitJumpInsn(IFEQ, elseBranch);      // if result of above visit is false (i.e. 0) -> go to else label, otherwise continue here
        stmt.ifBody.accept(this);
        v.visitJumpInsn(GOTO, end);
        v.visitLabel(elseBranch);
        stmt.elseBody.accept(this);
        v.visitLabel(end);
    }

    public void visit(While stmt){
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

    public void visit (StmtExprStmt stmt){
        stmt.statementExpression.accept(this);
    }

    public void visit (LocalVarDecl stmt){
        // assuming that declaration and initialization are not possible at the same time / line of code
        vars.addVar(stmt.name);
    }

    public void visit(Assign stmtExpr){
        // TODO only deals with local vars at this moment
        // TODO field vars

        // TODO do proper type matching
        if(vars.contains(stmtExpr.target.toString())) {
            stmtExpr.value.accept(this);

            if (stmtExpr.value.getType() instanceof PrimitiveType) {
                v.visitVarInsn(ISTORE, vars.getVar(stmtExpr.target.toString()));
            }
            // TODO if we have any other type than int-derivative and other, we need to add this here
            else {
                v.visitVarInsn(ASTORE, vars.getVar(stmtExpr.target.toString()));
            }
        }
        else{
            v.visitVarInsn(ALOAD, 0);       // load "this" onto stack
            stmtExpr.value.accept(this);// load new variable value onto stack
            v.visitFieldInsn(PUTFIELD, className, stmtExpr.target.toString(), getFieldDescriptor(stmtExpr.target)); //TODO implement method to generate field descriptor from fieldName
        }
    }

    // TODO for the following two methods we might need a method stack or class stack to determine the references to methods based on their names

    public void visit(MethodCall stmtExpr){
        stmtExpr.thisExpr.accept(this);
        stmtExpr.args.forEach(p -> p.accept(this));
        v.visitMethodInsn(INVOKEVIRTUAL, stmtExpr.thisExpr.getType().toString(), stmtExpr.name, getDescriptor(stmtExpr.getType(), stmtExpr.args), false);
    }

    public void visit(New stmtExpr){
        ObjectType voidType = new ObjectType("VOID");
        v.visitTypeInsn(NEW, stmtExpr.getType().getName());
        stmtExpr.expressions.forEach(p -> p.accept(this));
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
            case "==" -> v.visitJumpInsn(Opcodes.IF_ACMPNE, jumpFalse); // enough to check only the reference ?
            case "!=" -> v.visitJumpInsn(Opcodes.IF_ACMPEQ, jumpFalse); // enough to check only the reference ?
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


    public void visitExpression(InstVar expr) {
        expr.thisExpr.accept(this);
        v.visitFieldInsn(Opcodes.GETFIELD, className, expr.varName, getFieldDescriptor(expr)); // TODO after merged typing into ast -> get type from instVar
    }

    public void visitExpression(JBoolean expr) {
        if (expr.value.equals("true"))
            v.visitInsn(Opcodes.ICONST_1);
        else
            v.visitInsn(Opcodes.ICONST_0);
    }

    // TODO could be optimized
    public void visitExpression(JCharacter expr) {
        v.visitLdcInsn(expr.value);
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
        System.out.println("varIndex: " + varIndex);
        System.out.println("className: " + className);
        vars.printAll();
        if (varIndex == -1) {
            v.visitVarInsn(Opcodes.ALOAD, 0);
            v.visitFieldInsn(Opcodes.GETFIELD, "TestClass", expr.name, getFieldDescriptor(expr));// TODO -> after merged typing into ast -> get type from instVar

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

        if (expr.operator.equals("!")) {
            expr.argument.accept(this);
            v.visitJumpInsn(Opcodes.IFNE, jumpFalse);
        }

        v.visitLabel(jumpTrue);
        v.visitInsn(Opcodes.ICONST_1);
        v.visitJumpInsn(Opcodes.GOTO, jumpEnd);
        v.visitLabel(jumpFalse);
        v.visitInsn(Opcodes.ICONST_0);
        v.visitLabel(jumpEnd);
    }

    private String getDescriptor(Type returnType, List<Expression> paramTypes) {
        //TODO
        return "";
    }


    private Boolean isReference(Type t) {
        // TODO
        return t instanceof ObjectType;
    }

    public String getFieldDescriptor( Expression field){
        return field.getType().getName();
    }

}
