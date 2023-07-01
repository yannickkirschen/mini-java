package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;

import java.util.List;

public non-sealed class MethodCall implements StatementExpression {
    public Expression thisExpr;
    public String name;
    public List<Expression> args;
    Type type;

    public MethodCall(Expression thisExpr, String name, List<Expression> args, Type type) {
        this.thisExpr = thisExpr;
        this.name = name;
        this.args = args;
        this.type = type;
    }

    public MethodCall(Expression thisExpr, String name, List<Expression> args) {
        this.thisExpr = thisExpr;
        this.name = name;
        this.args = args;
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
