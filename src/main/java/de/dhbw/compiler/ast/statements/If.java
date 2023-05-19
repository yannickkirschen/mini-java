package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.expressions.Expression;

public record If(Expression condition, Statement ifBody, Statement elseBody) implements Statement {
}
