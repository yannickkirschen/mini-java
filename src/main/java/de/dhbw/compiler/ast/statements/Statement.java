package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.codegeneration.CodeGenVisitor;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import org.objectweb.asm.Type;

public sealed interface Statement permits Block, Return, While, LocalVarDecl, If, StmtExprStmt {

    void accept(MethodCodeVisitor visitor);
}
