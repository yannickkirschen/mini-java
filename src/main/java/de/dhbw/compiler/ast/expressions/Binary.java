package de.dhbw.compiler.ast.expressions;

public record Binary(String operator, Expression left, Expression right) implements Expression {
}
