package de.dhbw.compiler.ast;

import de.dhbw.compiler.ast.statements.Statement;

import java.util.List;

public record Method(Type returnType, String name, List<Parameter> parameters, Statement statement) {
}
