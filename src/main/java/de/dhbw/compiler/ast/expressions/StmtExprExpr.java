package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;

public non-sealed class StmtExprExpr implements Expression {

    public StatementExpression statementExpression;

    Type type;

    public StmtExprExpr(StatementExpression statementExpression, Type type) {
        this.statementExpression = statementExpression;
        this.type = type;
    }

    public StmtExprExpr(StatementExpression statementExpression) {
        this.statementExpression = statementExpression;
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
