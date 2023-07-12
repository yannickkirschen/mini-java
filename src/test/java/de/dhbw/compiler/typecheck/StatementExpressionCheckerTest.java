package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.AstType;
import de.dhbw.compiler.ast.Field;
import de.dhbw.compiler.ast.Method;
import de.dhbw.compiler.ast.Parameter;
import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.ast.expressions.InstVar;
import de.dhbw.compiler.ast.expressions.LocalOrFieldVar;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.MethodCall;
import de.dhbw.compiler.ast.stmtexprs.New;
import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
//I'm quite unsure if this class is correct
public class StatementExpressionCheckerTest {
    StatementExpressionChecker statementExpressionChecker;
    @BeforeEach
    void setup(){
        List<Field> fields = new ArrayList<>();
        List<Method> methods = new ArrayList<>();
        List<LocalOrFieldVar> localOrFieldVars = new ArrayList<>();
        statementExpressionChecker = new StatementExpressionChecker("statementExpressionChecker",fields,methods,localOrFieldVars);
    }
    @Test
    void StatementExpressioncheck0() throws SyntaxException, TypeException {
        Assign assign = new Assign(new LocalOrFieldVar("localOrFieldVar", PrimitiveType.BOOLEAN),new LocalOrFieldVar("localOrFieldVar", PrimitiveType.BOOLEAN),null);
        assertEquals(assign,statementExpressionChecker.check(assign));
    }
    @Test
    void StatementExpressioncheck1() throws SyntaxException, TypeException {
        MethodCall methodCall = new MethodCall(null,null, null ,null);
        assertEquals(methodCall,statementExpressionChecker.check(methodCall));
    }
    @Test
    void StatementExpressioncheck2() throws SyntaxException, TypeException {
        New new_ = new New( null ,null);
        assertEquals(new_,statementExpressionChecker.check(new_));
    }
    @Test
    void AssigncheckTest0() throws SyntaxException, TypeException {
        Assign assign = new Assign(new LocalOrFieldVar("localOrFieldVar", PrimitiveType.BOOLEAN),new LocalOrFieldVar("localOrFieldVar", PrimitiveType.BOOLEAN),null);
        assertEquals(PrimitiveType.BOOLEAN,statementExpressionChecker.check(assign).getType());
    }
    @Test
    void AssigncheckTest1() throws SyntaxException, TypeException {
        Assign assign = new Assign(new InstVar(null,"instVar", PrimitiveType.BOOLEAN),new InstVar(null,"instVar", PrimitiveType.BOOLEAN),null);
        assertEquals(PrimitiveType.BOOLEAN,statementExpressionChecker.check(assign).getType());
    }
    @Test
    void MethodCallcheckTest() throws SyntaxException, TypeException {
        List<Expression> args = new ArrayList<>();
        MethodCall methodCall = new MethodCall(new LocalOrFieldVar("localOrFieldVar", PrimitiveType.BOOLEAN),"methodCall",args,null);
        assertEquals(PrimitiveType.BOOLEAN,statementExpressionChecker.check(methodCall).getType());
    }
    @Test
    void NewcheckTest() throws SyntaxException, TypeException {
        List<Expression> args = new ArrayList<>();
        New new_ = new New(new AstType("astType"),args,null);
        assertEquals(PrimitiveType.BOOLEAN,statementExpressionChecker.check(new_).getType());
    }
}
