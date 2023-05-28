package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

public record Assign(String var, Expression value) implements StatementExpression {
    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
