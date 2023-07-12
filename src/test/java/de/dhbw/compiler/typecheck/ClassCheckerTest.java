package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.codegeneration.ObjectType;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import de.dhbw.compiler.typecheck.SyntaxException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.dhbw.compiler.typecheck.ClassChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassCheckerTest {
    ClassChecker classChecker;

    @BeforeEach
    void setup(){
        Field field = new Field(null, null, "boolen");
        List<Field> fields = new ArrayList<>();
        fields.add(0, field);
        AstType astType0  = new AstType("boolean");
        Clazz  clazz = new Clazz(PrimitiveType.INTEGER,
            astType0,
            fields,
            null,
            null);
        List<Field> fieldList = new ArrayList<>();
        List<Method> methodList = new ArrayList<>();
        classChecker = new ClassChecker(clazz, fieldList, methodList);
    }

    @Test
    void testFieldCheck0() throws SyntaxException {
        AstType astType1  = new AstType("Boolean");
        Field field = new Field(PrimitiveType.BOOLEAN,astType1 , "boolean");
        Field field1 = classChecker.check(field);
        assertEquals(PrimitiveType.BOOLEAN, field1.getType());
    }
    @Test
    @DisplayName("check Files and set Type")
    void testFieldCheck1() throws SyntaxException {
        AstType astType1  = new AstType("int");
        Field field = new Field(PrimitiveType.INTEGER,astType1 , "int");

        assertEquals(PrimitiveType.INTEGER, classChecker.check(field).getType());
    }@Test
    @DisplayName("check Files and set Type")
    void testFieldCheck2() throws SyntaxException {
        AstType astType1  = new AstType("char");
        Field field = new Field(PrimitiveType.CHARACTER,astType1 , "char");

        assertEquals(PrimitiveType.CHARACTER, classChecker.check(field).getType());
    }
    @Test
    @DisplayName("check Files and set Type")
    void testFieldCheck3() throws SyntaxException {
        AstType astType1  = new AstType("String");
        Field field = new Field(ObjectType.string(),astType1 , "String");

        assertEquals(ObjectType.string(), classChecker.check(field).getType());
    }
    @Test
    @DisplayName("check Files and set Type")
    void testConstructorCheck0(){
        AstType astType1  = new AstType("boolean");
        Parameter parameter0 = new Parameter(astType1, "parameter0");
        List<Parameter> parameterList = Arrays.asList(parameter0);
        Constructor constructor = new Constructor(PrimitiveType.CHARACTER, parameterList, null);
        System.out.println();
    }

}
