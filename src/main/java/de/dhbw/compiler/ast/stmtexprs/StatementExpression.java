package de.dhbw.compiler.ast.stmtexprs;

public sealed interface StatementExpression permits Assign, New, MethodCall {
}