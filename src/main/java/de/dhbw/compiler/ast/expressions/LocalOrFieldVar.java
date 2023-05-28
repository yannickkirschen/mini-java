package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

public record LocalOrFieldVar(String name) implements Expression {
    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visitExpression(this);
    }
}
