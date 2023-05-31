package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.Type;
import de.dhbw.compiler.ast.statements.Block;
import de.dhbw.compiler.ast.statements.Statement;

import java.util.ArrayList;
import java.util.Arrays;


public class TestCodeGeneration {
    public static void main(String[] args){
        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Clazz> clazzes = new ArrayList<>();
        // TODO
        Method m = new Method(new Type("VOID"), "TestClass", new ArrayList<Parameter>(), new Block(new ArrayList<Statement>(), new ObjectType("VOID")));
        methods.add(m);
        clazzes.add(new Clazz(new Type("TestClass"), fields, methods ));
        Program p = new Program(clazzes);

        CodeGenVisitor visitor = new CodeGenVisitor();
        visitor.visitClass(clazzes.get(0));


    }
}
