package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.parser.antlr.MinijavaBaseVisitor;
import de.dhbw.compiler.parser.antlr.MinijavaParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class ExpressionGenerator extends MinijavaBaseVisitor<Expression> {
    @Override
    public Expression visitBinaryOperation(MinijavaParser.BinaryOperationContext ctx) {
        Expression out;
        if (ctx.arithmeticBinOp() != null) {
            out = handleArithmeticBinOp( ctx.arithmeticBinOp() );
        } else {
            out = handleLogicalBinOp( ctx.logicalBinOp() );
        }
        return out;
    }

    @Override
    protected Expression aggregateResult(Expression aggregate, Expression nextResult) {
        if (nextResult != null)
            return nextResult;
        else return aggregate;
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
        return this.visit( ctx.getChild(0) ); //TODO: solve this for arithmeticBinOp
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

        return this.visit( ctx.getChild(0) );
    }

    @Override
    public Expression visitLocalOrFieldVar(MinijavaParser.LocalOrFieldVarContext ctx) {
        return new LocalOrFieldVar( ctx.getText() );
    }

    @Override
    public Expression visitInstVar(MinijavaParser.InstVarContext ctx) {
        Expression var = generateInstVar( ctx.This(), ctx.Id(), null, 0);
        if (var instanceof LocalOrFieldVar) {
            return new InstVar( new This(), ((LocalOrFieldVar) var).name );
        }
        return var;
    }
    private Expression generateInstVar(TerminalNode this_, List<TerminalNode> ids, Expression previous, int index) {
        TerminalNode id = ids.get(index);

        if (previous == null) {
            previous = this_ == null ?
                new LocalOrFieldVar( id.getText() ) :
                new InstVar( new This(), id.getText())
            ;
        }
        else {
            previous = new InstVar( previous, id.getText() );
        }

        if (index < ids.size() - 1) {
            return generateInstVar(null, ids, previous, index + 1);
        }
        return previous;
    }

    @Override
    public Expression visitUnaryOperation(MinijavaParser.UnaryOperationContext ctx) {
        String operator = null;
        if (ctx.unaryOp().Not() != null) {
            operator = "!";
        }
        if (ctx.unaryOp().Plus() != null) {
            operator = "+";
        }
        if (ctx.unaryOp().Minus() != null) {
            operator = "-";
        }

        ExpressionGenerator eGen = new ExpressionGenerator();
        return new Unary( operator, eGen.visit( ctx.expr() ) );
    }

    @Override
    public Expression visitConstant(MinijavaParser.ConstantContext ctx) {
        if (ctx.Boolean() != null) {
            return new JBoolean( ctx.Boolean().getText() );
        } else {
            return new JInteger( ctx.number().getText() );
        }
    }

    @Override
    public Expression visitNumber(MinijavaParser.NumberContext ctx) {
        return new JInteger( ctx.getText() );
    }

    @Override
    public Expression visitChar(MinijavaParser.CharContext ctx) {
        return new JCharacter( ctx.character().getText() );
    }

    @Override
    public Expression visitString(MinijavaParser.StringContext ctx) {
        StringBuilder str = new StringBuilder();
        for (MinijavaParser.CharacterContext character : ctx.character()){
            str.append(character.getText());
        }

        return new JString( str.toString() );
    }

    @Override
    public Expression visitExpression(MinijavaParser.ExpressionContext ctx) {
        ExpressionGenerator eGen = new ExpressionGenerator();
        return eGen.visit( ctx.expr() );
    }

    @Override
    public Expression visitStmtExpr(MinijavaParser.StmtExprContext ctx) {
        StatementExpressionGenerator stmtExprGen = new StatementExpressionGenerator();
        return new StmtExprExpr( stmtExprGen.visit( ctx ) );
    }
}
