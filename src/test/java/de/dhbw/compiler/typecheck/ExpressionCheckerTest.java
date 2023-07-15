package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.codegeneration.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.Expression;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionCheckerTest {
    ExpressionChecker expressionChecker;

    @BeforeEach
    void setup(){
        List<Field> fields = Arrays.asList(new Field(null , null, "field"));
        List<Method> methods = new ArrayList<>();
        List<LocalOrFieldVar> localVars = new ArrayList<>();
        List<Constructor> constructors = new ArrayList<>();
        StatementExpressionChecker statementExpresseionChecker = new StatementExpressionChecker("Null", fields, methods, constructors, localVars);
        LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar("localOrFieldVar", PrimitiveType.BOOLEAN);
        List<LocalOrFieldVar> localVariables = Arrays.asList(localOrFieldVar);
        AstType astType0 = new AstType("boolean");
        expressionChecker = new ExpressionChecker("Array",fields,localVariables,statementExpresseionChecker);
    }

    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest0() throws SyntaxException, TypeException {
        Binary bin = new Binary("root", new JInteger("3",PrimitiveType.INTEGER),  new JInteger("3",PrimitiveType.INTEGER));
        assertEquals(bin, expressionChecker.check(bin) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest1() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        InstVar instVar = new InstVar(new JInteger("33"), "InstVar");
        assertEquals(instVar, expressionChecker.check(instVar));
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest2() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        JBoolean jBoolean = new JBoolean("false");
        assertEquals(jBoolean, expressionChecker.check(jBoolean) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest3() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
            JCharacter jCharacter = new JCharacter("c");
        assertEquals(jCharacter, expressionChecker.check(jCharacter) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest4() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        JInteger jInteger = new JInteger("0");
        assertEquals(jInteger, expressionChecker.check(jInteger) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest5() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        JNull jNull = new JNull();
        assertEquals(jNull, expressionChecker.check(jNull) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest6() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        JString jString = new JString("0");
        assertEquals(jString, expressionChecker.check(jString));
    }
    @Test
    @DisplayName("check Files and set Type") //Cannot resolve Local Or Field var
    void checkExpressionTest7() throws SyntaxException {//Für alle angegebenen Klassen benötigt
        LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar("localOrFieldVar", PrimitiveType.BOOLEAN);
        assertEquals(localOrFieldVar, expressionChecker.check(localOrFieldVar) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest8() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        StmtExprExpr stmtExprExpr = new StmtExprExpr(new Assign(new JBoolean("true", PrimitiveType.BOOLEAN), new JBoolean("true", PrimitiveType.BOOLEAN),PrimitiveType.BOOLEAN));
        assertEquals(stmtExprExpr, expressionChecker.check(stmtExprExpr) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest9() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        //Super super; //NICHTS DEFINIEREN KÖNENNE
      //  assertEquals(super, expressionChecker.check(super));
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest10() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
      This this_ = new This();
      assertEquals("Array", expressionChecker.check(this_).getType().getName());
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest11() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        Unary unary = new Unary("!", new LocalOrFieldVar("localOrFieldVar"), null);
        assertEquals(PrimitiveType.BOOLEAN, expressionChecker.check(unary).getType() );
    }
    @Test
    void checkBinaryTest0() throws SyntaxException, TypeException {
        JInteger left = new JInteger("0");
        JInteger right = new JInteger("0");
        Binary binary = new Binary("+", left, right);
        assertEquals(PrimitiveType.INTEGER, expressionChecker.check(binary).getType());
    }
    @Test
    void checkBinaryTest1() throws SyntaxException, TypeException {
        JBoolean right = new JBoolean("true");
        JBoolean left = new JBoolean("false");
        Binary binary = new Binary("&&", left, right);
        assertEquals(PrimitiveType.BOOLEAN, expressionChecker.check(binary).getType());
    }

    @Test
    void checkInstVarTest0() throws SyntaxException, TypeException {
        //Wie soll ich den Classnamen Setzen
        //Expression ist mal wieder nicht aus der Richtigen Source
       // Expression thisExpr_ = new Expression(null, null,null, null);
       // InstVar instVar = new InstVar(thisExpr_, "instVar");
      //  assertEquals(thisExpr_, expressionChecker.check(instVar).getType());
    }

    @Test
    void checkJBooleanTest() throws SyntaxException {
        JBoolean jBoolean = new JBoolean("true", null);
        assertEquals(PrimitiveType.BOOLEAN, expressionChecker.check(jBoolean).getType());
    }

    @Test
    void checkJCharakterTest() throws SyntaxException {
        JCharacter jCharacter = new JCharacter("1");
        assertEquals(PrimitiveType.CHARACTER, expressionChecker.check(jCharacter).getType());
    }
    @Test
    void checkJIntegerTest() throws SyntaxException{
        JInteger jInteger = new JInteger("1");
        assertEquals(PrimitiveType.INTEGER, expressionChecker.check(jInteger).getType());
    }
    @Test
    void checkJNullTest() throws SyntaxException{
        JNull jNull = new JNull();
        assertEquals(ObjectType.jNull().getName(), expressionChecker.check(jNull).getType().getName());
    }
    @Test
    void checkJStringTest() throws SyntaxException{
        JString jString = new JString("1");
        assertEquals(ObjectType.string().getName(), expressionChecker.check(jString).getType().getName());
    }
    @Test
    void checkStmtExprExprTest() throws SyntaxException, TypeException {
        StmtExprExpr stmtExprExpr = new StmtExprExpr(new Assign(new JBoolean("true", PrimitiveType.BOOLEAN), new JBoolean("false", PrimitiveType.BOOLEAN)), null);
        assertEquals(stmtExprExpr.getType(), expressionChecker.check(stmtExprExpr).getType());
    }
    @Test
    void checkLocalOrFieldVarTest0() throws SyntaxException {
        LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar("localOrFieldVar");
        assertEquals(PrimitiveType.BOOLEAN, expressionChecker.check(localOrFieldVar).getType());
    }
    @Test
    void checkLocalOrFieldVarTest1() throws SyntaxException {
        LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar("field");
        assertEquals(localOrFieldVar.getType(), expressionChecker.check(localOrFieldVar).getType());
    }
    @Test
    void checkSuperTest(){
        Super super_ = new Super(null);
        assertEquals("Array", expressionChecker.check(super_).getType().getName());
    }
    @Test
    void checkThisTest(){
        This this_ = new This(null);
        assertEquals("Array", expressionChecker.check(this_).getType().getName());
    }
    @Test
    void checkUnaryTest0() throws SyntaxException, TypeException {
        Unary unary = new Unary("+", new LocalOrFieldVar("localOrFieldVar",PrimitiveType.INTEGER));
        assertEquals(PrimitiveType.INTEGER, expressionChecker.check(unary).getType());
    }
    @Test
    void checkUnaryTest1() throws SyntaxException, TypeException {
        Unary unary = new Unary("!", new LocalOrFieldVar("localOrFieldVar",PrimitiveType.BOOLEAN));
        assertEquals(PrimitiveType.BOOLEAN, expressionChecker.check(unary).getType());
    }
}
