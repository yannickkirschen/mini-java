package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.AstType;
import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.ast.expressions.LocalOrFieldVar;
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

        Statement stmt;
        for (MinijavaParser.StmtContext stmtContext : ctx.stmt()) {
            stmt = this.visit( stmtContext );
            stmts.add( stmt );
        }

        return new Block(stmts);
    }
    protected Statement aggregateResult(Statement aggregate, Statement nextResult) {
        if (nextResult != null)
            return nextResult;
        else return aggregate;
    }

    @Override
    public Statement visitReturn(MinijavaParser.ReturnContext ctx) {
        ExpressionGenerator eGen = new ExpressionGenerator();
        Expression expr = eGen.visit( ctx.expr() );
        return new Return( expr );
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

        LocalVarDecl decl = generateLocalVarDecl( ctx.varDecl() );
        stmts.add( decl );

        Expression expr = new ExpressionGenerator().visit( ctx.expr() );
        LocalOrFieldVar var = new LocalOrFieldVar( decl.name );
        Assign assign = new Assign( var, expr );
        stmts.add( new StmtExprStmt( assign ) );

        return new Block( stmts );
    }

    @Override
    public Statement visitVarDecl(MinijavaParser.VarDeclContext ctx) {
        return generateLocalVarDecl( ctx );
    }

    private LocalVarDecl generateLocalVarDecl(MinijavaParser.VarDeclContext var) {
        AstType type = ASTGenerator.generateType( var.type() );
        String name = var.Id().getSymbol().getText();

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
    public Statement visitStmtExpr(MinijavaParser.StmtExprContext ctx) {
        StatementExpressionGenerator seGen = new StatementExpressionGenerator();
        StatementExpression stmtExpr = seGen.visit( ctx );

        return new StmtExprStmt( stmtExpr );
    }
}
