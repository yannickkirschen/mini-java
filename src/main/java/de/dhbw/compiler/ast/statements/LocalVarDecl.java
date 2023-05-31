package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;


public non-sealed class LocalVarDecl implements Statement {
    Type passedType;
    public String name;
    Type type;

    public LocalVarDecl(Type passedType, String name, Type type) {
        this.passedType = passedType;
        this.name = name;
        this.type = type;
    }

    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public de.dhbw.compiler.codegeneration.Type getType() {
        return type;
    }

    @Override
    public void setType(de.dhbw.compiler.codegeneration.Type t) {
        type = t;
    }
}
