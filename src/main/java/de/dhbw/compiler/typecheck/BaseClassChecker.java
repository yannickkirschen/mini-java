package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.Constructor;
import de.dhbw.compiler.ast.Field;
import de.dhbw.compiler.ast.Method;

public interface BaseClassChecker {
    Field check(Field field) throws SyntaxException;

    Constructor check(Constructor constructor) throws SyntaxException, TypeException;

    Method check(Method method) throws SyntaxException, TypeException;

    Method check(String methodName) throws SyntaxException, TypeException;
}
