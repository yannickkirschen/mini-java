package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.codegeneration.Type;
import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

import java.util.List;

public non-sealed class New implements StatementExpression {
    Type passedType;
    public List<Expression> expressions;
    Type type;

    public New(Type passedType, List<Expression> expressions, Type type) {
        this.passedType = passedType;
        this.expressions = expressions;
        this.type = type;
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
