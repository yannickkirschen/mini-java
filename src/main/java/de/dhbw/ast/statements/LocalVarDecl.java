package de.dhbw.ast.statements;

import de.dhbw.ast.Type;

public record LocalVarDecl(Type type, String name) implements Statement {
}
