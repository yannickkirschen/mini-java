package de.dhbw.ast.expressions;

public record Unary(String operator, Expression argument) implements Expression {
}
