package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.Clazz;
import de.dhbw.compiler.ast.Program;

public class CodeGenerator {
    public static void generateCode(Program p){
        CodeGenVisitor visitor = new CodeGenVisitor();
        for(Clazz c : p.classes()){
            visitor.visitClass(c);
        }
    }
}
