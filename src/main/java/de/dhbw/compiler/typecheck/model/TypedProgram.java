package de.dhbw.compiler.typecheck.model;

import java.util.List;

public record TypedProgram(List<TypedClazz> classes) {
}
