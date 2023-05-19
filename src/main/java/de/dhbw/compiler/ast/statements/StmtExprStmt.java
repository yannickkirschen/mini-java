package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.stmtexprs.StatementExpression;

public record StmtExprStmt(StatementExpression statementExpression) implements Statement {
}
