package de.dhbw.compiler;

import de.dhbw.compiler.ast.Program;
import de.dhbw.compiler.codegeneration.CodeGenerator;
import de.dhbw.compiler.parser.Parser;
import de.dhbw.compiler.typecheck.SyntaxException;
import de.dhbw.compiler.typecheck.TypeCheck;
import de.dhbw.compiler.typecheck.TypeException;

public class Compiler {
    public static void main(String[] args) throws SyntaxException, TypeException {
        Program p = Parser.parse(
            """
class NiceClass {
    int i;

    public NiceClass(){}

    public int do(){
        i = 10 ;
        return i;
    }
}
    """);

        TypeCheck t = new TypeCheck();
        p = t.check(p);
        CodeGenerator.generateCode(p);
    }
}
