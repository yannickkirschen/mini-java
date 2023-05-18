package de.dhbw.ast.stmtexprs;

public sealed interface StatementExpression permits Assign, New, MethodCall {
}
