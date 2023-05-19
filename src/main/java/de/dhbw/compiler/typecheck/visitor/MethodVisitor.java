package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.typecheck.*;
import de.dhbw.compiler.typecheck.model.*;

import java.util.*;

public class MethodVisitor implements BaseMethodVisitor {
    private final String className;

    private final BaseStatementVisitor statementVisitor;

    public MethodVisitor(TypedClazz clazz, BaseClassVisitor baseClassVisitor) {
        this.className = clazz.name();

        List<TypedLocalVar> localVariables = new LinkedList<>();
        BaseStatementExpressionVisitor statementExpressionVisitor = new StatementExpressionVisitor(clazz.name(), clazz.typedFields(), clazz.typedMethods(), localVariables);
        BaseExpressionVisitor expressionVisitor = new ExpressionVisitor(clazz.name(), clazz.typedFields(), localVariables, statementExpressionVisitor);

        statementExpressionVisitor.setBaseClassVisitor(baseClassVisitor);
        statementExpressionVisitor.setExpressionVisitor(expressionVisitor);

        this.statementVisitor = new StatementVisitor(clazz.name(), localVariables, expressionVisitor, statementExpressionVisitor);
    }

    @Override
    public TypedMethod<? extends Statement> visit(Method method) throws SyntaxException, TypeException {
        TypedStatement<? extends Statement> typedStatement = statementVisitor.visit(method.statement());

        List<TypedParameter> typedParameters = new ArrayList<>(method.parameters().size());
        for (Parameter parameter : method.parameters()) {
            typedParameters.add(visit(parameter));
        }

        return new TypedMethod<>(new TypedType(typedStatement.type().name()), method.name(), typedParameters, typedStatement);
    }

    @Override
    public TypedParameter visit(Parameter parameter) throws SyntaxException {
        switch (parameter.type().name()) {
            case "Boolean", "boolean", "Integer", "int", "Character", "char", "String" -> {
                return new TypedParameter(new TypedType(parameter.type().name()), parameter.name());
            }
            default -> {
                if (parameter.type().name().equals(className)) {
                    return new TypedParameter(new TypedType(parameter.type().name()), parameter.name());
                }

                throw new SyntaxException("Unexpected method argument type: %s", parameter.type().name());
            }
        }
    }
}
