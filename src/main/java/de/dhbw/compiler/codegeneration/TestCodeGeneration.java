package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.AstType;
import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.MethodCall;
import de.dhbw.compiler.ast.stmtexprs.New;
import de.dhbw.compiler.typecheck.SyntaxException;
import de.dhbw.compiler.typecheck.TypeException;

import java.util.ArrayList;
import java.util.List;


public class TestCodeGeneration {
    public static void main(String[] args) throws NoSuchMethodException, SyntaxException, TypeException {
        ArrayList<Clazz> clazzes = new ArrayList<>();
        clazzes.add(testInstVar2());
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
    public static Clazz testCaseAlterAndReturnField() {
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

    // Statements
    public static Clazz testCaseReturnLocalVar() {
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

    /**
     * public class TestClassIf{
     * public boolean doIf(boolean valu){
     * if(valu){
     * return false;
     * }
     * else return true;
     * }
     * }
     *
     * @return
     */
    public static Clazz testCaseIf() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        bodyContent.add(new If(
            new LocalOrFieldVar("valu", PrimitiveType.BOOLEAN),
            new Return(new JBoolean("false", PrimitiveType.BOOLEAN), PrimitiveType.BOOLEAN),
            new Return(new JBoolean("true", PrimitiveType.BOOLEAN), PrimitiveType.BOOLEAN),
            PrimitiveType.BOOLEAN
        ));
        Statement body = new Block(bodyContent, PrimitiveType.INTEGER);
        ArrayList<Parameter> doIfParameters = new ArrayList<>();
        doIfParameters.add(new Parameter(PrimitiveType.BOOLEAN, new AstType("boolean"), "valu"));
        Method method = new Method(PrimitiveType.BOOLEAN, new AstType("boolean"), "doIf", doIfParameters, body);
        methods.add(method);

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClassIf"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClassIf"), new AstType("TestClassIf"), fields, constr, methods);
    }

    /**
     * public class TestClassWhile{
     * public int doIf(){
     * int i = 10;
     * int c = 0;
     * while( i > 0){
     * i = i - 1;
     * c = c + 1;
     * }
     * return c;
     * }
     * }
     *
     * @return
     */
    public static Clazz testCaseWhile() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();

        ArrayList<Statement> whileBody = new ArrayList<>();
        whileBody.add(new StmtExprStmt(new Assign(
            new LocalOrFieldVar("i", PrimitiveType.INTEGER),
            new Binary(
                "-",
                new LocalOrFieldVar("i", PrimitiveType.INTEGER),
                new JInteger("1", PrimitiveType.INTEGER), PrimitiveType.INTEGER)),
            PrimitiveType.INTEGER));
        whileBody.add(new StmtExprStmt(new Assign(
            new LocalOrFieldVar("c", PrimitiveType.INTEGER),
            new Binary(
                "+",
                new LocalOrFieldVar("c", PrimitiveType.INTEGER),
                new JInteger("1", PrimitiveType.INTEGER), PrimitiveType.INTEGER)),
            PrimitiveType.INTEGER));

        bodyContent.add(new LocalVarDecl(new AstType("int"), "i", PrimitiveType.INTEGER));
        bodyContent.add(new StmtExprStmt(
            new Assign(
                new LocalOrFieldVar("i", PrimitiveType.INTEGER),
                new JInteger("10", PrimitiveType.INTEGER))));
        bodyContent.add(new LocalVarDecl(new AstType("int"), "c", PrimitiveType.INTEGER));
        bodyContent.add(new StmtExprStmt(
            new Assign(
                new LocalOrFieldVar("c", PrimitiveType.INTEGER),
                new JInteger("0", PrimitiveType.INTEGER))));
        bodyContent.add(new While(
            new Binary(
                ">",
                new LocalOrFieldVar("i", PrimitiveType.INTEGER),
                new JInteger("0", PrimitiveType.INTEGER), PrimitiveType.INTEGER),
            new Block(whileBody, PrimitiveType.INTEGER)));

        bodyContent.add(new Return(new LocalOrFieldVar("c", PrimitiveType.INTEGER), PrimitiveType.INTEGER));
        Statement body = new Block(bodyContent, PrimitiveType.INTEGER);
        Method method = new Method(PrimitiveType.INTEGER, new AstType("int"), "doIf", new ArrayList<>(), body);
        methods.add(method);

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClassWhile"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClassWhile"), new AstType("TestClassWhile"), fields, constr, methods);
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

    public static Clazz testBinaryWithFields() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> fContent = new ArrayList<>();

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "var");
        fields.add(f);
        var fieldVar = new LocalOrFieldVar("var", PrimitiveType.INTEGER);
        bodyContent.add(new StmtExprStmt(new Assign(fieldVar, new JInteger("1000", PrimitiveType.INTEGER))));

        Field f2 = new Field(PrimitiveType.INTEGER, new AstType("int"), "var2");
        fields.add(f2);
        var fieldVar2 = new LocalOrFieldVar("var2", PrimitiveType.INTEGER);
        bodyContent.add(new StmtExprStmt(new Assign(fieldVar2, new JInteger("2000", PrimitiveType.INTEGER))));

        fContent.add(new Return(new Binary("+", fieldVar, fieldVar2, PrimitiveType.INTEGER)));

        Statement fbody = new Block(fContent, PrimitiveType.INTEGER);
        Method method = new Method(PrimitiveType.INTEGER, new AstType("int"), "get", new ArrayList<Parameter>(), fbody);
        methods.add(method);

        Statement body = new Block(bodyContent, PrimitiveType.INTEGER);
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), body);
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
     * public class TestClass {
     * public TestInstVar var = new TestInstVar();
     * <p>
     * public TestClass() {
     * }
     * <p>
     * public int getInstVar() {
     * return this.var.test;
     * }
     * }
     *
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
        bodyContent.add(new StmtExprStmt(
            new Assign(
                fieldVar,
                new StmtExprExpr(
                    new New(
                        new AstType("TestInstVar"),
                        new ArrayList<Expression>(),
                        testClassType),
                    testClassType),
                testClassType)));

        getContent.add(new Return(new InstVar(fieldVar, "test", PrimitiveType.INTEGER)));
        Statement getBody = new Block(getContent, PrimitiveType.INTEGER);
        Method getter = new Method(PrimitiveType.INTEGER, new AstType("int"), "get", new ArrayList<Parameter>(), getBody);
        methods.add(getter);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, PrimitiveType.INTEGER));
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    public static Clazz testBoolean() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> fContent = new ArrayList<>();

        fContent.add(new LocalVarDecl(new AstType("boolean"), "isWorking", PrimitiveType.BOOLEAN));
        var a = new LocalOrFieldVar("isWorking", PrimitiveType.BOOLEAN);
        fContent.add(new StmtExprStmt(new Assign(a, new JBoolean("false", PrimitiveType.INTEGER))));

        fContent.add(new LocalVarDecl(new AstType("boolean"), "isNotWorking", PrimitiveType.BOOLEAN));
        var b = new LocalOrFieldVar("isNotWorking", PrimitiveType.BOOLEAN);
        fContent.add(new StmtExprStmt(new Assign(b, new JBoolean("false", PrimitiveType.INTEGER))));

        fContent.add(new Return(new Binary("||", a, b, PrimitiveType.BOOLEAN)));

        Statement fBody = new Block(fContent, PrimitiveType.BOOLEAN);
        Method getter = new Method(PrimitiveType.BOOLEAN, new AstType("boolean"), "isBooleanWorking", new ArrayList<Parameter>(), fBody);
        methods.add(getter);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, PrimitiveType.INTEGER));
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    public static Clazz testChar() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> fContent = new ArrayList<>();

        fContent.add(new LocalVarDecl(new AstType("char"), "c", PrimitiveType.CHARACTER));
        var a = new LocalOrFieldVar("c", PrimitiveType.CHARACTER);
        fContent.add(new StmtExprStmt(new Assign(a, new JCharacter("Ü", PrimitiveType.CHARACTER))));

        fContent.add(new Return(a));

        Statement fBody = new Block(fContent, PrimitiveType.CHARACTER);
        Method getter = new Method(PrimitiveType.CHARACTER, new AstType("char"), "get", new ArrayList<Parameter>(), fBody);
        methods.add(getter);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, null));
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    public static Clazz testInteger() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> fContent = new ArrayList<>();

        fContent.add(new LocalVarDecl(new AstType("int"), "a", PrimitiveType.INTEGER));
        var a = new LocalOrFieldVar("a", PrimitiveType.INTEGER);
        fContent.add(new StmtExprStmt(new Assign(a, new JInteger("3", PrimitiveType.INTEGER))));

        fContent.add(new LocalVarDecl(new AstType("int"), "b", PrimitiveType.INTEGER));
        var b = new LocalOrFieldVar("b", PrimitiveType.INTEGER);
        fContent.add(new StmtExprStmt(new Assign(b, new JInteger("2", PrimitiveType.INTEGER))));

        fContent.add(new Return(new Binary("!=", a, b, PrimitiveType.BOOLEAN)));

        Statement fBody = new Block(fContent, PrimitiveType.BOOLEAN);
        Method getter = new Method(PrimitiveType.BOOLEAN, new AstType("boolean"), "get", new ArrayList<Parameter>(), fBody);
        methods.add(getter);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, PrimitiveType.INTEGER));
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    /**
     * public class TestClass {
     * public TestClass() {
     * }
     * <p>
     * public boolean get() {
     * Object var1 = null;
     * return var1 == null;
     * }
     * }
     *
     * @return
     */

    public static Clazz testNull() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> fContent = new ArrayList<>();

        fContent.add(new LocalVarDecl(new AstType("Object"), "a", ObjectType.object()));
        var a = new LocalOrFieldVar("a", ObjectType.object());
        fContent.add(new StmtExprStmt(new Assign(a, new JNull(ObjectType.jNull()))));


        fContent.add(new Return(new Binary("==", a, new JNull(ObjectType.jNull()), PrimitiveType.BOOLEAN)));

        Statement fBody = new Block(fContent, PrimitiveType.BOOLEAN);
        Method getter = new Method(PrimitiveType.BOOLEAN, new AstType("boolean"), "get", new ArrayList<Parameter>(), fBody);
        methods.add(getter);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, null));
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    /**
     * public class TestClass {
     * public TestClass() {
     * }
     * <p>
     * public String get() {
     * String var1 = "Compilerbau macht Spaß";
     * return var1;
     * }
     * }
     *
     * @return
     */

    public static Clazz testString() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> fContent = new ArrayList<>();

        fContent.add(new LocalVarDecl(new AstType("String"), "a", ObjectType.string()));
        var a = new LocalOrFieldVar("a", ObjectType.string());
        fContent.add(new StmtExprStmt(new Assign(a, new JString("Compilerbau macht Spaß", ObjectType.string()))));


        fContent.add(new Return(a));

        Statement fBody = new Block(fContent, ObjectType.string());
        Method getter = new Method(ObjectType.string(), new AstType("String"), "get", new ArrayList<Parameter>(), fBody);
        methods.add(getter);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, null));
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    // LocalOrFieldVar tested already
    // StmtExprExpr tested already -> testInstVar()


    // TODO test super()

    /**
     * public class TestClass {
     * public TestClass() {
     * }
     * <p>
     * public TestClass get() {
     * return this;
     * }
     * }
     *
     * @return
     */

    public static Clazz testThis() {

        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> fContent = new ArrayList<>();

        fContent.add(new Return(new This(new ObjectType("TestClass"))));

        Statement fBody = new Block(fContent, ObjectType.string());
        Method getter = new Method(new ObjectType("TestClass"), new AstType("TestClass"), "get", new ArrayList<Parameter>(), fBody);
        methods.add(getter);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, null));
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    // TODO
    public static Clazz testUnary() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> fContent = new ArrayList<>();

        fContent.add(new LocalVarDecl(new AstType("int"), "a", PrimitiveType.INTEGER));
        var a = new LocalOrFieldVar("a", PrimitiveType.INTEGER);
        fContent.add(new StmtExprStmt(new Assign(a, new JInteger("3", PrimitiveType.INTEGER)), PrimitiveType.INTEGER));
        fContent.add(new StmtExprStmt(new Assign(a, new Unary("--", a, PrimitiveType.INTEGER)), PrimitiveType.INTEGER));

        fContent.add(new Return(a));

       /* fContent.add(new LocalVarDecl(new AstType("boolean"), "a", PrimitiveType.BOOLEAN));
        var a = new LocalOrFieldVar("a", PrimitiveType.BOOLEAN);
        fContent.add(new StmtExprStmt(new Assign(a, new JBoolean("false", PrimitiveType.BOOLEAN))));
        fContent.add(new Return(new Unary("!", a, PrimitiveType.BOOLEAN)));*/

        Statement fBody = new Block(fContent, PrimitiveType.INTEGER);
        Method getter = new Method(PrimitiveType.INTEGER, new AstType("int"), "get", new ArrayList<Parameter>(), fBody);
        methods.add(getter);

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, null));
        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }

    /**
     * public class TestClass {
     *     public TestInstVar var;
     *
     *     public TestClass() {
     *       this.var = new TestInstVar();
     *     }
     *
     *     public int get() {
     *         this.var.test += 3;
     *         return this.var.test;
     *     }
     * }
     * @return
     */


    public static Clazz testInstVar2() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        ArrayList<Statement> fContent = new ArrayList<>();

        var testClassType = new ObjectType("TestInstVar");



//        Field f = new Field(testClassType, new AstType("TestInstVar"), "var");
//        fields.add(f);
//        var fieldVar = new LocalOrFieldVar("var", testClassType);
//        bodyContent.add(new StmtExprStmt(
//            new Assign(
//                fieldVar,
//                new StmtExprExpr(
//                    new New(
//                        new AstType("TestInstVar"),
//                        new ArrayList<Expression>(),
//                        testClassType),
//                    testClassType),
//                testClassType)));

        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), new Block(bodyContent, null));


        LocalOrFieldVar localVar = new LocalOrFieldVar("localVar", testClassType);

        var instLocal = new InstVar(localVar, "test", PrimitiveType.INTEGER);
        fContent.add(new LocalVarDecl(new AstType("TestInstVar"), "localVar", testClassType));
        fContent.add(new StmtExprStmt(
            new Assign(localVar
                ,
                new StmtExprExpr(
                    new New(
                        new AstType("TestInstVar"),
                        new ArrayList<Expression>(),
                        testClassType),
                    testClassType),
                testClassType)));

        fContent.add(new StmtExprStmt(
            new Assign(
                instLocal, new Binary("+", instLocal, new JInteger("3", PrimitiveType.INTEGER), PrimitiveType.INTEGER)),
            PrimitiveType.INTEGER));

        fContent.add(new Return(instLocal));

        Statement fBody = new Block(fContent, PrimitiveType.INTEGER);
        Method getter = new Method(PrimitiveType.INTEGER, new AstType("int"), "get", new ArrayList<Parameter>(), fBody);
        methods.add(getter);

        constr.add(m);

        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods);
    }


    // Statement Expressions

    /**
     * public class TestClassWhile{
     * public int callDoWhile(){
     * return doWhile();
     * }
     * <p>
     * public int doWhile(){
     * int i = 10;
     * int c = 0;
     * while( i > 0){
     * i = i - 1;
     * c = c + 1;
     * }
     * return c;
     * }
     * }
     *
     * @return
     */
    public static Clazz testCaseMethodCall() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> doWhileBodyContent = new ArrayList<>();
        ArrayList<Statement> callDoWhileBodyContent = new ArrayList<>();

        ArrayList<Statement> whileBody = new ArrayList<>();
        whileBody.add(new StmtExprStmt(new Assign(
            new LocalOrFieldVar("i", PrimitiveType.INTEGER),
            new Binary(
                "-",
                new LocalOrFieldVar("i", PrimitiveType.INTEGER),
                new JInteger("1", PrimitiveType.INTEGER), PrimitiveType.INTEGER)),
            PrimitiveType.INTEGER));
        whileBody.add(new StmtExprStmt(new Assign(
            new LocalOrFieldVar("c", PrimitiveType.INTEGER),
            new Binary(
                "+",
                new LocalOrFieldVar("c", PrimitiveType.INTEGER),
                new JInteger("1", PrimitiveType.INTEGER), PrimitiveType.INTEGER)),
            PrimitiveType.INTEGER));

        doWhileBodyContent.add(new LocalVarDecl(new AstType("int"), "i", PrimitiveType.INTEGER));
        doWhileBodyContent.add(new StmtExprStmt(
            new Assign(
                new LocalOrFieldVar("i", PrimitiveType.INTEGER),
                new JInteger("10", PrimitiveType.INTEGER))));
        doWhileBodyContent.add(new LocalVarDecl(new AstType("int"), "c", PrimitiveType.INTEGER));
        doWhileBodyContent.add(new StmtExprStmt(
            new Assign(
                new LocalOrFieldVar("c", PrimitiveType.INTEGER),
                new JInteger("0", PrimitiveType.INTEGER))));
        doWhileBodyContent.add(new While(
            new Binary(
                ">",
                new LocalOrFieldVar("i", PrimitiveType.INTEGER),
                new JInteger("0", PrimitiveType.INTEGER), PrimitiveType.INTEGER),
            new Block(whileBody, PrimitiveType.INTEGER)));

        doWhileBodyContent.add(new Return(new LocalOrFieldVar("c", PrimitiveType.INTEGER), PrimitiveType.INTEGER));
        callDoWhileBodyContent.add(new Return(
            new StmtExprExpr(
                new MethodCall(
                    new This(new ObjectType("TestClassMethodCall")),
                    "doWhile",
                    new ArrayList<>(),
                    PrimitiveType.INTEGER), PrimitiveType.INTEGER), PrimitiveType.INTEGER));
        Statement callDoWhileBody = new Block(callDoWhileBodyContent, PrimitiveType.INTEGER);
        Statement doWhileBody = new Block(doWhileBodyContent, PrimitiveType.INTEGER);

        Method methodCallDoWhile = new Method(PrimitiveType.INTEGER, new AstType("int"), "callDoWhile", new ArrayList<>(), callDoWhileBody);
        Method methodDoWhile = new Method(PrimitiveType.INTEGER, new AstType("int"), "doWhile", new ArrayList<>(), doWhileBody);
        methods.add(methodCallDoWhile);
        methods.add(methodDoWhile);

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClassMethodCall"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClassMethodCall"), new AstType("TestClassMethodCall"), fields, constr, methods);
    }


    // Statement Expressions

    /**
     * public class TestClassNewCaller{
     * public TestClass getTestClass(){
     * return new TestClass();
     * }
     * }
     *
     * @return
     */
    public static Clazz testCaseNew() {
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();

        ObjectType testClassObjectType = new ObjectType("TestClass");

        ArrayList<Statement> getTestClassBlockStmts = new ArrayList<>();
        getTestClassBlockStmts.add(new Return(
            new StmtExprExpr(
                new New(
                    new AstType("TestClass"),
                    new ArrayList<>(),
                    testClassObjectType
                ),
                testClassObjectType), testClassObjectType));
        Statement getTestClassBody = new Block(getTestClassBlockStmts, new ObjectType("TestClass"));

        Method getTestClass = new Method(testClassObjectType, new AstType("TestClass"), "getTestClass", new ArrayList<>(), getTestClassBody);
        methods.add(getTestClass);

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClassNew"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClassNew"), new AstType("TestClassNew"), fields, constr, methods);
    }
}
