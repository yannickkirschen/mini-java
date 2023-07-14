package de.dhbw.compiler.ast;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;

public interface Visitor {
    void accept(MethodCodeVisitor visitor);
}
