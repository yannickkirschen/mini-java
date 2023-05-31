package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;

public non-sealed class JCharacter implements Expression {

    public String value;
    Type type;

    public JCharacter(String value, Type type) {
        this.value = value;
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
