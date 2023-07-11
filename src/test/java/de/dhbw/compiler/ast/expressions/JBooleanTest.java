package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JBooleanTest {
    JBoolean jBoolean;
    @BeforeEach
    void setup(){
        jBoolean = new JBoolean(null, PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, jBoolean.getType());

    }
    @Test
    void setType(){
        jBoolean.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, jBoolean.getType());
    }
}
