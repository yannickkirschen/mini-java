package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.expressions.Expression;

public record Return(Expression expression) implements Statement {
}
