package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

public record StmtExprExpr(StatementExpression statementExpression) implements Expression {
    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visitExpression(this);
    }
}
