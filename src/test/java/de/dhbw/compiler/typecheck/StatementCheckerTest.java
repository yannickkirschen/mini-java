package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.ast.statements.LocalVarDecl;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.codegeneration.ObjectType;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementCheckerTest {//baseChecker seem to be null
    StatementChecker statementChecker;
    BaseExpressionChecker baseExpressionChecker;
    StatementExpressionChecker statementExpressionChecker;
    @BeforeEach
    void setup() {
        List<LocalOrFieldVar> localOrFieldVars = new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        List<Method> methods = new ArrayList<>();
        statementExpressionChecker = new StatementExpressionChecker("statementExpressionChecker", fields, methods, localOrFieldVars);
        baseExpressionChecker = new ExpressionChecker("statementChecker",fields,localOrFieldVars,statementExpressionChecker);
        statementChecker = new StatementChecker("statementChecker",localOrFieldVars,baseExpressionChecker,statementExpressionChecker );
    }

    @Test
    void StatementcheckTest0() throws SyntaxException, TypeException {
        List<Statement> blocks = new ArrayList<>(); //this has a problem with the statment path
        Block block0 = new Block(blocks, null);
        assertEquals(block0.getClass(),statementChecker.check(block0).getClass());
    }
    @Test
    void StatementcheckTest1() throws SyntaxException, TypeException {
        If if_ = new If(new JBoolean("true", PrimitiveType.BOOLEAN), new Return(new JBoolean("true"), PrimitiveType.BOOLEAN),null);
        assertEquals(if_.getClass(),statementChecker.check(if_).getClass());
    }
    @Test
    void StatementcheckTest2() throws SyntaxException, TypeException {
        LocalVarDecl localVarDecl = new LocalVarDecl(new AstType("boolean"), null , null);
        assertEquals(localVarDecl.getClass(),statementChecker.check(localVarDecl).getClass());
    }
    @Test
    void StatementcheckTest3() throws SyntaxException, TypeException {
        Return return_ = new Return(new JBoolean("true"), PrimitiveType.BOOLEAN);
        assertEquals(return_.getClass(),statementChecker.check(return_).getClass());
    }
    @Test
    void StatementcheckTest4() throws SyntaxException, TypeException {
        StmtExprStmt stmtExprStmt = new StmtExprStmt(new Assign(new JBoolean("true"),new JBoolean("true")), PrimitiveType.BOOLEAN);
        assertEquals(stmtExprStmt.getClass(),statementChecker.check(stmtExprStmt).getClass());
    }
    @Test
    void StatementcheckTest5() throws SyntaxException, TypeException {
        While while_ = new While(new JBoolean("true", PrimitiveType.BOOLEAN),  null, PrimitiveType.BOOLEAN);
        assertEquals(while_.getClass(),statementChecker.check(while_).getClass());
    }
    @Test
    void BlockcheckTest0() throws SyntaxException, TypeException {
        List<Statement> blocks = new ArrayList<>(); //this has a problem with the statment path
        Block block0 = new Block(blocks, null);
        assertEquals(PrimitiveType.VOID, statementChecker.check(block0).getType());
    }
    @Test
    void BlockcheckTest1() throws SyntaxException, TypeException {
        List<Statement> blocks = new ArrayList<>(); //this has a problem with the statment path
        Return return_ = new Return(new JBoolean("true"),PrimitiveType.BOOLEAN);
        blocks.add(return_);
        Block block0 = new Block(blocks, null);
        assertEquals(PrimitiveType.BOOLEAN, statementChecker.check(block0).getType());
    }
    @Test
    void IfcheckTest0() throws SyntaxException, TypeException {
        If if_ = new If(new JBoolean("true", PrimitiveType.BOOLEAN), new Return(new JBoolean("true"), PrimitiveType.BOOLEAN),null);;
        assertEquals(PrimitiveType.BOOLEAN,statementChecker.check(if_).getType());
    }
    @Test
    void IfcheckTest1() throws SyntaxException, TypeException {
        If if_ = new If(new JBoolean("true", PrimitiveType.BOOLEAN), new Return(new JBoolean("true"), PrimitiveType.BOOLEAN),new Return(new JBoolean("true"), PrimitiveType.INTEGER));;
        assertEquals(PrimitiveType.BOOLEAN,statementChecker.check(if_).getType());
    }

    @Test
    void LocalVarDeclcheckTest0() throws SyntaxException {
        LocalVarDecl localVarDecl = new LocalVarDecl(new AstType("boolean"),null, null);
        assertEquals(PrimitiveType.BOOLEAN, statementChecker.check(localVarDecl).getType());
    }
    @Test
    void LocalVarDeclcheckTest1() throws SyntaxException {
        LocalVarDecl localVarDecl = new LocalVarDecl(new AstType("int"),null, null);
        assertEquals(PrimitiveType.INTEGER, statementChecker.check(localVarDecl).getType());
    }
    @Test
    void LocalVarDeclcheckTest2() throws SyntaxException {
        LocalVarDecl localVarDecl = new LocalVarDecl(new AstType("char"),null, null);
        assertEquals(PrimitiveType.CHARACTER, statementChecker.check(localVarDecl).getType());
    }
    @Test
    void LocalVarDeclcheckTest3() throws SyntaxException {
        LocalVarDecl localVarDecl = new LocalVarDecl(new AstType("String"),null, null);
        assertEquals(ObjectType.string().getClass(), statementChecker.check(localVarDecl).getType().getClass());
    }
    @Test
    void LocalVarDeclcheckTest4() throws SyntaxException {
        LocalVarDecl localVarDecl = new LocalVarDecl(new AstType(statementChecker.getClass().getName()),null, null);
        assertEquals(new ObjectType(statementChecker.getClass().getName()), statementChecker.check(localVarDecl));
    }
    @Test
    void LocalVarDeclcheckTest5() throws SyntaxException {//should we check if there was smt added?
       /* LocalVarDecl localVarDecl = new LocalVarDecl(new AstType(statementChecker.getClass().getName()),null, null);
        statementChecker.check(localVarDecl);
        assertEquals(2,statementChecker.getLocalVarDecl().getLength());*/
    }
    @Test
    void ReturncheckTest() throws SyntaxException, TypeException {
        Return return_ = new Return(new JBoolean("true"),null);
        assertEquals(PrimitiveType.BOOLEAN,statementChecker.check(return_).getType());
    }
    @Test
    void StmtExprStmtcheckTest() throws SyntaxException, TypeException {
        StmtExprStmt stmtExprStmt = new StmtExprStmt(new Assign(new JBoolean("true"), null, PrimitiveType.BOOLEAN), null);
        assertEquals(PrimitiveType.BOOLEAN,statementChecker.check(stmtExprStmt).getType());
    }
    @Test
    void WhilecheckTest() throws SyntaxException, TypeException {
        While while_ = new While(new JBoolean("true", PrimitiveType.BOOLEAN),  null, PrimitiveType.BOOLEAN);
        assertEquals(PrimitiveType.BOOLEAN,statementChecker.check(while_).getType());
    }
}
