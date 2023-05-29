package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.Method;
import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.MethodCall;
import de.dhbw.compiler.ast.stmtexprs.New;
import de.dhbw.compiler.typecheck.model.TypedType;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodCodeVisitor implements Opcodes {

    MethodVisitor v;
    String className;
    MethodVarStack vars;
    public MethodCodeVisitor(MethodVisitor v){
        this. v = v;
        this.vars = new MethodVarStack();
    }

    public void visit(Method m){
        className = m.name();
        vars.addVar("this");
        m.parameters().forEach(p -> vars.addVar(p.name()));
        m.statement().accept(this);
    }
    public void visit(Block stmt) {
        stmt.stmts().forEach(s -> s.accept(this));
    }

    public void visit(Return ret){
        ret.expression().accept(this);


        // TODO can we do void-return?
        if(ret.expression() == null){
            v.visitInsn(RETURN);
        }
        // return opcode for bool, int, char, byte, short
        // TODO find generic expression for type = bool or int or Boolean or java/lang/Integer, etc.
        else if(ret.expression().type() == "bool" || ret.expression().type() == "int" || ret.expression().type() == "char"){
            v.visitInsn(IRETURN);
        }
        else{
            v.visitInsn(ARETURN);
        }
    }

    public void visit(If stmt){

        Label elseBranch = new Label();
        Label end = new Label();

        stmt.condition().accept(this);

        v.visitJumpInsn(IFEQ, elseBranch);      // if result of above visit is false (i.e. 0) -> go to else label, otherwise continue here
        stmt.ifBody().accept(this);
        v.visitJumpInsn(GOTO, end);
        v.visitLabel(elseBranch);
        stmt.elseBody().accept(this);
        v.visitLabel(end);
    }

    public void visit(While stmt){
        Label whileStart = new Label();
        Label end = new Label();


        v.visitLabel(whileStart);
        stmt.condition().accept(this);
        v.visitJumpInsn(IFEQ, end);
        stmt.statement().accept(this);
        // TODO find out if we have to clear whatever to body put onto the operator stack?
        v.visitJumpInsn(GOTO, whileStart);
        v.visitLabel(end);
    }

    public void visit (StmtExprStmt stmt){
        stmt.statementExpression().accept(this);
    }

    public void visit (LocalVarDecl stmt){
        // assuming that declaration and initialization are not possible at the same time / line of code
        vars.addVar(stmt.name());
    }

    public void visit(Assign stmtExpr){
        // TODO only deals with local vars at this moment
        // TODO field vars

        // TODO do proper type matching
        if(stmtExpr.var() == "element of local vars") {
            stmtExpr.value().accept(this);

            if (stmtExpr.value().type() == "bool, int, char, byte, short, etc.") {
                v.visitVarInsn(ISTORE, vars.getVar(stmtExpr.var()));
            }
            // TODO if we have any other type than int-derivative and other, we need to add this here
            else {
                v.visitVarInsn(ASTORE, vars.getVar(stmtExpr.var()));
            }
        }
        else{
            // TODO putfield
        }
    }

    // TODO for the following two methods we might need a method stack or class stack to determine the references to methods based on their names

    public void visit(MethodCall stmtExpr){
        //TODO
    }

    public void visit(New stmtExpr){
        // TODO
    }



    public void visitExpression(Binary expr) {
        expr.left().accept(this);
        expr.right().accept(this);
        switch (expr.operator()) {
            case "+" -> v.visitInsn(Opcodes.IADD);
            case "-" -> v.visitInsn(Opcodes.ISUB);
            case "*" -> v.visitInsn(Opcodes.IMUL);
            case "/" -> v.visitInsn(Opcodes.IDIV);
            default -> visitBoolExpression(expr.operator(), expr.right());
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
        expr.thisExpr().accept(this);
        v.visitFieldInsn(Opcodes.GETFIELD, className, expr.varName(), getDescriptor(new TypedType("type"))); // TODO after merged typing into ast -> get type from instVar
    }

    public void visitExpression(JBoolean expr) {
        if (expr.value().equals("true"))
            v.visitInsn(Opcodes.ICONST_1);
        else
            v.visitInsn(Opcodes.ICONST_0);
    }

    // TODO could be optimized
    public void visitExpression(JCharacter expr) {
        v.visitLdcInsn(expr.value());
    }

    // TODO could be optimized
    public void visitExpression(JInteger expr) {
        v.visitLdcInsn(expr.value());
    }

    public void visitExpression(JNull expr) {
        v.visitInsn(Opcodes.ACONST_NULL);
    }

    public void visitExpression(JString expr) {
        v.visitLdcInsn(expr.value());
    }

    public void visitExpression(LocalOrFieldVar expr) {
        int varIndex = getIndex(expr.name());
        if (varIndex == -1) {
            v.visitVarInsn(Opcodes.ALOAD, 0);
            v.visitFieldInsn(Opcodes.GETFIELD, className, expr.name(), getDescriptor(new TypedType("type"))); // TODO -> after merged typing into ast -> get type from instVar
        } else {
            if (isReference()) {
                v.visitVarInsn(Opcodes.ALOAD, varIndex);
            } else {
                v.visitVarInsn(Opcodes.ILOAD, varIndex);
            }
        }
    }

    public void visitExpression(StmtExprExpr expr, ) {
        //TODO
    }

    public void visitExpression(Super expr) {
        v.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
    }

    public void visitExpression(This expr) {
        v.visitVarInsn(Opcodes.ALOAD, 0);
    }

    public void visitExpression(Unary expr) {
        Label jumpTrue = new Label();
        Label jumpFalse = new Label();
        Label jumpEnd = new Label();

        if (expr.operator().equals("!")) {
            expr.argument().accept(this);
            v.visitJumpInsn(Opcodes.IFNE, jumpFalse);
        }

        v.visitLabel(jumpTrue);
        v.visitInsn(Opcodes.ICONST_1);
        v.visitJumpInsn(Opcodes.GOTO, jumpEnd);
        v.visitLabel(jumpFalse);
        v.visitInsn(Opcodes.ICONST_0);
        v.visitLabel(jumpEnd);
    }

    private String getDescriptor(TypedType type) {
        //TODO
        return "";
    }


    private Boolean isReference(/*TypedType type*/) {
        // TODO
        return true;
    }

}





}
