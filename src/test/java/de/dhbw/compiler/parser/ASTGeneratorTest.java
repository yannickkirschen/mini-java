package de.dhbw.compiler.parser;
/*
import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import de.dhbw.compiler.parser.antlr.MinijavaLexer;
import de.dhbw.compiler.parser.antlr.MinijavaParser;
import org.antlr.v4.runtime.Token;
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
    void setup(){
        astGenerator = new ASTGenerator();
       // minijavaParser = new MinijavaParser(); Vlt ein großes erstellen
    }
    @Test
    void generateAST(){
        //MinijavaParser.ProgrammContext programmContext = new MinijavaParser.ProgrammContext();
        assertEquals(new Program(null),ASTGenerator.generateAST(programmContext));
    }

    @Test
    void generateClazzTest(){
        //MinijavaParser.ClassContext classContext = new MinijavaParser.ClassContext();
        assertEquals(new Clazz(new AstType("Clazz"),null, null, null),ASTGenerator.generateClazz(classContext()));
    }
    @Test
    void generateConstructorTest(){
        //  MinijavaParser.ConstructorContext constructorContext = new MinijavaParser.ConstructorContext();
        assertEquals(new Constructor(null,null),ASTGenerator.generateConstructor(constructorContext));
    }
    @Test
    void  generateTypeTest0(){
      //  MinijavaParser.TypeContext typeContext = new MinijavaParser.TypeContext();
        AstType astType = generateType(typeContext);
        assertEquals("Int",astType.name() );
    }
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
