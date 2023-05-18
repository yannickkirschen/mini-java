package de.dhbw.ast.statements;

public sealed interface Statement permits Block, Return, While, LocalVarDecl, If, StmtExprStmt {
}
