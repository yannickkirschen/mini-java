package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.ast.Type;

public non-sealed class Assign implements StatementExpression {
    public Expression target;
    public Expression value;
    Type type;

    public Assign(Expression target, Expression value, Type type) {
        this.target = target;
        this.value = value;
        this.type = type;
    }

    public Assign(Expression target, Expression value) {
        this.target = target;
        this.value = value;
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
