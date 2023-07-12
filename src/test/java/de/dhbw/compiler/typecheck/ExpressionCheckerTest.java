package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.AstType;
import de.dhbw.compiler.ast.Field;
import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.codegeneration.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.Expression;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionCheckerTest {
    ExpressionChecker expressionChecker;

    @BeforeEach
    void setup(){

        StatementExpressionChecker statementExpresseionChecker = new StatementExpressionChecker("Null", null, null, null);
        LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar("eins", PrimitiveType.BOOLEAN);
        List<LocalOrFieldVar> localVariables = Arrays.asList(localOrFieldVar);
        AstType astType0 = new AstType("boolean");
        Field field0 = new Field(PrimitiveType.BOOLEAN,astType0 ,"field0");
        List<Field> fields = Arrays.asList(field0);
        expressionChecker = new ExpressionChecker("Array",fields,localVariables,statementExpresseionChecker);
    }

    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest0() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        int i = 1;
        Expression expression = new Expression(i, null, null);
        Binary bin = new Binary("root", null, null);
        assertEquals(bin, expressionChecker.check(bin) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest1() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        InstVar instVar = new InstVar(null, "InstVar");
        assertEquals(instVar, expressionChecker.check(instVar) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest2() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        JBoolean jBoolean = new JBoolean("0");
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
    @DisplayName("check Files and set Type")
    void checkExpressionTest7() throws SyntaxException {//Für alle angegebenen Klassen benötigt
        LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar("localOrFieldVar");
        assertEquals(localOrFieldVar, expressionChecker.check(localOrFieldVar) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest8() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        StmtExprExpr stmtExprExpr = new StmtExprExpr(null);
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
      assertEquals(this, expressionChecker.check(this_) );
    }
    @Test
    @DisplayName("check Files and set Type")
    void checkExpressionTest11() throws SyntaxException, TypeException {//Für alle angegebenen Klassen benötigt
        Unary unary = new Unary(null, null, null);
        assertEquals(unary, expressionChecker.check(unary) );
    }
    @Test
    @DisplayName("")
    void checkBinaryTest0() throws SyntaxException, TypeException {
        JInteger left = new JInteger("0");
        JInteger right = new JInteger("0");
        Binary binary = new Binary("+", left, right);
        assertEquals(PrimitiveType.INTEGER, expressionChecker.check(binary).getType());
    }
    @Test
    @DisplayName("")
    void checkBinaryTest1() throws SyntaxException, TypeException {
        JInteger right = new JInteger("0");
        JBoolean left = new JBoolean("0");
        Binary binary = new Binary("&&", left, right);
        assertEquals(PrimitiveType.BOOLEAN, expressionChecker.check(binary).getType());
    }

    @Test
    @DisplayName("")
    void checkInstVarTest0() throws SyntaxException, TypeException {
        //Wie soll ich den Classnamen Setzen
        //Expression ist mal wieder nicht aus der Richtigen Source
       // Expression thisExpr_ = new Expression(null, null,null, null);
       // InstVar instVar = new InstVar(thisExpr_, "instVar");
      //  assertEquals(thisExpr_, expressionChecker.check(instVar).getType());
    }

    @Test
    @DisplayName("")
    void checkJBooleanTest() throws SyntaxException {
        JBoolean jBoolean = new JBoolean("true", null);
        assertEquals(PrimitiveType.BOOLEAN, expressionChecker.check(jBoolean).getType());
    }

    @Test
    @DisplayName("")
    void checkJCharakterTest() throws SyntaxException {
        JCharacter jCharacter = new JCharacter("1");
        assertEquals(PrimitiveType.CHARACTER, expressionChecker.check(jCharacter).getType());
    }
    @Test
    @DisplayName("")
    void checkJIntegerTest() throws SyntaxException{
        JInteger jInteger = new JInteger("1");
        assertEquals(PrimitiveType.INTEGER, expressionChecker.check(jInteger).getType());
    }
    @Test
    @DisplayName("")
    void checkJNullTest() throws SyntaxException{
        JNull jNull = new JNull();
        assertEquals(ObjectType.string(), expressionChecker.check(jNull).getType());
    }
    @Test
    @DisplayName("")
    void checkJStringTest() throws SyntaxException{
        JString jString = new JString("1");
        assertEquals(ObjectType.string(), expressionChecker.check(jString).getType());
    }
    @Test
    @DisplayName("")
    void checkStmtExprExprTest() throws SyntaxException, TypeException {
        StmtExprExpr stmtExprExpr = new StmtExprExpr(null, null);

        assertEquals(stmtExprExpr.getType(), expressionChecker.check(stmtExprExpr).getType());
    }
    @Test
    @DisplayName("")
    void checkLocalOrFieldVarTest() throws SyntaxException {
        LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar("localOrFieldVar");
        assertEquals(localOrFieldVar.getType(), expressionChecker.check(localOrFieldVar).getType());
    }
    @Test
    @DisplayName("")
    void checkSuperTest(){
        Super super_ = new Super(null);
        String string = new String("");//String Finla im Oben
        assertEquals(string.getClass(), expressionChecker.check(super_));
    }
    @Test
    @DisplayName("")
    void checkThisTest(){
        This this_ = new This(null);
        String string = new String("");//String Finla im Oben
        assertEquals(string.getClass(), expressionChecker.check(this_));
    }
    @Test
    @DisplayName("")
    void checkUnaryTest0() throws SyntaxException, TypeException {

        de.dhbw.compiler.ast.expressions.Expression expression_ = (de.dhbw.compiler.ast.expressions.Expression) new Expression(null, null, null);
        Unary unary = new Unary(null, expression_);
        assertEquals(PrimitiveType.INTEGER, expressionChecker.check(unary));
    }
    @Test
    @DisplayName("")
    void checkUnaryTest1() throws SyntaxException, TypeException {

        de.dhbw.compiler.ast.expressions.Expression expression_ = (de.dhbw.compiler.ast.expressions.Expression) new Expression(null, null, null);
        Unary unary = new Unary(null, expression_);
        assertEquals(PrimitiveType.BOOLEAN, expressionChecker.check(unary));
    }
}
