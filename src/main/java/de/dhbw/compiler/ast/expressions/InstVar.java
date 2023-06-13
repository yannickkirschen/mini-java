package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;

public non-sealed class InstVar implements Expression {

    public Expression thisExpr;
    public String varName;
    Type type;

    public InstVar(Expression thisExpr, String varName, Type type) {
        this.thisExpr = thisExpr;
        this.varName = varName;
        this.type = type;
    }

    public InstVar(Expression thisExpr, String varName) {
        this.thisExpr = thisExpr;
        this.varName = varName;
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
