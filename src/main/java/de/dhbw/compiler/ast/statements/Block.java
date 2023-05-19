package de.dhbw.compiler.ast.statements;

import java.util.List;

public record Block(List<Statement> stmts) implements Statement {
}
