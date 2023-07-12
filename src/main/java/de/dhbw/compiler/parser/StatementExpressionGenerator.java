package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.AstType;
import de.dhbw.compiler.ast.expressions.*;
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
        Expression assignable = null;
        ExpressionGenerator eGen = new ExpressionGenerator();

        if (ctx.assignable().Id() != null) {
            String id = ctx.assignable().Id().getText();
            assignable = new LocalOrFieldVar( id );
        }
        if (ctx.assignable().instVar() != null) {
            assignable = eGen.visit( ctx.assignable().instVar() );
        }

        Expression value = eGen.visit( ctx.expr() );

        return new Assign(assignable, value);
    }

    @Override
    public StatementExpression visitNew(MinijavaParser.NewContext ctx) {
        AstType type = ASTGenerator.generateType( ctx.type() );

        ExpressionGenerator eGen = new ExpressionGenerator();
        List<Expression> args = new ArrayList<>();
        if (ctx.args() != null) {
            for (MinijavaParser.ExprContext eCtx : ctx.args().expr()) {
                args.add( eGen.visit( eCtx ) );
            }
        }

        return new New(type, args);
    }

    @Override
    public StatementExpression visitMethodCall(MinijavaParser.MethodCallContext ctx) {
        ExpressionGenerator eGen = new ExpressionGenerator();
        String name = ctx.Id().getText();
        Expression thisExpr;
        if ( ctx.localOrFieldVar() != null ) {
            thisExpr = eGen.visit( ctx.localOrFieldVar() );
        } else {
            thisExpr = new This();
        }

        List<Expression> args = new ArrayList<>();
        for (MinijavaParser.ExprContext eCtx : ctx.args().expr()) {
            args.add( eGen.visit( eCtx ) );
        }

        return new MethodCall(thisExpr, name, args);
    }

    @Override
    public StatementExpression visitUnaryAssign(MinijavaParser.UnaryAssignContext ctx) {
        Expression assignable = null;
        if (ctx.assignable().Id() != null)  {
            assignable = new LocalOrFieldVar( ctx.assignable().Id().getText() );
        }
        if (ctx.assignable().instVar() != null) {
            ExpressionGenerator eGen = new ExpressionGenerator();
            assignable = eGen.visit( ctx.assignable().instVar() );
        }

        String operator = null;
        if (ctx.unaryAssOp().Incr() != null) {
            operator = "+";
        }
        if (ctx.unaryAssOp().Decr() != null) {
            operator = "-";
        }

        Expression expr = new Binary(
            operator,
            assignable,
            new JInteger("1")
        );

        return new Assign( assignable, expr );
    }
}
