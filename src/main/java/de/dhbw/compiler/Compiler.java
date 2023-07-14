package de.dhbw.compiler;

import de.dhbw.compiler.ast.Program;
import de.dhbw.compiler.codegeneration.CodeGenerator;
import de.dhbw.compiler.parser.Parser;
import de.dhbw.compiler.typecheck.SyntaxException;
import de.dhbw.compiler.typecheck.TypeCheck;
import de.dhbw.compiler.typecheck.TypeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Compiler {
    public static void main(String[] args) throws SyntaxException, TypeException, IOException {
        String code;
        if(args.length == 1){
            code = Files.readString(Path.of(args[0]));
        }
        else{
            code =
                """
                 class Leer  {boolean x; void boomethod(){ this.x = false;}}
                """;
        }
        Program p = Parser.parse(code);
        TypeCheck t = new TypeCheck();
        p = t.check(p);
        CodeGenerator.generateCode(p);
    }
}
