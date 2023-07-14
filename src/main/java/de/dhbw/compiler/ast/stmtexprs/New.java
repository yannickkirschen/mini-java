package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.AstType;
import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.ast.Type;
import lombok.Getter;

import java.util.List;

public non-sealed class New implements StatementExpression {
    public List<Expression> expressions;
    @Getter
    AstType passedType;
    Type type;

    public New(AstType passedType, List<Expression> args, Type type) {
        this.passedType = passedType;
        this.expressions = args;
        this.type = type;
    }

    public New(AstType passedType, List<Expression> expressions) {
        this.passedType = passedType;
        this.expressions = expressions;
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
