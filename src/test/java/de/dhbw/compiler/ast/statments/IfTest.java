package de.dhbw.compiler.ast.statments;

import de.dhbw.compiler.ast.statements.If;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IfTest {
    If if0;
    If if1;
    @BeforeEach
    void setup(){
        if0 = new If(null,null,null,PrimitiveType.BOOLEAN);
        if1 = new If(null, null, null);
    }

    //IDk if we need to test accept and if
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, if0.getType());

    }
    @Test
    void setType(){
        if0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, if0.getType() );
    }
}
