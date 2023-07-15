package de.dhbw.compiler.ast;

import de.dhbw.compiler.ast.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldTest {
    Field field0;
    Field field1;
    @BeforeEach
    void setup(){
        field0 = new Field(PrimitiveType.BOOLEAN, null, null);
        field1 = new Field( null,  null);
    }
    @Test
    @DisplayName("getTypeTest")
    void getTypeTest(){
        assertEquals(PrimitiveType.BOOLEAN, field0.getType() );
    }
    @Test
    @DisplayName("setTypeTest1")
    void setTypeTest1(){
        field0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, field0.getType() );
    }

}
