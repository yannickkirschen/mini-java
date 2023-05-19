package de.dhbw.compiler.typecheck.model;

import de.dhbw.compiler.ast.expressions.Expression;

public record TypedExpression<T extends Expression>(TypedType type, T expression) {
}
