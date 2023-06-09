package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.ast.Type;

public sealed interface StatementExpression permits Assign, MethodCall, New {

    void accept(MethodCodeVisitor visitor);
    Type getType();
    void setType(Type t);
}
