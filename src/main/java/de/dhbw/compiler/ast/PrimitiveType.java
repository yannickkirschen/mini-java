package de.dhbw.compiler.ast;

import de.dhbw.compiler.ast.Type;

public enum PrimitiveType implements Type {
    INTEGER("I"),
    CHARACTER("C"),
    BOOLEAN("Z"),
    VOID("V");

    private final String name;

    PrimitiveType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
