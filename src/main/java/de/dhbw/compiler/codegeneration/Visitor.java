package de.dhbw.compiler.codegeneration;

public interface Visitor {
    void accept(MethodCodeVisitor visitor);
}
