package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodCallTest {
    MethodCall methodCall0;
    MethodCall methodCall1;

    @BeforeEach
    void setup() {
        methodCall0 = new MethodCall(null, null, null, PrimitiveType.BOOLEAN);
        methodCall1 = new MethodCall(null, null, null);
    }
    //again how should I test the accept
    @Test
    @DisplayName("getTypeTest")
    void getTypeTest(){
        assertEquals(PrimitiveType.BOOLEAN, methodCall0.getType() );
    }
    @Test
    @DisplayName("setTypeTest")
    void setTypeTest(){
        methodCall0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, methodCall0.getType() );
    }
}
