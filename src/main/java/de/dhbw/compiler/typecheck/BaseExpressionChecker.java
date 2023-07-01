package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.expressions.*;

public interface BaseExpressionChecker {
    Expression check(Expression expression) throws SyntaxException, TypeException;

    Binary check(Binary binary) throws SyntaxException, TypeException;

    InstVar check(InstVar instVar) throws SyntaxException, TypeException;

    JBoolean check(JBoolean jBoolean) throws SyntaxException;

    JCharacter check(JCharacter jChar) throws SyntaxException;

    JInteger check(JInteger jInt) throws SyntaxException;

    JNull check(JNull jnull);

    JString check(JString jString);

    LocalOrFieldVar check(LocalOrFieldVar localOrFieldVar) throws SyntaxException;

    StmtExprExpr check(StmtExprExpr stmtExprExpr) throws SyntaxException, TypeException;

    Super check(Super super_);

    This check(This this_);

    Unary check(Unary unary) throws SyntaxException, TypeException;
}
