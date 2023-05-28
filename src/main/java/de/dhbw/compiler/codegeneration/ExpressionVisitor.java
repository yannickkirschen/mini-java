package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.typecheck.model.TypedType;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.Map;

//temporary
public class ExpressionVisitor extends CodeGenVisitor {

    String className = "class";

    // id:  identifier , value: index or identifier
    Map<String, String> varStack = new HashMap<>();

    private Boolean isLocal(String identifier) {
        return varStack.get(identifier).matches("\\d+");
    }

    private int getIndex(String identifier) {
        return isLocal(identifier) ? Integer.parseInt(varStack.get(identifier)) : -1;
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


    public void visitExpression(InstVar expr, MethodVisitor v) {
        expr.thisExpr().accept(this);
        v.visitFieldInsn(Opcodes.GETFIELD, className, expr.varName(), getDescriptor(new TypedType("type"))); // TODO after merged typing into ast -> get type from instVar
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

    public void visitExpression(StmtExprExpr expr, MethodVisitor v) {
        //TODO
    }

    public void visitExpression(Super expr, MethodVisitor v) {
        v.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
    }

    public void visitExpression(This expr, MethodVisitor v) {
        v.visitVarInsn(Opcodes.ALOAD, 0);
    }

    public void visitExpression(Unary expr, MethodVisitor v) {
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
