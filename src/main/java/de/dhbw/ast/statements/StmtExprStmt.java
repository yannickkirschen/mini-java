package de.dhbw.ast.statements;

import de.dhbw.ast.stmtexprs.StatementExpression;

public record StmtExprStmt(StatementExpression statementExpression) implements Statement {
}
