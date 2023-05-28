package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

public record StmtExprStmt(StatementExpression statementExpression) implements Statement {
    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
