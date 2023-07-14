package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.ast.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperTest {
    Super super_;
    @BeforeEach
    void setup(){
        super_ = new Super(PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, super_.getType());

    }
    @Test
    void setType(){
        super_.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, super_.getType());
    }
}
