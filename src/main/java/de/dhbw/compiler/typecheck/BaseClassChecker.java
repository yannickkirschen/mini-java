package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.*;

public interface BaseClassChecker {
    Field check(Field field) throws SyntaxException;

    Method check(Method method) throws SyntaxException, TypeException;

    Method check(String methodName) throws SyntaxException, TypeException;
}
