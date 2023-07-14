package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.ObjectType;
import de.dhbw.compiler.ast.PrimitiveType;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ClassChecker implements BaseClassChecker {
    private final BaseMethodChecker methodChecker;
    private final BaseStatementChecker statementChecker;

    private final String className;
    private final List<Field> fields;
    private final List<Method> methods;
    private final List<Method> typedMethods = new LinkedList<>();

    public ClassChecker(Clazz clazz, List<Field> fields, List<Method> methods) {
        className = clazz.name.name();
        this.fields = fields;
        this.methods = methods;

        this.methodChecker = new MethodChecker(clazz, this);
        this.statementChecker = methodChecker.getStatementChecker();
    }

    @Override
    public Field check(Field field) throws SyntaxException {
        switch (field.astType.name()) {
            case "Boolean", "boolean" -> field.setType(PrimitiveType.BOOLEAN);
            case "Integer", "int" -> field.setType(PrimitiveType.INTEGER);
            case "Character", "char" -> field.setType(PrimitiveType.CHARACTER);
            case "String" -> field.setType(ObjectType.string());
            default -> throw new SyntaxException("Unexpected field type: %s", field.astType.name());
        }

        fields.add(field);
        return field;
    }

    @Override
    public Constructor check(Constructor constructor) throws SyntaxException, TypeException {
        for (Parameter parameter : constructor.getParameterList()) {
            parameter.setType(methodChecker.check(parameter).getType());
        }


        if (constructor.getBody() != null) {
            statementChecker.check(constructor.getBody(), constructor.getParameterList());
        }

        constructor.setType(new ObjectType(className));
        return constructor;
    }

    @Override
    public Method check(Method method) throws SyntaxException, TypeException {
        return methodChecker.check(method);
    }

    @Override
    public Method check(String methodName) throws SyntaxException, TypeException {
        Optional<Method> optionalTypedMethod = typedMethods.stream().filter(typedMethod -> typedMethod.name.equals(methodName)).findFirst();
        if (optionalTypedMethod.isPresent()) {
            return optionalTypedMethod.get();
        }

        for (Method method : methods) {
            if (method.name.equals(methodName)) {
                Method typedMethod = check(method);
                typedMethods.add(typedMethod);
                return typedMethod;
            }
        }

        throw new SyntaxException("Cannot resolve method %s in type %s.", methodName, className);
    }
}
