package de.dhbw.compiler.ast.statments;

import de.dhbw.compiler.ast.statements.StmtExprStmt;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StmtExprStmtTest {
    StmtExprStmt stmtExprStmt;
    @BeforeEach
    void setup(){
        stmtExprStmt = new StmtExprStmt(null, PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, stmtExprStmt.getType());

    }
    @Test
    void setType(){
        stmtExprStmt.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, stmtExprStmt.getType() );
    }
}
