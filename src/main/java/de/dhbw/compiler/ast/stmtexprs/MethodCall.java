package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

import java.util.List;

public record MethodCall(Expression thisExpr, String name, List<Expression> args) implements StatementExpression {
    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
