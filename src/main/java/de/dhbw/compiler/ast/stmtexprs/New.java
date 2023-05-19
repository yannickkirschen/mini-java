package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.Type;
import de.dhbw.compiler.ast.expressions.Expression;

import java.util.List;

public record New(Type type, List<Expression> expressions) implements StatementExpression {
}
