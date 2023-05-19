package de.dhbw.compiler.typecheck.model;

import de.dhbw.compiler.ast.statements.Statement;

import java.util.List;

public record TypedClazz(String name, List<TypedField> typedFields,
                         List<TypedMethod<? extends Statement>> typedMethods) {
}
