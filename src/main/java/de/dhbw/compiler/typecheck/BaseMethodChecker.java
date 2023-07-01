package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.Method;
import de.dhbw.compiler.ast.Parameter;

public interface BaseMethodChecker {
    BaseStatementChecker getStatementChecker();

    Method check(Method method) throws SyntaxException, TypeException;

    Parameter check(Parameter parameter) throws SyntaxException;
}
