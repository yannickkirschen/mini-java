package de.dhbw.compiler.ast.expressions;

public sealed interface Expression permits
    This, Super, LocalOrFieldVar, InstVar, Unary, Binary, Integr, Bool, Char, Strng, Jnull, StmtExprExpr {
}
