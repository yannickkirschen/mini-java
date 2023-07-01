package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;

public non-sealed class JBoolean implements Expression {
    public String value;
    Type type;

    public JBoolean(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    public JBoolean(String value) {
        this.value = value;
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
