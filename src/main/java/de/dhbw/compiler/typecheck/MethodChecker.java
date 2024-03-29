package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.Clazz;
import de.dhbw.compiler.ast.Method;
import de.dhbw.compiler.ast.Parameter;
import de.dhbw.compiler.ast.expressions.LocalOrFieldVar;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.ast.ObjectType;
import de.dhbw.compiler.ast.PrimitiveType;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class MethodChecker implements BaseMethodChecker {
    private final String className;

    @Getter
    private final BaseStatementChecker statementChecker;

    public MethodChecker(Clazz clazz, BaseClassChecker baseClassChecker) {
        this.className = clazz.name.name();

        List<LocalOrFieldVar> localVariables = new LinkedList<>();
        BaseStatementExpressionChecker statementExpressionChecker = new StatementExpressionChecker(className, clazz.fields, clazz.methods, clazz.constructors, localVariables);
        BaseExpressionChecker expressionChecker = new ExpressionChecker(className, clazz.fields, localVariables, statementExpressionChecker);

        statementExpressionChecker.setBaseClassChecker(baseClassChecker);
        statementExpressionChecker.setExpressionChecker(expressionChecker);

        this.statementChecker = new StatementChecker(className, localVariables, expressionChecker, statementExpressionChecker);
    }

    @Override
    public Method check(Method method) throws SyntaxException, TypeException {
        for (Parameter parameter : method.parameters) {
            parameter.setType(check(parameter).getType());
        }

        Statement statement = statementChecker.check(method.statement, method.parameters);

        switch (method.getAstType().name()) {
            case "Boolean", "boolean" -> method.setType(PrimitiveType.BOOLEAN);
            case "Integer", "int" -> method.setType(PrimitiveType.INTEGER);
            case "Character", "char" -> method.setType(PrimitiveType.CHARACTER);
            case "void" -> method.setType(PrimitiveType.VOID);
            case "String" -> method.setType(ObjectType.string());
            default -> {
                if (method.getType().getName().equals(className)) {
                    method.setType(new ObjectType(className));
                    break;
                }

                throw new SyntaxException("Unexpected method argument type: %s", method.getType().getName());
            }
        }

        if(method.getType() == statement.getType()  || method.getType().getName().equals(statement.getType().getName())){
            return method;
        }
        else {
            throw new SyntaxException("Return-type and method-type must be equal!");
        }
    }

    @Override
    public Parameter check(Parameter parameter) throws SyntaxException {
        switch (parameter.getAstType().name()) {
            case "Boolean", "boolean" -> parameter.setType(PrimitiveType.BOOLEAN);
            case "Integer", "int" -> parameter.setType(PrimitiveType.INTEGER);
            case "Character", "char" -> parameter.setType(PrimitiveType.CHARACTER);
            case "String" -> parameter.setType(ObjectType.string());
            default -> {
                if (parameter.getType().getName().equals(className)) {
                    parameter.setType(new ObjectType(className));
                    break;
                }

                throw new SyntaxException("Unexpected method argument type: %s", parameter.getType().getName());
            }
        }

        return parameter;
    }
}
