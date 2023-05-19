package de.dhbw.compiler.ast.expressions;

public record InstVar(Expression thisExpr, String varName) implements Expression {
}
