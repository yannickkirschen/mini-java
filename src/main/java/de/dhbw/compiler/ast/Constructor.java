package de.dhbw.compiler.ast;

import de.dhbw.compiler.ast.statements.Statement;

import java.util.List;

public record Constructor(List<Parameter> parameters, Statement body) {
}
