package de.dhbw.compiler.ast;

import de.dhbw.compiler.ast.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodTest {
    Method method0;
    Method method1;

    @BeforeEach
    void setup(){
        method0 = new Method(PrimitiveType.BOOLEAN, null, null, null, null);
        method1 = new Method( null, null, null, null);
    }
    @Test
    @DisplayName("")
    void getTypeTest(){
        assertEquals(PrimitiveType.BOOLEAN, method0.getType() );
    }
    @Test
    @DisplayName("")
    void setTypeTest1(){
        method0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, method0.getType() );
    }
}
