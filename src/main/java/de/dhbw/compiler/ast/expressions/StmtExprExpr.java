package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.ast.stmtexprs.StatementExpression;

public record StmtExprExpr(StatementExpression statementExpression) implements Expression {
}
