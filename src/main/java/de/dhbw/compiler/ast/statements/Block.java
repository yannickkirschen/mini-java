package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.Type;
import de.dhbw.compiler.codegeneration.CodeGenVisitor;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

import java.util.List;

public record Block(List<Statement> stmts) implements Statement {
    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
