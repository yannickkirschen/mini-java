package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.ast.Parameter;
import de.dhbw.compiler.ast.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignTest {
    Assign assign0;
    Assign assign1;

    @BeforeEach
    void setup() {
        assign0 = new Assign(null, null, PrimitiveType.BOOLEAN);
        assign1 = new Assign(null, null);
    }
    @Test
    @DisplayName("getTypeTest")
    void getTypeTest(){
        assertEquals(PrimitiveType.BOOLEAN, assign0.getType() );
    }
    @Test
    @DisplayName("setTypeTest")
    void setTypeTest(){
        assign0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, assign0.getType() );
    }
}
