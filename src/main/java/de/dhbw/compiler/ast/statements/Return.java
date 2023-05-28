package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

public record Return(Expression expression) implements Statement {

    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
