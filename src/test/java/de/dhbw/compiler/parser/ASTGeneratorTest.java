package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import de.dhbw.compiler.parser.antlr.MinijavaLexer;
import de.dhbw.compiler.parser.antlr.MinijavaParser;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.debug.ParseTreeBuilder;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.codegen.model.decl.TokenDecl;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNodeImpl;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.pattern.TokenTagToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.dhbw.compiler.parser.ASTGenerator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ASTGeneratorTest {
    ASTGenerator astGenerator;
    MinijavaParser minijavaParser;

    @BeforeEach
    void setup() {
        astGenerator = new ASTGenerator();
        // minijavaParser = new MinijavaParser(); Vlt ein großes erstellen
    }

    @Test
    void generateAST() {
       MinijavaParser.ProgramContext programContext = new MinijavaParser.ProgramContext(new ParserRuleContext(),0);
       programContext.class_(0);
        assertEquals(new Program(new ArrayList<Clazz>()),ASTGenerator.generateAST(programContext));
    }
    @Test
    void  generateTypeTest0(){
        MinijavaParser.TypeContext typeContext = new MinijavaParser.TypeContext(new ParserRuleContext(),0);
        assertEquals(0,generateType(typeContext));
    }
}
/*
    @Test
    void  generateTypeTest1(){
        //  MinijavaParser.TypeContext typeContext = new MinijavaParser.TypeContext();
        AstType astType = generateType(typeContext);
        assertEquals("Bool",astType.name() );
    }
    @Test
    void  generateTypeTest2(){
        //  MinijavaParser.TypeContext typeContext = new MinijavaParser.TypeContext();
        AstType astType = generateType(typeContext);
        assertEquals("Char",astType.name() );
    }
    @Test
    void  generateTypeTest3(){
        //  MinijavaParser.TypeContext typeContext = new MinijavaParser.TypeContext();
        AstType astType = generateType(typeContext);
        assertEquals("String",astType.name() );
    }
    @Test
    void  generateTypeTest4(){
        //  MinijavaParser.TypeContext typeContext = new MinijavaParser.TypeContext();
        AstType astType = generateType(typeContext);
        assertEquals("Void",astType.name() );
    }
    @Test
    void  generateTypeTest5(){
        //  MinijavaParser.TypeContext typeContext = new MinijavaParser.TypeContext();
        AstType astType = generateType(typeContext);
        assertEquals("refType",astType.name());
    }
    @Test
    void generateFieldTest(){
        //MinijavaParser.VarDeclContext varDeclContext = new MinijavaParser.VarDeclContext();
        AstType astType = "boolean";
        assertEquals(new Field(astType, "boolean"), ASTGenerator.generateField(varDeclContext));
    }
    @Test
    void generateMethTest(){
        //MinijavaParser.MethContext methContext = new MinijavaParser.MethContext()
        assertEquals(new Method(new AstType("boolean"), "boolean",null,null), ASTGenerator.generateMeth(methContext));
    }
    @Test
    void generateParams(){
        //MinijavaParser.ParamsContext paramsContext = new MinijavaParser.ParamsContext()
        List<Parameter> params = new ArrayList<>();
        assertEquals(params, ASTGenerator.generateParams(paramsContext));
    }
}
*/
