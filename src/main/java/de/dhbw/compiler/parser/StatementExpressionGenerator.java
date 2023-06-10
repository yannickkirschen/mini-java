package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.Type;
import de.dhbw.compiler.ast.expressions.Expression;
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
}
