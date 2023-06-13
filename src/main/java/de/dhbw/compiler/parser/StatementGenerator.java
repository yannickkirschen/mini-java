package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.Type;
import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.parser.antlr.MinijavaBaseVisitor;
import de.dhbw.compiler.parser.antlr.MinijavaParser;

import java.util.ArrayList;
import java.util.List;

public class StatementGenerator extends MinijavaBaseVisitor<Statement> {
    @Override
    public Statement visitBlock(MinijavaParser.BlockContext ctx) {
        List<Statement> stmts = new ArrayList<>();

        for (MinijavaParser.StmtContext stmtContext : ctx.stmt()) {
            stmts.add( this.visit( stmtContext ) );
        }

        return new Block(stmts);
    }

    @Override
    public Statement visitReturn(MinijavaParser.ReturnContext ctx) {
        ExpressionGenerator eGen = new ExpressionGenerator();
        return new Return( eGen.visit( ctx.expr() ) );
    }

    @Override
    public Statement visitWhile(MinijavaParser.WhileContext ctx) {
        ExpressionGenerator eGen = new ExpressionGenerator();
        Expression condition = eGen.visit( ctx.expr() );
        Statement stmt = this.visit( ctx.stmt() );

        return new While(condition, stmt);
    }

    @Override
    public Statement visitLocalVarDeclAssign(MinijavaParser.LocalVarDeclAssignContext ctx) {
        List<Statement> stmts = new ArrayList<>();

        LocalVarDecl decl = generateLocalVarDecl( ctx.var() );
        stmts.add( decl );

        Expression expr = new ExpressionGenerator().visit( ctx.expr() );
        Assign assign = new Assign( decl.name(), expr );
        stmts.add( new StmtExprStmt( assign ) );

        return new Block( stmts );
    }

    @Override
    public Statement visitLocalVarDecl(MinijavaParser.LocalVarDeclContext ctx) {
        return generateLocalVarDecl( ctx.var() );
    }

    private LocalVarDecl generateLocalVarDecl(MinijavaParser.VarContext var) {
        Type type = ASTGenerator.generateType( var.type() );
        String name = ASTGenerator.generateId( var.id() );

        return new LocalVarDecl(type, name);
    }


    @Override
    public Statement visitIf(MinijavaParser.IfContext ctx) {
        ExpressionGenerator eGen = new ExpressionGenerator();
        Expression condition = eGen.visit( ctx.expr() );
        Statement ifBody = this.visit( ctx.stmt(0));
        Statement elseBody = ctx.stmt().size() == 2 ? this.visit( ctx.stmt(1)) : null;

        return new If(condition, ifBody, elseBody);
    }

    @Override
    public Statement visitStmtExprStmt(MinijavaParser.StmtExprStmtContext ctx) {
        StatementExpressionGenerator seGen = new StatementExpressionGenerator();
        StatementExpression stmtExpr = seGen.visit( ctx.stmtExpr() );

        return new StmtExprStmt( stmtExpr );
    }
}
