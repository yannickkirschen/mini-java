package de.dhbw.compiler.ast.statments;

import de.dhbw.compiler.ast.statements.LocalVarDecl;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalVarDeclTest {
    LocalVarDecl localVarDecl0;
    LocalVarDecl localVarDecl1;
    @BeforeEach
    void setup(){
        localVarDecl0 = new LocalVarDecl(null,null,PrimitiveType.BOOLEAN);
        localVarDecl1 = new LocalVarDecl(null, null);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, localVarDecl0.getType());

    }
    @Test
    void setType(){
        localVarDecl0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, localVarDecl0.getType() );
    }
}
