package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.expressions.Expression;

import java.util.List;

public record MethodCall(Expression thisExpr, String name, List<Expression> args) implements StatementExpression {
}