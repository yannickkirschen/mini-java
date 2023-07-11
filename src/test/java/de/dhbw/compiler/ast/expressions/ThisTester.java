package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThisTester {
    This This_;
    @BeforeEach
    void setup(){
        This_ = new This(PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test this
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, This_.getType());

    }
    @Test
    void setType(){
        This_.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, This_.getType());
    }
}
