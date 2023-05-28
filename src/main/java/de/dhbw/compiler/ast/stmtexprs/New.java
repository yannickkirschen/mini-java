package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.Type;
import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

import java.util.List;

public record New(Type type, List<Expression> expressions) implements StatementExpression {
    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
