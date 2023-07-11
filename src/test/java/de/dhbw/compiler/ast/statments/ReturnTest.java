package de.dhbw.compiler.ast.statments;

import de.dhbw.compiler.ast.statements.Return;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReturnTest {
    Return return0;
    @BeforeEach
    void setup(){
        return0 = new Return(null, PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, return0.getType());

    }
    @Test
    void setType(){
        return0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, return0.getType() );
    }
}
