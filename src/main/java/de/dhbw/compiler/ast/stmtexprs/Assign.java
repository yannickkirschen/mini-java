package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.expressions.Expression;

public record Assign(Expression target, Expression value) implements StatementExpression {
}
