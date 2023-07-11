package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstVarTest {
    InstVar instVar0;
    InstVar instVar1;
    @BeforeEach
    void setup(){
        instVar0 = new InstVar(null, null, PrimitiveType.BOOLEAN);
        instVar1 = new InstVar(null,  null);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, instVar0.getType());

    }
    @Test
    void setType(){
        instVar0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, instVar0.getType());
    }
}
