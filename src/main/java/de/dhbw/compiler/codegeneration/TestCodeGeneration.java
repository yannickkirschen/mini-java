package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.AstType;

import java.util.ArrayList;


public class TestCodeGeneration {
    public static void main(String[] args){
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Clazz> clazzes = new ArrayList<>();

        Field f = new Field(PrimitiveType.INTEGER, new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);
        clazzes.add(new Clazz(new ObjectType("TestClass"), new AstType("TestClass"), fields, constr, methods ));
        Program p = new Program(clazzes);

        CodeGenVisitor visitor = new CodeGenVisitor();
        visitor.visitClass(clazzes.get(0));


    }
}
