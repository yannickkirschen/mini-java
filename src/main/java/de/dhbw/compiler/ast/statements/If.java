package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;

public non-sealed class If implements Statement {

    public Expression condition;
    public Statement ifBody;
    public Statement elseBody;
    Type type;

    public If(Expression condition, Statement ifBody, Statement elseBody, Type type) {
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
        this.type = type;
    }

    public If(Expression condition, Statement ifBody, Statement elseBody) {
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
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
