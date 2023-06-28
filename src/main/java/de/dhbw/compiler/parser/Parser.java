package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.Program;
import de.dhbw.compiler.parser.antlr.MinijavaLexer;
import de.dhbw.compiler.parser.antlr.MinijavaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Parser {
    public static Program parse(String inputString) {
        CharStream input = CharStreams.fromString( inputString);

        MinijavaLexer lexer = new MinijavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MinijavaParser parser = new MinijavaParser(tokens);
        MinijavaParser.ProgramContext tree = parser.program();

        return ASTGenerator.generateAST(tree);
    }
}
