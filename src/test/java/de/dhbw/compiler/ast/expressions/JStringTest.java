package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JStringTest {
    JString jString;
    @BeforeEach
    void setup(){
        jString = new JString(null, PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, jString.getType());

    }
    @Test
    void setType(){
        jString.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, jString.getType());
    }
}
