package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.Parameter;
import de.dhbw.compiler.ast.statements.*;

import java.util.List;

public interface BaseStatementChecker {
    Statement check(Statement statement) throws SyntaxException, TypeException;

    Statement check(Statement statement, List<Parameter> parameters) throws SyntaxException, TypeException;

    Block check(Block block) throws SyntaxException, TypeException;

    If check(If if_) throws SyntaxException, TypeException;

    LocalVarDecl check(LocalVarDecl localVarDecl) throws SyntaxException;

    Return check(Return return_) throws SyntaxException, TypeException;

    StmtExprStmt check(StmtExprStmt stmtExprStmt) throws SyntaxException, TypeException;

    While check(While while_) throws SyntaxException, TypeException;
}
