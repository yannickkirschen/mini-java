package de.dhbw.compiler.typecheck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ibm.icu.impl.Assert;
import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.ast.stmtexprs.*;
import org.junit.jupiter.api.Test;
import de.dhbw.compiler.ast.expressions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TypecheckTest {
    protected Program testTypeCheck(Program in) throws SyntaxException, TypeException {
        TypeCheck tc = new TypeCheck();
        Program out = tc.check(in);
        return out;
    }

    ArrayList<Clazz> classesIn = new ArrayList<>();
    ArrayList<Field> field = new ArrayList<>();
    ArrayList<Parameter> constructorParams = new ArrayList<>();
    ArrayList<Constructor> constructor = new ArrayList<>();
    ArrayList<Method> methods = new ArrayList<>();
    Program out = null;
    @Test
    void TypeEmptyClass(){

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));
        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
    }

    @Test
    void TypeEmptyMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, methodStatement));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
    }

    @Test
    void TypeBinaryMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();

        Statement methodStatement = new Block(Arrays.asList(new Block(Arrays.asList(new LocalVarDecl(new AstType("int"), "x") , new StmtExprStmt( new Assign(new LocalOrFieldVar("x"), new JInteger("1")))) ),
                                                            new Block(Arrays.asList(new StmtExprStmt(new Assign(new LocalOrFieldVar("x"), new Binary("+", new LocalOrFieldVar("x"), new LocalOrFieldVar("x")))))) ) );

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, methodStatement));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).statement.getType());
        assertEquals(PrimitiveType.INTEGER, ((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(0).getType());
        assertEquals(PrimitiveType.INTEGER, ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(1)).stmts.get(0)).statementExpression).target.getType());
        assertEquals(PrimitiveType.INTEGER, ((Binary)((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(1)).stmts.get(0)).statementExpression).value).getType());
    }

    @Test
    void TypeBooleanMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList(new Block(Arrays.asList(new LocalVarDecl(new AstType("boolean"), "x"), new StmtExprStmt( new Assign(new LocalOrFieldVar("x"), new JBoolean("true")))))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals(PrimitiveType.BOOLEAN, ((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(0).getType());
        assertEquals(PrimitiveType.BOOLEAN, ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).target.getType());
        assertEquals(PrimitiveType.BOOLEAN, ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).value.getType());
    }

    @Test
    void TypeInstVarMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        field.add(new Field(new AstType("boolean"), "x"));

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList( new StmtExprStmt( new Assign(new InstVar(new This(), "x"), new JBoolean("false")))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch (Exception e) {

        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.BOOLEAN, out.classes().get(0).fields.get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).statement.getType());
        assertEquals(PrimitiveType.BOOLEAN, ((Assign)((StmtExprStmt)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).statementExpression).target.getType());
        assertEquals(PrimitiveType.BOOLEAN, ((Assign)((StmtExprStmt)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).statementExpression).value.getType());
    }

    @Test
    void TypeCharMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList(new Block(Arrays.asList(new LocalVarDecl(new AstType("char"), "x"), new StmtExprStmt( new Assign(new LocalOrFieldVar("x"), new JCharacter("x")))))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals(PrimitiveType.CHARACTER, ((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(0).getType());
        assertEquals(PrimitiveType.CHARACTER, ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).target.getType());
        assertEquals(PrimitiveType.CHARACTER, ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).value.getType());
    }

    @Test
    void TypeIntMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList(new Block(Arrays.asList(new LocalVarDecl(new AstType("int"), "x"), new StmtExprStmt( new Assign(new LocalOrFieldVar("x"), new JInteger("1")))))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals(PrimitiveType.INTEGER, ((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(0).getType());
        assertEquals(PrimitiveType.INTEGER, ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).target.getType());
        assertEquals(PrimitiveType.INTEGER, ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).value.getType());
    }

    @Test
    void TypeStringMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList(new Block(Arrays.asList(new LocalVarDecl(new AstType("String"), "x"), new StmtExprStmt( new Assign(new LocalOrFieldVar("x"), new JString("null")))))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals(ObjectType.string().getName(), ((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(0).getType().getName());
        assertEquals(ObjectType.string().getName(), ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).target.getType().getName());
        assertEquals(ObjectType.string().getName(), ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).value.getType().getName());
    }

    @Test
    void TypeNullMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList(new Block(Arrays.asList(new LocalVarDecl(new AstType("String"), "x"), new StmtExprStmt( new Assign(new LocalOrFieldVar("x"), new JNull()))))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals(ObjectType.string().getName(), ((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(0).getType().getName());
        assertEquals(ObjectType.string().getName(), ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).target.getType().getName());
        assertEquals(null, ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).value.getType().getName());
    }

    @Test
    void TypeLocalOrFieldVarMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList(new Block(Arrays.asList(new LocalVarDecl(new AstType("int"), "y"), new LocalVarDecl(new AstType("int"), "x"), new StmtExprStmt( new Assign(new LocalOrFieldVar("x"), new LocalOrFieldVar("y")))))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));
        }catch(Exception e){
            return;
        }
        Assert.fail("Exception erwartet");
    }

    @Test
    void TypeUnaryMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList(new Block(Arrays.asList(new LocalVarDecl(new AstType("boolean"), "x"), new StmtExprStmt( new Assign(new LocalOrFieldVar("x"), new Unary("!",new JBoolean("true"))))))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals(PrimitiveType.BOOLEAN, ((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(0).getType());
        assertEquals(PrimitiveType.BOOLEAN, ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).target.getType());
        assertEquals(PrimitiveType.BOOLEAN, ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).value.getType());
        assertEquals(PrimitiveType.BOOLEAN, ((Unary)((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).value).argument.getType());
    }

    @Test
    void TypeIfMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());
        field.add(new Field(new AstType("int"), "x"));

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList(new If(new JBoolean("true"), new Block( Arrays.asList( new Block(Arrays.asList(new LocalVarDecl(new AstType("int"), "a"), new StmtExprStmt( new Assign(new LocalOrFieldVar("a"), new JInteger("1"))))))),new Block( Arrays.asList( new Block(Arrays.asList(new LocalVarDecl(new AstType("int"), "z"), new StmtExprStmt( new Assign(new LocalOrFieldVar("z"), new Unary( "-", new JInteger("99")))))))))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));
        }catch(Exception e){
            Assert.fail("Exception erwartet");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals(PrimitiveType.BOOLEAN, ((If)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).condition.getType());
        assertEquals(PrimitiveType.INTEGER, ((Block)((Block)((If)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).ifBody).stmts.get(0)).stmts.get(0).getType());
        assertEquals(PrimitiveType.INTEGER, ((StmtExprStmt)((Block)((Block)((If)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).ifBody).stmts.get(0)).stmts.get(1)).statementExpression.getType());
        assertEquals(PrimitiveType.INTEGER, ((Assign)((StmtExprStmt)((Block)((Block)((If)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).ifBody).stmts.get(0)).stmts.get(1)).statementExpression).target.getType());
        assertEquals(PrimitiveType.INTEGER, ((Assign)((StmtExprStmt)((Block)((Block)((If)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).ifBody).stmts.get(0)).stmts.get(1)).statementExpression).value.getType());
        assertEquals(PrimitiveType.INTEGER, ((StmtExprStmt)((Block)((Block)((If)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).elseBody).stmts.get(0)).stmts.get(1)).statementExpression.getType());
        assertEquals(PrimitiveType.INTEGER, ((Assign)((StmtExprStmt)((Block)((Block)((If)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).ifBody).stmts.get(0)).stmts.get(1)).statementExpression).target.getType());
        assertEquals(PrimitiveType.INTEGER, ((Assign)((StmtExprStmt)((Block)((Block)((If)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).ifBody).stmts.get(0)).stmts.get(1)).statementExpression).value.getType());
    }
    @Test
    void TypeReturnMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("int"), "boomethod", methodParams, new Block(Arrays.asList(new Return( new JInteger("25"))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.INTEGER, out.classes().get(0).methods.get(0).getType());
        assertEquals(PrimitiveType.INTEGER, ((Return)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).getType());
        assertEquals(PrimitiveType.INTEGER, ((JInteger)((Return)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).expression).getType());
    }
    @Test
    void TypeWhileMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("boolean"), "boomethod", methodParams, new Block(Arrays.asList(new While(new Binary("==",new JBoolean("true"),new JBoolean("false")), new Block(Arrays.asList(new Return( new JBoolean("true")))))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.BOOLEAN, out.classes().get(0).methods.get(0).getType());
        assertEquals(PrimitiveType.BOOLEAN, ((While)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).condition.getType());
        assertEquals(PrimitiveType.BOOLEAN, ((Return)((Block)((While)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).statement).stmts.get(0)).expression.getType());
    }
    @Test
    void TypeCallMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList(new StmtExprStmt( new MethodCall( new This(), "boomethod", new ArrayList<>()))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals("void", ((MethodCall)((StmtExprStmt)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).statementExpression).getType().getName());
    }
    @Test
    void TypeNewMethod(){

        ArrayList<Parameter> methodParams = new ArrayList<>();
        Statement methodStatement = new Block(new ArrayList<>());

        constructor.add(new Constructor(constructorParams, new Block(new ArrayList<Statement>())));

        methods.add(new Method( new AstType("void"), "boomethod", methodParams, new Block(Arrays.asList(new Block(Arrays.asList(new LocalVarDecl(new AstType("Leer"), "empty"), new StmtExprStmt( new Assign(new LocalOrFieldVar("empty"), new StmtExprExpr(new New(new AstType("Leer"), new ArrayList<>()))))))))));

        classesIn.add(new Clazz(new AstType("Leer"), field, constructor, methods));
        try {
            out = testTypeCheck(new Program(classesIn));

        }catch(Exception e){
            Assert.fail("Exception");
        }
        assertEquals(null, out.classes().get(0).getType());
        assertEquals(PrimitiveType.VOID, out.classes().get(0).methods.get(0).getType());
        assertEquals("Leer", ((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(0).getType().getName());
        assertEquals("Leer", ((Assign)((StmtExprStmt)((Block)((Block)out.classes().get(0).methods.get(0).statement).stmts.get(0)).stmts.get(1)).statementExpression).value.getType().getName());
    }
}
