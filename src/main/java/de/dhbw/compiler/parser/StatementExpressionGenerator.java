package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.Type;
import de.dhbw.compiler.ast.expressions.Binary;
import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.ast.expressions.JInteger;
import de.dhbw.compiler.ast.expressions.LocalOrFieldVar;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.MethodCall;
import de.dhbw.compiler.ast.stmtexprs.New;
import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.parser.antlr.MinijavaBaseVisitor;
import de.dhbw.compiler.parser.antlr.MinijavaParser;

import java.util.ArrayList;
import java.util.List;

public class StatementExpressionGenerator extends MinijavaBaseVisitor<StatementExpression> {
    @Override
    public StatementExpression visitAssign(MinijavaParser.AssignContext ctx) {
        String var = ASTGenerator.generateId( ctx.id() );
        ExpressionGenerator eGen = new ExpressionGenerator();
        Expression value = eGen.visit( ctx.expr() );

        return new Assign(var, value);
    }

    @Override
    public StatementExpression visitNew(MinijavaParser.NewContext ctx) {
        Type type = ASTGenerator.generateType( ctx.type() );

        ExpressionGenerator eGen = new ExpressionGenerator();
        List<Expression> args = new ArrayList<>();
        for (MinijavaParser.ExprContext eCtx : ctx.args().expr()) {
            args.add( eGen.visit( eCtx ) );
        }

        return new New(type, args);
    }

    @Override
    public StatementExpression visitMethodCall(MinijavaParser.MethodCallContext ctx) {
        ExpressionGenerator eGen = new ExpressionGenerator();
        Expression thisExpr = eGen.visit( ctx.location() );
        String name = ASTGenerator.generateId( ctx.id() );

        List<Expression> args = new ArrayList<>();
        for (MinijavaParser.ExprContext eCtx : ctx.args().expr()) {
            args.add( eGen.visit( eCtx ) );
        }

        return new MethodCall(thisExpr, name, args);
    }

    @Override
    public StatementExpression visitUnaryAssignPost(MinijavaParser.UnaryAssignPostContext ctx) {
        return generateUnaryAssign( ctx.id(), ctx.unaryAssOp() );
    }

    @Override
    public StatementExpression visitUnaryAssignPre(MinijavaParser.UnaryAssignPreContext ctx) {
        return generateUnaryAssign( ctx.id(), ctx.unaryAssOp() );
    }

    // TODO: separate unaryAssignPre and unaryAssignPost
    private Assign generateUnaryAssign(MinijavaParser.IdContext id, MinijavaParser.UnaryAssOpContext unaryAssOp) {
        String var = ASTGenerator.generateId( id );

        String operator = null;
        if (unaryAssOp.INCR() != null) {
            operator = "+";
        }
        if (unaryAssOp.DECR() != null) {
            operator = "-";
        }

        Expression expr = new Binary(
            operator,
            new LocalOrFieldVar(var),
            new JInteger("1")
        );

        return new Assign(var, expr);
    }


}
