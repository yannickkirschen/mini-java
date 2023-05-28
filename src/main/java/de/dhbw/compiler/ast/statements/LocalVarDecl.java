package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.Type;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;


public record LocalVarDecl(Type type, String name) implements Statement {
    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
