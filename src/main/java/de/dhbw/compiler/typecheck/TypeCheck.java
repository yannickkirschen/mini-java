package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.typecheck.model.*;
import de.dhbw.compiler.typecheck.visitor.*;

import java.util.*;

public class TypeCheck {
    public TypedProgram check(Program program) throws SyntaxException, TypeException {
        List<TypedClazz> typedClasses = new ArrayList<>(program.classes().size());
        for (Clazz clazz : program.classes()) {
            TypedClazz typedClazz = new TypedClazz(clazz.name().name(), new ArrayList<>(clazz.fields().size()), new ArrayList<>(clazz.methods().size()));
            typedClasses.add(typedClazz);

            BaseClassVisitor classVisitor = new ClassVisitor(typedClazz, clazz.methods());
            for (Field field : clazz.fields()) {
                typedClazz.typedFields().add(classVisitor.visit(field));
            }

            for (Method method : clazz.methods()) {
                typedClazz.typedMethods().add(classVisitor.visit(method));
            }
        }

        return new TypedProgram(typedClasses);
    }
}
