package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.typecheck.*;

public interface BaseMethodChecker {
    Method check(Method method) throws SyntaxException, TypeException;

    Parameter check(Parameter parameter) throws SyntaxException;
}
