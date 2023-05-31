package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.Type;
import de.dhbw.compiler.codegeneration.Visitor;

public sealed interface Expression extends Visitor permits
    This, Super, LocalOrFieldVar, InstVar, Unary, Binary, JInteger, JBoolean, JCharacter, JString, JNull, StmtExprExpr {

    Type getType();
    void setType(Type t);
}
