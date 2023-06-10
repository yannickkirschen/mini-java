package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.parser.antlr.MinijavaBaseVisitor;
import de.dhbw.compiler.parser.antlr.MinijavaParser;

public class ExpressionGenerator extends MinijavaBaseVisitor<Expression> {
    @Override
    public Expression visitNull(MinijavaParser.NullContext ctx) {
        return super.visitNull(ctx);
    }

    @Override
    public Expression visitCharacter(MinijavaParser.CharacterContext ctx) {
        return super.visitCharacter(ctx);
    }

    @Override
    public Expression visitConstant(MinijavaParser.ConstantContext ctx) {
        return super.visitConstant(ctx);
    }

    @Override
    public Expression visitBinaryOperation(MinijavaParser.BinaryOperationContext ctx) {
        return super.visitBinaryOperation(ctx);
    }

    @Override
    public Expression visitInstVar(MinijavaParser.InstVarContext ctx) {
        return super.visitInstVar(ctx);
    }

    @Override
    public Expression visitString(MinijavaParser.StringContext ctx) {
        return super.visitString(ctx);
    }

    @Override
    public Expression visitUnaryOperationPost(MinijavaParser.UnaryOperationPostContext ctx) {
        return super.visitUnaryOperationPost(ctx);
    }

    @Override
    public Expression visitSuper(MinijavaParser.SuperContext ctx) {
        return super.visitSuper(ctx);
    }

    @Override
    public Expression visitExpression(MinijavaParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public Expression visitUnaryOperationPre(MinijavaParser.UnaryOperationPreContext ctx) {
        return super.visitUnaryOperationPre(ctx);
    }

    @Override
    public Expression visitStmtExprExpr(MinijavaParser.StmtExprExprContext ctx) {
        return super.visitStmtExprExpr(ctx);
    }

    @Override
    public Expression visitThis(MinijavaParser.ThisContext ctx) {
        return super.visitThis(ctx);
    }

    @Override
    public Expression visitLocation(MinijavaParser.LocationContext ctx) {
        return super.visitLocation(ctx);
    }
}
