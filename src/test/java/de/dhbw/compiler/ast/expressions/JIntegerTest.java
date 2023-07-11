package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JIntegerTest {
    JInteger jInteger;
    @BeforeEach
    void setup(){
        jInteger = new JInteger(null, PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, jInteger.getType());

    }
    @Test
    void setType(){
        jInteger.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, jInteger.getType());
    }
}
