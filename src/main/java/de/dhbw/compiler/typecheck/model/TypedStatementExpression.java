package de.dhbw.compiler.typecheck.model;

import de.dhbw.compiler.ast.stmtexprs.StatementExpression;

public record TypedStatementExpression(TypedType type, StatementExpression statementExpression) {
}
