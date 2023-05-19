package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.typecheck.*;
import de.dhbw.compiler.typecheck.model.*;

import java.util.*;

public class ClassVisitor implements BaseClassVisitor {
    private final BaseMethodVisitor methodVisitor;

    private final TypedClazz clazz;
    private final List<Method> methods;
    private final List<TypedMethod<? extends Statement>> typedMethods = new LinkedList<>();

    public ClassVisitor(TypedClazz clazz, List<Method> methods) {
        this.clazz = clazz;
        this.methods = methods;

        this.methodVisitor = new MethodVisitor(clazz, this);
    }

    @Override
    public TypedField visit(Field field) throws SyntaxException {
        switch (field.type().name()) {
            case "Boolean", "boolean", "Integer", "int", "Character", "char", "String" -> {
                TypedField f = new TypedField(new TypedType(field.type().name()), field.name());
                clazz.typedFields().add(f);
                return f;
            }
            default -> throw new SyntaxException("Unexpected field type: %s", field.type().name());
        }
    }

    @Override
    public TypedMethod<? extends Statement> visit(Method method) throws SyntaxException, TypeException {
        return methodVisitor.visit(method);
    }

    @Override
    public TypedMethod<? extends Statement> visit(String methodName) throws SyntaxException, TypeException {
        Optional<TypedMethod<? extends Statement>> optionalTypedMethod = typedMethods.stream().filter(typedMethod -> typedMethod.name().equals(methodName)).findFirst();
        if (optionalTypedMethod.isPresent()) {
            return optionalTypedMethod.get();
        }

        for (Method method : methods) {
            if (method.name().equals(methodName)) {
                TypedMethod<? extends Statement> typedMethod = visit(method);
                typedMethods.add(typedMethod);
                return typedMethod;
            }
        }

        throw new SyntaxException("Cannot resolve method %s in type %s.", methodName, clazz.name());
    }
}
