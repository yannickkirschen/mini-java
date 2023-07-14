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
    class Leer {
        int a;
        int b;

        Leer(int i, int j){
            a = i;
            b = j;
        }

        void boomethod(int i){
            Leer test = new Leer(i, i);
            int x = test.b;
        }
    }
"""
        );
        TypeCheck t = new TypeCheck();
        p = t.check(p);
        CodeGenerator.generateCode(p);
    }
}
