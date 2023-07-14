package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.ast.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalOrFieldVarTest {
    LocalOrFieldVar localOrFieldVar;
    @BeforeEach
    void setup(){
        localOrFieldVar = new LocalOrFieldVar(null, PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, localOrFieldVar.getType());

    }
    @Test
    void setType(){
        localOrFieldVar.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, localOrFieldVar.getType());
    }
}
