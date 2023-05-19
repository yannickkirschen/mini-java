package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.typecheck.*;
import de.dhbw.compiler.typecheck.model.*;

public interface BaseClassVisitor {
    TypedField visit(Field field) throws SyntaxException;

    TypedMethod<? extends Statement> visit(Method method) throws SyntaxException, TypeException;

    TypedMethod<? extends Statement> visit(String methodName) throws SyntaxException, TypeException;
}
