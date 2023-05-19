package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.typecheck.*;
import de.dhbw.compiler.typecheck.model.*;

public interface BaseMethodVisitor {
    TypedMethod<? extends Statement> visit(Method method) throws SyntaxException, TypeException;

    TypedParameter visit(Parameter parameter) throws SyntaxException;
}
