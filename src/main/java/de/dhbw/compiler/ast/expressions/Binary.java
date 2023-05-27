package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.CodeGenVisitor;

public record Binary(String operator, Expression left, Expression right) implements Expression {
    @Override
    public void accept(CodeGenVisitor visitor) {
        visitor.visitExpression(this);
    }
}
