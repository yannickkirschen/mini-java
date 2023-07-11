package de.dhbw.compiler.ast.expressions;

import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StmtExprExprTest {
    StmtExprExpr stmtExprExpr;
    @BeforeEach
    void setup(){
        stmtExprExpr = new StmtExprExpr(null, PrimitiveType.BOOLEAN);
    }

    //IDk if we need to test accept
    @Test
    void getType(){
        assertEquals(PrimitiveType.BOOLEAN, stmtExprExpr.getType());

    }
    @Test
    void setType(){
        stmtExprExpr.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, stmtExprExpr.getType());
    }
}
