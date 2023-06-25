package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.AstType;
import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.New;
import de.dhbw.compiler.typecheck.SyntaxException;
import de.dhbw.compiler.typecheck.TypeCheck;
import de.dhbw.compiler.typecheck.TypeException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;


public class TestCodeGeneration {
    public static void main(String[] args) throws NoSuchMethodException, SyntaxException, TypeException {
        //System.out.println(Type.getMethodDescriptor(TestCodeGeneration.class.getMethod("test")));
        ArrayList<Clazz> clazzes = new ArrayList<>();
        clazzes.add(testInstVar());
        Program p = new Program(clazzes);

        CodeGenVisitor visitor = new CodeGenVisitor();
        visitor.visitClass(clazzes.get(0));

    }


    public static Clazz testCaseEmptyClass() {
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), new ArrayList<Field>(), constr, methods);
    }

    public static Clazz testCaseClassWField() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();


        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    /**
     * public class TestClass {
     * public int field;
     * <p>
     * public TestClass() {
     * }
     * <p>
     * public int getInt() {
     * return this.field;
     * }
     * }
     *
     * @return
     */
    public static Clazz testCaseClassWFieldAndStmt() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        bodyContent.add(new Return(new LocalOrFieldVar("field", PrimitiveType.INTEGER)));
        Statement body = new Block(bodyContent, PrimitiveType.INTEGER);

        Method method = new Method(PrimitiveType.INTEGER, new AstType("int"), "getInt", new ArrayList<Parameter>(), body);
        methods.add(method);

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    /**
     * public class TestClass {
     * public int field;
     * <p>
     * public TestClass() {
     * }
     * <p>
     * public int getInt() {
     * field = 3;
     * return this.field;
     * }
     * }
     *
     * @return
     */
    public static Clazz testCase4() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        bodyContent.add(new StmtExprStmt(new Assign(new LocalOrFieldVar("field", PrimitiveType.INTEGER), new JInteger("3"))));
        bodyContent.add(new Return(new LocalOrFieldVar("field", PrimitiveType.INTEGER)));
        Statement body = new Block(bodyContent, PrimitiveType.INTEGER);

        Method method = new Method(PrimitiveType.INTEGER, new AstType("int"), "getInt", new ArrayList<Parameter>(), body);
        methods.add(method);

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    /**
     * public class TestClass {
     * public int field;
     * <p>
     * public TestClass() {
     * }
     * <p>
     * public int getInt() {
     * int i;
     * i = 4000;
     * return i;
     * }
     * }
     *
     * @return
     */
    public static Clazz testCase5() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        bodyContent.add(new LocalVarDecl(new AstType("int"), "i", PrimitiveType.INTEGER));
        bodyContent.add(new StmtExprStmt(new Assign(new LocalOrFieldVar("i", PrimitiveType.INTEGER), new JInteger("4000", PrimitiveType.INTEGER))));
        bodyContent.add(new Return(new LocalOrFieldVar("i", PrimitiveType.INTEGER)));
        Statement body = new Block(bodyContent, PrimitiveType.INTEGER);

        Method method = new Method(PrimitiveType.INTEGER, new AstType("int"), "getInt", new ArrayList<Parameter>(), body);
        methods.add(method);

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    // Expressions

    /**
     * public class TestClass {
     * <p>
     * public TestClass() {
     * }
     * <p>
     * public int add() {
     * int a = 15;
     * int b = 3;
     * int result = a + b;
     * return result;
     * }
     * }
     *
     * @return
     */

    public static Clazz testBinary() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();

        bodyContent.add(new LocalVarDecl(new AstType("int"), "a", PrimitiveType.INTEGER));
        var a = new LocalOrFieldVar("a", PrimitiveType.INTEGER);
        bodyContent.add(new StmtExprStmt(new Assign(a, new JInteger("15", PrimitiveType.INTEGER))));
        bodyContent.add(new LocalVarDecl(new AstType("int"), "b", PrimitiveType.INTEGER));
        var b = new LocalOrFieldVar("b", PrimitiveType.INTEGER);
        bodyContent.add(new StmtExprStmt(new Assign(b, new JInteger("3", PrimitiveType.INTEGER))));
        bodyContent.add(new LocalVarDecl(new AstType("int"), "result", PrimitiveType.INTEGER));
        var result = new LocalOrFieldVar("result", PrimitiveType.INTEGER);
        bodyContent.add(new StmtExprStmt(new Assign(result, new Binary("/", a, b, PrimitiveType.INTEGER))));
        bodyContent.add(new Return(result));

        Statement body = new Block(bodyContent, PrimitiveType.INTEGER);
        Method method = new Method(PrimitiveType.INTEGER, new AstType("int"), "add", new ArrayList<Parameter>(), body);
        methods.add(method);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    /**
     * public class TestClass {
     * public TestClass() {
     * }
     * <p>
     * public int add(int var1, int var2) {
     * int var3 = var1 * var2;
     * return var3;
     * }
     * }
     *
     * @return
     */


    public static Clazz testBinaryWithParameter() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();

        var a = new LocalOrFieldVar("a", PrimitiveType.INTEGER);
        var b = new LocalOrFieldVar("b", PrimitiveType.INTEGER);
        bodyContent.add(new LocalVarDecl(new AstType("int"), "result", PrimitiveType.INTEGER));
        var result = new LocalOrFieldVar("result", PrimitiveType.INTEGER);
        bodyContent.add(new StmtExprStmt(new Assign(result, new Binary("*", a, b, PrimitiveType.INTEGER))));
        bodyContent.add(new Return(result));

        Statement body = new Block(bodyContent, PrimitiveType.INTEGER);
        Method method = new Method(PrimitiveType.INTEGER, new AstType("int"), "add", new ArrayList<Parameter>(List.of(new Parameter(PrimitiveType.INTEGER, new AstType("int"), "a"), new Parameter(PrimitiveType.INTEGER, new AstType("int"), "b"))), body);
        methods.add(method);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }



    public static Clazz getterSetter() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> setContent = new ArrayList<>();
        ArrayList<Statement> getContent = new ArrayList<>();

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "var");
        fields.add(f);
        var fieldVar = new LocalOrFieldVar("var", PrimitiveType.INTEGER);
        bodyContent.add(new StmtExprStmt(new Assign(fieldVar, new JInteger("1000", PrimitiveType.INTEGER))));

        setContent.add(new StmtExprStmt(new Assign(fieldVar, new LocalOrFieldVar("a", PrimitiveType.INTEGER))));
        Statement setBody = new Block(setContent, PrimitiveType.INTEGER);
        Method setter = new Method(PrimitiveType.VOID, new AstType("void"), "setVar", new ArrayList<Parameter>(List.of(new Parameter(PrimitiveType.INTEGER, new AstType("int"), "a"))), setBody);
        methods.add(setter);

        getContent.add(new Return(fieldVar));
        Statement getBody = new Block(getContent, PrimitiveType.INTEGER);
        Method getter = new Method(PrimitiveType.INTEGER, new AstType("int"), "getVar", new ArrayList<Parameter>(), getBody);
        methods.add(getter);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, PrimitiveType.INTEGER));
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }


    /**
     *
     * public class TestClass {
     *     public TestInstVar var = new TestInstVar();
     *
     *     public TestClass() {
     *     }
     *
     *     public int getInstVar() {
     *         return this.var.test;
     *     }
     * }
     * @return
     */


    public static Clazz testInstVar() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> getContent = new ArrayList<>();

        var testClassType = new ObjectType("TestInstVar");

        Field f = new Field(testClassType, new AstType("TestInstVar"), "var");
        fields.add(f);
        var fieldVar = new LocalOrFieldVar("var", testClassType);
        bodyContent.add(new StmtExprStmt(new Assign(fieldVar, new StmtExprExpr(new New(testClassType, new ArrayList<Expression>(), testClassType), testClassType), testClassType)));

        getContent.add(new Return( new InstVar(fieldVar, "test", PrimitiveType.INTEGER)));
        Statement getBody = new Block(getContent, PrimitiveType.INTEGER);
        Method getter = new Method(PrimitiveType.INTEGER, new AstType("int"), "getInstVar", new ArrayList<Parameter>(), getBody);
        methods.add(getter);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, PrimitiveType.INTEGER));
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }


}
