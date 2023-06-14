package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.codegeneration.*;
import de.dhbw.compiler.typecheck.*;

import java.util.*;

public class ClassChecker implements BaseClassChecker {
    private final BaseMethodChecker methodVisitor;

    private final Clazz clazz;
    private final List<Method> methods;
    private final List<Method> typedMethods = new LinkedList<>();

    public ClassChecker(Clazz clazz, List<Method> methods) {
        this.clazz = clazz;
        this.methods = methods;

        this.methodVisitor = new MethodChecker(clazz, this);
    }

    @Override
    public Field check(Field field) throws SyntaxException {
        switch (field.getType().getName()) {
            case "Boolean", "boolean" -> field.setType(PrimitiveType.BOOLEAN);
            case "Integer", "int" -> field.setType(PrimitiveType.INTEGER);
            case "Character", "char" -> field.setType(PrimitiveType.CHARACTER);
            case "String" -> field.setType(ObjectType.string());
            default -> throw new SyntaxException("Unexpected field type: %s", field.getType().getName());
        }

        clazz.fields.add(field);
        return field;
    }

    @Override
    public Method check(Method method) throws SyntaxException, TypeException {
        return methodVisitor.check(method);
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

        throw new SyntaxException("Cannot resolve method %s in type %s.", methodName, clazz.name);
    }
}
