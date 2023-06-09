package de.dhbw.compiler.ast;

import lombok.Getter;

public class Field {
    @Getter
    public AstType astType;
    public String name;
    Type type;

    public Field(Type type, AstType astType, String name) {
        this.type = type;
        this.astType = astType;
        this.name = name;
    }

    public Field(AstType astType, String name) {
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
