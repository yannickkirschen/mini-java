package de.dhbw.compiler.ast;

import java.util.List;

public record Clazz(Type name, List<Field> fields) {
}
