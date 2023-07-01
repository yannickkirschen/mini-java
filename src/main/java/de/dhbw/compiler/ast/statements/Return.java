package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;

public non-sealed class Return implements Statement {

    public Expression expression;

    Type type;

    public Return(Expression expression, Type type) {
        this.expression = expression;
        this.type = type;
    }

    public Return(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
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
