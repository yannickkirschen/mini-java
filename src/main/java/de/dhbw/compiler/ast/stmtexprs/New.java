package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.ast.Type;

import java.util.List;

public record New(Type type, List<Expression> args) implements StatementExpression {
}
