package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.AstType;
import de.dhbw.compiler.ast.expressions.JInteger;
import de.dhbw.compiler.ast.expressions.LocalOrFieldVar;
import de.dhbw.compiler.ast.statements.Block;
import de.dhbw.compiler.ast.statements.Return;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.ast.statements.StmtExprStmt;
import de.dhbw.compiler.ast.stmtexprs.Assign;

import java.util.ArrayList;


public class TestCodeGeneration {
    public static void main(String[] args) throws NoSuchMethodException {
        //System.out.println(Type.getMethodDescriptor(TestCodeGeneration.class.getMethod("test")));
        ArrayList<Clazz> clazzes = new ArrayList<>();
        clazzes.add(testCaseClassWFieldAndStmt());
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


}
