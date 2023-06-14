package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.typecheck.*;

public interface BaseClassChecker {
    Field check(Field field) throws SyntaxException;

    Method check(Method method) throws SyntaxException, TypeException;

    Method check(String methodName) throws SyntaxException, TypeException;
}
