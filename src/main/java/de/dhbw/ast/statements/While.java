package de.dhbw.ast.statements;

import de.dhbw.ast.expressions.Expression;

public record While(Expression condition, Statement statement) implements Statement {
}
