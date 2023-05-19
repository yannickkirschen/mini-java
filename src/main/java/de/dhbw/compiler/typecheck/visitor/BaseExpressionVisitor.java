package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.typecheck.*;
import de.dhbw.compiler.typecheck.model.TypedExpression;

public interface BaseExpressionVisitor {
    TypedExpression<? extends Expression> visit(Expression expression) throws SyntaxException, TypeException;

    TypedExpression<Binary> visit(Binary binary) throws SyntaxException, TypeException;

    TypedExpression<InstVar> visit(InstVar instVar) throws SyntaxException, TypeException;

    TypedExpression<JBoolean> visit(JBoolean jBoolean) throws SyntaxException;

    TypedExpression<JCharacter> visit(JCharacter jChar) throws SyntaxException;

    TypedExpression<JInteger> visit(JInteger jInt) throws SyntaxException;

    TypedExpression<JNull> visit(JNull jnull);

    TypedExpression<JString> visit(JString jString);

    TypedExpression<LocalOrFieldVar> visit(LocalOrFieldVar localOrFieldVar) throws SyntaxException;

    TypedExpression<StmtExprExpr> visit(StmtExprExpr stmtExprExpr) throws SyntaxException, TypeException;

    TypedExpression<Super> visit(Super super_);

    TypedExpression<This> visit(This this_);

    TypedExpression<Unary> visit(Unary unary) throws SyntaxException, TypeException;
}
