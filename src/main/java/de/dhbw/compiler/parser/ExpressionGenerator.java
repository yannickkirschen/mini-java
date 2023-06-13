package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.parser.antlr.MinijavaBaseVisitor;
import de.dhbw.compiler.parser.antlr.MinijavaParser;

public class ExpressionGenerator extends MinijavaBaseVisitor<Expression> {
    @Override
    public Expression visitBinaryOperation(MinijavaParser.BinaryOperationContext ctx) {
        String operator = ctx.binaryOp().getText();

        return new Binary(operator, this.visit( ctx.subExpression() ), this.visit( ctx.expr() ) );
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
