package de.dhbw.compiler.ast;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import de.dhbw.compiler.ast.Parameter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterTest {
    Parameter parameter0;
    Parameter parameter1;

    @BeforeEach
    void setup(){
        AstType astType = new AstType("boolean");
        parameter0 = new Parameter(PrimitiveType.BOOLEAN,astType,"parameter");
        parameter1 = new Parameter(astType, "paramater1");
    }
    @Test
    @DisplayName("")
    void getTypeTest0(){
        assertEquals(PrimitiveType.BOOLEAN, parameter0.getType() );
    }
    @Test
    @DisplayName("")
    void getTypeTest1(){
        assertEquals(PrimitiveType.BOOLEAN, parameter1.getType() );
    }
    @Test
    @DisplayName("")
    void setTypeTest0(){
        parameter0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, parameter0.getType() );
    }
    @Test
    @DisplayName("")
    void setTypeTest1(){
        parameter1.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, parameter1.getType() );
    }
}
