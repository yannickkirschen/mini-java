package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.ast.Type;

public record New(Type type, Expression expression) implements StatementExpression {
}
