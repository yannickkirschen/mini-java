package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.ast.Type;

public record LocalVarDecl(Type type, String name) implements Statement {
}
