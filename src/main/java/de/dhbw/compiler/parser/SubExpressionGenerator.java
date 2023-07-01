package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.parser.antlr.MinijavaBaseVisitor;
import de.dhbw.compiler.parser.antlr.MinijavaParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class SubExpressionGenerator extends MinijavaBaseVisitor<Expression> {
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
            return new JInteger( ctx.Number().getSymbol().getText() );
        }
    }

    @Override
    public Expression visitChar(MinijavaParser.CharContext ctx) {
        return new JCharacter( ctx.Character().getText() );
    }

    @Override
    public Expression visitString(MinijavaParser.StringContext ctx) {
        StringBuilder str = new StringBuilder();
        for (TerminalNode character : ctx.Character()){
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
