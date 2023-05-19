package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.typecheck.*;
import de.dhbw.compiler.typecheck.model.TypedStatement;

public interface BaseStatementVisitor {
    TypedStatement<? extends Statement> visit(Statement statement) throws SyntaxException, TypeException;

    TypedStatement<? extends Statement> visit(Block block) throws SyntaxException, TypeException;

    TypedStatement<? extends Statement> visit(If if_) throws SyntaxException, TypeException;

    TypedStatement<? extends Statement> visit(LocalVarDecl localVarDecl) throws SyntaxException;

    TypedStatement<? extends Statement> visit(Return return_) throws SyntaxException, TypeException;

    TypedStatement<? extends Statement> visit(StmtExprStmt stmtExprStmt) throws SyntaxException, TypeException;

    TypedStatement<? extends Statement> visit(While while_) throws SyntaxException, TypeException;
}
