package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;

public non-sealed class Binary implements Expression {
    public String operator;
    public Expression left;
    public Expression right;
    Type type;

    public Binary(String operator, Expression left, Expression right, Type type) {
        this.operator = operator;
        this.left = left;
        this.right = right;
        this.type = type;
    }

    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visitExpression(this);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type t) {
        type = t;
    }
}
