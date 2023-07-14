package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.ast.Type;

public non-sealed class Unary implements Expression {

    public String operator;
    public Expression argument;
    Type type;

    public Unary(String operator, Expression argument, Type type) {
        this.operator = operator;
        this.argument = argument;
        this.type = type;
    }

    public Unary(String operator, Expression argument) {
        this.operator = operator;
        this.argument = argument;
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
