package de.dhbw.ast.statements;

import de.dhbw.ast.expressions.Expression;

public record If(Expression condition, Statement ifBody, Statement elseBody) implements Statement {
}
