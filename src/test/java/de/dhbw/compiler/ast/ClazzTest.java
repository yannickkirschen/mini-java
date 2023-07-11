package de.dhbw.compiler.ast;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClazzTest {
    Clazz clazz0;
    Clazz clazz1;
    @BeforeEach
    void setup(){
        clazz0 = new Clazz(PrimitiveType.BOOLEAN, null, null, null, null);
        clazz1 = new Clazz( null, null, null, null);
    }
    @Test
    @DisplayName("")
    void getTypeTest(){
        assertEquals(PrimitiveType.BOOLEAN, clazz0.getType() );
    }
    @Test
    @DisplayName("")
    void setTypeTest1(){
        clazz0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, clazz0.getType() );
    }

}
