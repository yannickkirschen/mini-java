package de.dhbw.compiler.ast.statements;

public sealed interface Statement permits Block, Return, While, LocalVarDecl, If, StmtExprStmt {
}
