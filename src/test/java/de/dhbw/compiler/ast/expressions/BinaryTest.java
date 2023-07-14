package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.ast.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTest {
    Binary binary0;
    Binary binary1;
    @BeforeEach
    void setup(){
        binary0 = new Binary(null, null,null, PrimitiveType.BOOLEAN);
        binary1 = new Binary(null, null, null);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, binary0.getType());

    }
    @Test
    void setType(){
        binary0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, binary0.getType());
    }
}
