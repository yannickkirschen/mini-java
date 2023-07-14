package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.ast.Type;

public non-sealed class While implements Statement {
    public Expression condition;
    public Statement statement;
    Type type;

    public While(Expression condition, Statement statement, Type type) {
        this.condition = condition;
        this.statement = statement;
        this.type = type;
    }

    public While(Expression condition, Statement statement) {
        this.condition = condition;
        this.statement = statement;
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
