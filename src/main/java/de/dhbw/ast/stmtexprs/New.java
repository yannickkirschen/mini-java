package de.dhbw.ast.stmtexprs;

import de.dhbw.ast.expressions.Expression;
import de.dhbw.ast.Type;

public record New(Type type, Expression expression) implements StatementExpression {
}
