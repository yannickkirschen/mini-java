package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.CodeGenVisitor;

public record JString(String value) implements Expression {
    @Override
    public void accept(CodeGenVisitor visitor) {
        visitor.visitExpression(this);
    }
}
