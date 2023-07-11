package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JCharacterTest {
    JCharacter jCharacter;
    @BeforeEach
    void setup(){
        jCharacter = new JCharacter(null, PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, jCharacter.getType());

    }
    @Test
    void setType(){
        jCharacter.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, jCharacter.getType());
    }
}
