package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.expressions.LocalOrFieldVar;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.codegeneration.*;
import de.dhbw.compiler.typecheck.*;

import java.util.*;

public class MethodChecker implements BaseMethodChecker {
    private final String className;

    private final BaseStatementChecker statementChecker;

    public MethodChecker(Clazz clazz, BaseClassChecker baseClassChecker) {
        this.className = clazz.name.name();

        List<LocalOrFieldVar> localVariables = new LinkedList<>();
        BaseStatementExpressionChecker statementExpressionChecker = new StatementExpressionChecker(className, clazz.fields, clazz.methods, localVariables);
        BaseExpressionChecker expressionChecker = new ExpressionChecker(className, clazz.fields, localVariables, statementExpressionChecker);

        statementExpressionChecker.setBaseClassChecker(baseClassChecker);
        statementExpressionChecker.setExpressionChecker(expressionChecker);

        this.statementChecker = new StatementChecker(className, localVariables, expressionChecker, statementExpressionChecker);
    }

    @Override
    public Method check(Method method) throws SyntaxException, TypeException {
        Statement statement = statementChecker.check(method.statement);

        for (Parameter parameter : method.parameters) {
            parameter.setType(check(parameter).getType());
        }

        method.setType(statement.getType());
        return method;
    }

    @Override
    public Parameter check(Parameter parameter) throws SyntaxException {
        switch (parameter.getType().getName()) {
            case "Boolean", "boolean" -> parameter.setType(PrimitiveType.BOOLEAN);
            case "Integer", "int" -> parameter.setType(PrimitiveType.INTEGER);
            case "Character", "char" -> parameter.setType(PrimitiveType.CHARACTER);
            case "String" -> parameter.setType(ObjectType.string());
            default -> {
                if (parameter.getType().getName().equals(className)) {
                    parameter.setType(new ObjectType(className));
                }

                throw new SyntaxException("Unexpected method argument type: %s", parameter.getType().getName());
            }
        }

        return parameter;
    }
}
