package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.ast.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnaryTest {
    Unary unary0;
    Unary unary1;

    @BeforeEach
    void setup(){
        unary0 = new Unary(null, null,PrimitiveType.BOOLEAN);
        unary1 = new Unary(null, null);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, unary0.getType());

    }
    @Test
    void setType(){
        unary0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, unary0.getType());
    }
}
