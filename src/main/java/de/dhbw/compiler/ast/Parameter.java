package de.dhbw.compiler.ast;

import de.dhbw.compiler.codegeneration.Type;

public class Parameter {
    Type type;
    AstType astType;
    public String name;

    public Parameter(Type type, AstType astType, String name) {
        this.type = type;
        this.astType = astType;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
