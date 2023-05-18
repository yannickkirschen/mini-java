package de.dhbw.ast.stmtexprs;

import de.dhbw.ast.expressions.Expression;

import java.util.List;

public record MethodCall(Expression thisExpr, String name, List<Expression> args) implements StatementExpression {
}
