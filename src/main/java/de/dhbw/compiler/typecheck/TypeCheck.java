package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.*;

import java.util.ArrayList;
import java.util.List;

public class TypeCheck {
    public Program check(Program program) throws SyntaxException, TypeException {
        for (Clazz clazz : program.classes()) {
            List<Field> checkedFields = new ArrayList<>(clazz.fields.size());
            List<Method> checkedMethods = new ArrayList<>(clazz.methods.size());
            List<Constructor> checkedConstructors = new ArrayList<>(clazz.constructors.size());

            BaseClassChecker classVisitor = new ClassChecker(clazz, checkedFields, checkedMethods, checkedConstructors);
            for (Field field : clazz.fields) {
                checkedFields.add(classVisitor.check(field));
            }

            for (Constructor constructor : clazz.constructors) {
                checkedConstructors.add(classVisitor.check(constructor));
            }

            for (Method method : clazz.methods) {
                checkedMethods.add(classVisitor.check(method));
            }

            clazz.fields = checkedFields;
            clazz.constructors = checkedConstructors;
            clazz.methods = checkedMethods;
        }
        return program;
    }
}
