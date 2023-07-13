package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.ast.Type;

public non-sealed class StmtExprStmt implements Statement {
    public StatementExpression statementExpression;
    Type type;

    public StmtExprStmt(StatementExpression statementExpression, Type type) {
        this.statementExpression = statementExpression;
        this.type = type;
    }

    public StmtExprStmt(StatementExpression statementExpression) {
        this.statementExpression = statementExpression;
    }

    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type t) {
        type = t;
    }
}
