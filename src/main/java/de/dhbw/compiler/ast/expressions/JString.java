package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.ast.Type;

public non-sealed class JString implements Expression {

    public String value;
    Type type;

    public JString(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    public JString(String value) {
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
