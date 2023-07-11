package de.dhbw.compiler.ast.statments;

import de.dhbw.compiler.ast.statements.While;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhileTest {
    While while0;
    While while1;
    @BeforeEach
    void setup(){
        while0 = new While(null, null,PrimitiveType.BOOLEAN);
        while1 = new While(null, null);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, while0.getType());

    }
    @Test
    void setType(){
        while0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, while0.getType() );
    }
}
