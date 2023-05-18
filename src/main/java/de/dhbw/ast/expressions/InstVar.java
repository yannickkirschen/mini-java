package de.dhbw.ast.expressions;

public record InstVar(Expression thisExpr, String varName) implements Expression {
}
