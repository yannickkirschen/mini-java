package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.expressions.*;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import javax.lang.model.element.Element;

//temporary
public class ExpressionVisitor extends CodeGenVisitor {

    public void visitExpression(Expression expr, MethodVisitor v) {
    }


    public void visitExpression(Binary expr, MethodVisitor v) {
        expr.left().accept(this);
        expr.right().accept(this);
        switch (expr.operator()) {
            case "+" -> v.visitInsn(Opcodes.IADD);
            case "-" -> v.visitInsn(Opcodes.ISUB);
            case "*" -> v.visitInsn(Opcodes.IMUL);
            case "/" -> v.visitInsn(Opcodes.IDIV);
            default -> visitBoolExpression(expr.operator(), v, expr.right());
        }
    }

    private void visitBoolExpression(String operator, MethodVisitor v, Expression right) {

        Label jumpTrue = new Label();
        Label jumpFalse = new Label();
        Label end = new Label();

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
        v.visitJumpInsn(Opcodes.GOTO, end);
        v.visitLabel(jumpFalse);
        v.visitInsn(Opcodes.ICONST_0); // false
        v.visitLabel(end);
    }


    public void visitExpression(InstVar expr, MethodVisitor v) {
        // TODO
    }

    public void visitExpression(JBoolean expr, MethodVisitor v) {
        if (expr.value().equals("true"))
            v.visitInsn(Opcodes.ICONST_1);
        else
            v.visitInsn(Opcodes.ICONST_0);
    }

    // TODO could be optimized
    public void visitExpression(JCharacter expr, MethodVisitor v) {
        v.visitLdcInsn(expr.value());
    }

    // TODO could be optimized
    public void visitExpression(JInteger expr, MethodVisitor v) {
        v.visitLdcInsn(expr.value());
    }

    public void visitExpression(JNull expr, MethodVisitor v) {
        v.visitInsn(Opcodes.ACONST_NULL);
    }

    public void visitExpression(JString expr, MethodVisitor v) {
        v.visitLdcInsn(expr.value());
    }

    public void visitExpression(LocalOrFieldVar expr, MethodVisitor v) {
        //TODO
    }

    public void visitExpression(StmtExprExpr expr, MethodVisitor v) {
        //TODO
    }

    public void visitExpression(Super expr, MethodVisitor v) {
        //TODO
    }

    public void visitExpression(This expr, MethodVisitor v) {
        v.visitVarInsn(Opcodes.ALOAD, 0);
    }

    public void visitExpression(Unary expr, MethodVisitor v) {
        Label trueLabel = new Label();
        Label falseLabel = new Label();
        Label end = new Label();

        if (expr.operator().equals("!")) {
            expr.argument().accept(this);
            v.visitJumpInsn(Opcodes.IFNE, falseLabel);
        }

        v.visitLabel(trueLabel);
        v.visitInsn(Opcodes.ICONST_1);
        v.visitJumpInsn(Opcodes.GOTO, end);
        v.visitLabel(falseLabel);
        v.visitInsn(Opcodes.ICONST_0);
        v.visitLabel(end);
    }

}
