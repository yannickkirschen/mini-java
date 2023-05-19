package de.dhbw.compiler.typecheck.model;

import de.dhbw.compiler.ast.statements.Statement;

public record TypedStatement<T extends Statement>(TypedType type, T statement) {
}
