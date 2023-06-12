package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.parser.antlr.MinijavaBaseVisitor;
import de.dhbw.compiler.parser.antlr.MinijavaParser;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExpressionGenerator extends MinijavaBaseVisitor<Expression> {
    @Override
    public Expression visitNull(MinijavaParser.NullContext ctx) {
        return new Jnull();
    }

    @Override
    public Expression visitCharacter(MinijavaParser.CharacterContext ctx) {
        return new JCharacter(ctx.CHARACTER().getSymbol().getText());
    }

    @Override
    public Expression visitString(MinijavaParser.StringContext ctx) {
        StringBuilder str = new StringBuilder();
        for (TerminalNode character : ctx.CHARACTER()){
            str.append(character.getSymbol().getText());
        }

        return new JString( str.toString() );
    }

    @Override
    public Expression visitConstant(MinijavaParser.ConstantContext ctx) {
        if (ctx.literal().boolean_() != null) {
            return new JBoolean(ctx.literal().boolean_().getText());
        } else {
            return new JInteger(ctx.literal().number().Number().getSymbol().getText());
        }
    }

    @Override
    public Expression visitBinaryOperation(MinijavaParser.BinaryOperationContext ctx) {
        String operator = null;
        if (ctx.binaryOp().PLUS() != null) {
            operator = ctx.binaryOp().PLUS().getSymbol().getText();
        }
        else if (ctx.binaryOp().MINUS() != null) {
            operator = ctx.binaryOp().MINUS().getSymbol().getText();
        }
        else if (ctx.binaryOp().MUL() != null) {
            operator = ctx.binaryOp().MUL().getSymbol().getText();
        }

        return new Binary(operator, this.visit( ctx.expr(0) ), this.visit( ctx.expr(1) ) );
    }

    @Override
    public Expression visitInstVar(MinijavaParser.InstVarContext ctx) {
        return new InstVar(this.visit( ctx.expr() ), ASTGenerator.generateId( ctx.id() ) );
    }

    @Override
    public Expression visitUnaryOperationPre(MinijavaParser.UnaryOperationPreContext ctx) {
        String operator = null;
        if (ctx.unaryOpPre().INCR() != null) {
            operator = ctx.unaryOpPre().INCR().getSymbol().getText();
        }
        if (ctx.unaryOpPre().DECR() != null) {
            operator = ctx.unaryOpPre().DECR().getSymbol().getText();
        }
        if (ctx.unaryOpPre().NOT() != null) {
            operator = ctx.unaryOpPre().NOT().getSymbol().getText();
        }
        if (ctx.unaryOpPre().PLUS() != null) {
            operator = ctx.unaryOpPre().PLUS().getSymbol().getText();
        }
        if (ctx.unaryOpPre().MINUS() != null) {
            operator = ctx.unaryOpPre().MINUS().getSymbol().getText();
        }

        return new Unary(operator, this.visit( ctx.expr() ));
    }

    @Override
    public Expression visitUnaryOperationPost(MinijavaParser.UnaryOperationPostContext ctx) {
        String operator = null;
        if (ctx.unaryOpPost().INCR() != null) {
            operator = ctx.unaryOpPost().INCR().getSymbol().getText();
        }
        if (ctx.unaryOpPost().DECR() != null) {
            operator = ctx.unaryOpPost().DECR().getSymbol().getText();
        }

        return new Unary(operator, this.visit( ctx.expr() ));
    }

    @Override
    public Expression visitSuper(MinijavaParser.SuperContext ctx) {
        return new Super();
    }

    @Override
    public Expression visitExpression(MinijavaParser.ExpressionContext ctx) {
        return this.visit( ctx.expr() );
    }

    @Override
    public Expression visitStmtExprExpr(MinijavaParser.StmtExprExprContext ctx) {
        StatementExpression stmtExpr = new StatementExpressionGenerator().visit( ctx.stmtExpr() );
        return new StmtExprExpr( stmtExpr );
    }

    @Override
    public Expression visitThis(MinijavaParser.ThisContext ctx) {
        return new This();
    }

    @Override
    public Expression visitLocation(MinijavaParser.LocationContext ctx) {
        return new LocalOrFieldVar( ASTGenerator.generateId( ctx.id() ) );
    }
}
