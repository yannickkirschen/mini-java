package de.dhbw.ast.stmtexprs;

import de.dhbw.ast.expressions.Expression;

public record Assign(String var, Expression value) implements StatementExpression {
}
