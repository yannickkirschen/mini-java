package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.stmtexprs.*;
import de.dhbw.compiler.typecheck.*;
import de.dhbw.compiler.typecheck.model.TypedStatementExpression;

public interface BaseStatementExpressionVisitor {
    TypedStatementExpression visit(StatementExpression statementExpression) throws SyntaxException, TypeException;

    TypedStatementExpression visit(Assign assign) throws SyntaxException, TypeException;

    TypedStatementExpression visit(MethodCall methodCall) throws SyntaxException, TypeException;

    TypedStatementExpression visit(New new_) throws SyntaxException, TypeException;

    void setBaseClassVisitor(BaseClassVisitor classVisitor);

    void setExpressionVisitor(BaseExpressionVisitor expressionVisitor);
}
