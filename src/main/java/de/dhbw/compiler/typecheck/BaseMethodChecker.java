package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.*;

public interface BaseMethodChecker {
    Method check(Method method) throws SyntaxException, TypeException;

    Parameter check(Parameter parameter) throws SyntaxException;
}
