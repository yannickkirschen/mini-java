package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.*;

public non-sealed class LocalOrFieldVar implements Expression {

    public String name;
    Type type;

    public LocalOrFieldVar(String name) {
        this.name = name;
    }

    public LocalOrFieldVar(String name, Type type) {
        this.name = name;
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
