package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

public record If(Expression condition, Statement ifBody, Statement elseBody) implements Statement {

    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
