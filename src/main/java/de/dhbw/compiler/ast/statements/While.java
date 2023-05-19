package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.expressions.Expression;

public record While(Expression condition, Statement statement) implements Statement {
}
