package de.dhbw.compiler.ast;

import de.dhbw.compiler.ast.statements.Block;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructorTest {
    Constructor constructor0;
    Constructor constructor1;
    public List<Parameter> parameterList;
    public List<Parameter> parameterList1;
    public Statement body;
    public Statement body1;
    @BeforeEach
    void setup(){
        body = new Block(null);
        constructor0 = new Constructor(PrimitiveType.BOOLEAN, parameterList, body);
        constructor1 = new Constructor(parameterList, body);
    }
    //How shoud I accept(MethodeCodeVisitor
    @Test
    @DisplayName("")
    void getParameterTest(){
        assertEquals(parameterList, constructor0.getParameterList());
    }
    @Test
    @DisplayName("")
    void setParameterTest(){
        constructor0.setParameterList(parameterList1);
        assertEquals(parameterList1, constructor0.getParameterList());
    }
    @Test
    @DisplayName("")
    void getBodyTest(){
        assertEquals(body, constructor0.getBody());
    }
    @Test
    @DisplayName("")
    void setBodyTest(){
        constructor0.setBody(body1);
        assertEquals(body1, constructor0.getBody());
    }
    @Test
    @DisplayName("")
    void getTypeTest(){
        assertEquals(PrimitiveType.BOOLEAN, constructor0.getType());
    }
    @Test
    @DisplayName("")
    void setTypeTest(){
        constructor0.setType(PrimitiveType.INTEGER);
        assertEquals(PrimitiveType.INTEGER, constructor0.getType());
    }
}
