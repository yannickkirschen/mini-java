package de.dhbw.compiler.codegeneration;

public enum PrimitiveType implements Type {
    INTEGER("java.lang.Integer"),
    CHARAKTER("java.lang.Character"),
    BOOLEAN("java.lang.Boolean");

    private final String name;

    PrimitiveType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
