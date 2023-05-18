package de.dhbw.ast.expressions;

import de.dhbw.ast.stmtexprs.StatementExpression;

public record StmtExprExpr(StatementExpression statementExpression) implements Expression {
}
