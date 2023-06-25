package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.Clazz;
import de.dhbw.compiler.ast.Field;
import de.dhbw.compiler.ast.Method;
import de.dhbw.compiler.ast.Program;

import java.util.ArrayList;
import java.util.List;

public class TypeCheck {
    public Program check(Program program) throws SyntaxException, TypeException {
        for (Clazz clazz : program.classes()) {
            List<Field> checkedFields = new ArrayList<>(clazz.fields.size());
            List<Method> checkedMethods = new ArrayList<>(clazz.methods.size());

            BaseClassChecker classVisitor = new ClassChecker(clazz, checkedFields, checkedMethods);
            for (Field field : clazz.fields) {
                checkedFields.add(classVisitor.check(field));
            }

            for (Method method : clazz.methods) {
                checkedMethods.add(classVisitor.check(method));
            }

            clazz.fields = checkedFields;
            clazz.methods = checkedMethods;
        }
        return program;
    }
}
