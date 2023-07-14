package de.dhbw.compiler.ast.statments;

import de.dhbw.compiler.ast.statements.Block;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.ast.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockTest {
    Block block;
    @BeforeEach
    void setup(){
        block = new Block(null, PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept and Block
    @Test
   void getType(){
        assertEquals(PrimitiveType.BOOLEAN, block.getType() );

   }
   @Test
    void setType(){
       block.setType(PrimitiveType.INTEGER);
       assertEquals(PrimitiveType.INTEGER, block.getType() );
    }
}
