package de.dhbw.compiler.ast.stmtexprs;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewTest {
    New new0;
    New new1;

    @BeforeEach
    void setup() {
        new0 = new New(null, null, PrimitiveType.BOOLEAN);
        new1 = new New(null, null);
    }
    //again how should I test the accept
    @Test
    @DisplayName("")
    void getTypeTest(){
        assertEquals(PrimitiveType.BOOLEAN, new0.getType() );
    }
    @Test
    @DisplayName("")
    void setTypeTest(){
        new0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, new0.getType() );
    }

}
