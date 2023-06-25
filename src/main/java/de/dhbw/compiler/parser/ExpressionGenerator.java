package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.parser.antlr.MinijavaBaseVisitor;
import de.dhbw.compiler.parser.antlr.MinijavaParser;

public class ExpressionGenerator extends MinijavaBaseVisitor<Expression> {
    @Override
    public Expression visitBinaryOperation(MinijavaParser.BinaryOperationContext ctx) {
        return ctx.arithmeticBinOp() != null ?
            handleArithmeticBinOp( ctx.arithmeticBinOp() ) :
            handleLogicalBinOp( ctx.logicalBinOp() )
            ;
    }

    private Expression handleLogicalBinOp(MinijavaParser.LogicalBinOpContext ctx) {
        String operator = ctx.binLogicalOperator().getText();
        return new Binary(operator, this.visit( ctx.subExpression() ), this.visit( ctx.expression() ) );
    }

    private Expression handleArithmeticBinOp(MinijavaParser.ArithmeticBinOpContext ctx) {
        String operator = ctx.binMulOperator().getText();
        return new Binary(operator, this.visit( ctx.subExpression() ), this.visit( ctx.mulOp() ) );
    }

    @Override
    public Expression visitMulOp(MinijavaParser.MulOpContext ctx) {
        String operator = ctx.binMulOperator().getText();
        return new Binary(operator, this.visit( ctx.mulSubOp() ), this.visit( ctx.mulOp() ) );
    }

    @Override
    public Expression visitMulSubOp(MinijavaParser.MulSubOpContext ctx) {
        ExpressionGenerator eGen = new ExpressionGenerator();
        return eGen.visit( ctx.getChild(0) );
    }

    @Override
    public Expression visitSubExpression(MinijavaParser.SubExpressionContext ctx) {
        if (ctx.This() != null) {
            return new This();
        }
        if (ctx.Super() != null) {
            return new Super();
        }
        if (ctx.Null() != null) {
            return new Jnull();
        }

        SubExpressionGenerator subGen = new SubExpressionGenerator();
        return subGen.visit( ctx );
    }
}
