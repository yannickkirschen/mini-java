package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

public record This() implements Expression {
    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visitExpression(this);
    }
}
