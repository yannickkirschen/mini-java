package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.ast.Type;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public non-sealed class JNull implements Expression {

    Type type;
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
