package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.AstType;
import de.dhbw.compiler.ast.expressions.JInteger;
import de.dhbw.compiler.ast.expressions.LocalOrFieldVar;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.ast.stmtexprs.Assign;

import java.util.ArrayList;


public class TestCodeGeneration {
    public static void main(String[] args) throws NoSuchMethodException {
        //System.out.println(Type.getMethodDescriptor(TestCodeGeneration.class.getMethod("test")));
        ArrayList<Clazz> clazzes = new ArrayList<>();
        clazzes.add(testCase5());
        Program p = new Program(clazzes);

        CodeGenVisitor visitor = new CodeGenVisitor();
        visitor.visitClass(clazzes.get(0));

    }

    public static Clazz testCaseEmptyClass(){
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), new ArrayList<Field>(), constr, methods );
    }
    public static Clazz testCaseClassWField(){
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();


        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods );
    }

    /**
     * public class TestClass {
     *     public int field;
     *
     *     public TestClass() {
     *     }
     *
     *     public int getInt() {
     *         return this.field;
     *     }
     * }
     * @return
     */
    public static Clazz testCaseClassWFieldAndStmt(){
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
        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods );
    }

    /**
     * public class TestClass {
     *     public int field;
     *
     *     public TestClass() {
     *     }
     *
     *     public int getInt() {
     *         field = 3;
     *         return this.field;
     *     }
     * }
     * @return
     */
    public static Clazz testCase4(){
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
        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods );
    }
    /**
     * public class TestClass {
     *     public int field;
     *
     *     public TestClass() {
     *     }
     *
     *     public int getInt() {
     *         int i;
     *         i = 4000;
     *         return i;
     *     }
     * }
     * @return
     */
    public static Clazz testCase5(){
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        bodyContent.add(new LocalVarDecl(new AstType("int"), "i", PrimitiveType.INTEGER));
        bodyContent.add(new StmtExprStmt(new Assign(new LocalOrFieldVar("i", PrimitiveType.INTEGER), new JInteger("4000"))));
        bodyContent.add(new Return(new LocalOrFieldVar("i", PrimitiveType.INTEGER)));
        Statement body = new Block(bodyContent, PrimitiveType.INTEGER);

        Method method = new Method(PrimitiveType.INTEGER, new AstType("int"), "getInt", new ArrayList<Parameter>(), body);
        methods.add(method);

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);
        return new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods );
    }

}
