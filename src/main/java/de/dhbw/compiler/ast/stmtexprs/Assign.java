package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.expressions.Expression;

public record Assign(String var, Expression value) implements StatementExpression {
}
