package de.dhbw.compiler.typecheck.model;

import de.dhbw.compiler.ast.statements.Statement;

import java.util.List;

public record TypedMethod<T extends Statement>(TypedType returnTypedType, String name,
                                               List<TypedParameter> typedParameters,
                                               TypedStatement<T> typedStatement) {
}
