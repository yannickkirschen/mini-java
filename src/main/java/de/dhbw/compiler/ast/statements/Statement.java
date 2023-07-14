package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.ast.Type;

public sealed interface Statement permits Block, Return, While, LocalVarDecl, If, StmtExprStmt {

    void accept(MethodCodeVisitor visitor);
    Type getType();
    void setType(Type t);
}
