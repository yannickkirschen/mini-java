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
        return new Binary(operator, this.visit( ctx.subExpression() ), this.visit( ctx.expr() ) );
    }

    private Expression handleArithmeticBinOp(MinijavaParser.ArithmeticBinOpContext ctx) {
        if (ctx.binAddOperator() != null) {
            String operator = ctx.binAddOperator().getText();
            Expression left = this.visit( ctx.subExpression() );
            Expression right = this.visit( ctx.mulOp() );
            return new Binary(operator, left, right);
        }
        return this.visit( ctx.mulOp() );
    }

    @Override
    public Expression visitMulOp(MinijavaParser.MulOpContext ctx) {
        if (ctx.binMulOperator() != null) {
            String operator = ctx.binMulOperator().getText();
            Expression left = this.visit( ctx.mulSubOp() );
            Expression right = this.visit( ctx.mulOp() );
            return new Binary(operator, left, right );
        }
        return this.visit( ctx.mulSubOp() );
    }

    @Override
    public Expression visitMulSubOp(MinijavaParser.MulSubOpContext ctx) {
        return this.visit( ctx.getChild(0) );
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
            return new JNull();
        }

        SubExpressionGenerator subGen = new SubExpressionGenerator();
        return subGen.visit( ctx );
    }

    @Override
    public Expression visitNumber(MinijavaParser.NumberContext ctx) {
        SubExpressionGenerator subEGen = new SubExpressionGenerator();
        return subEGen.visit( ctx );
    }
}
