package de.dhbw.ast;

import de.dhbw.ast.statements.Statement;

import java.util.List;

public record Method(Type returnType, String name, List<Parameter> parameters, Statement statement) {
}
