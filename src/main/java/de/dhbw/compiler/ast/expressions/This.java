package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.CodeGenVisitor;

public record This() implements Expression {
    @Override
    public void accept(CodeGenVisitor visitor) {
        visitor.visitExpression(this);
    }
}
