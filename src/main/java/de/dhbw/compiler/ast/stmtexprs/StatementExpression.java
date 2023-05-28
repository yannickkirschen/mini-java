package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.Method;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

public sealed interface StatementExpression permits Assign, MethodCall, New {

    void accept(MethodCodeVisitor visitor);
}
