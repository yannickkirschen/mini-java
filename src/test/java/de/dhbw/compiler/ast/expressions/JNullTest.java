package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JNullTest {
    JNull jNull;
    @BeforeEach
    void setup(){
        jNull = new JNull(PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, jNull.getType());

    }
    @Test
    void setType(){
        jNull.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, jNull.getType());
    }
}
