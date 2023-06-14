package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.*;

public class TypeCheck {
    public Program check(Program program) throws SyntaxException, TypeException {
        for (Clazz clazz : program.classes()) {
            BaseClassChecker classVisitor = new ClassChecker(clazz, clazz.methods);
            for (Field field : clazz.fields) {
                clazz.fields.add(classVisitor.check(field));
            }

            for (Method method : clazz.methods) {
                clazz.methods.add(classVisitor.check(method));
            }
        }

        return program;
    }
}
