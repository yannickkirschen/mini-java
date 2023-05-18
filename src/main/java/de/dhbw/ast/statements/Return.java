package de.dhbw.ast.statements;

import de.dhbw.ast.expressions.Expression;

public record Return(Expression expression) implements Statement {
}
