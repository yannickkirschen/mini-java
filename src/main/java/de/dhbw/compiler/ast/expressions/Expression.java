package de.dhbw.compiler.ast.expressions;

public sealed interface Expression permits
    This, Super, LocalOrFieldVar, InstVar, Unary, Binary, JInteger, JBoolean, JCharacter, JString, JNull, StmtExprExpr {
}
