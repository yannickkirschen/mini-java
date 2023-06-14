package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.stmtexprs.*;
import de.dhbw.compiler.typecheck.*;

public interface BaseStatementExpressionChecker {
    StatementExpression check(StatementExpression statementExpression) throws SyntaxException, TypeException;

    Assign check(Assign assign) throws SyntaxException, TypeException;

    MethodCall check(MethodCall methodCall) throws SyntaxException, TypeException;

    New check(New new_) throws SyntaxException, TypeException;

    void setBaseClassChecker(BaseClassChecker classChecker);

    void setExpressionChecker(BaseExpressionChecker expressionChecker);
}
