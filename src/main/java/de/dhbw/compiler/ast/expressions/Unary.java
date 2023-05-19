package de.dhbw.compiler.ast.expressions;

public record Unary(String operator, Expression argument) implements Expression {
}
