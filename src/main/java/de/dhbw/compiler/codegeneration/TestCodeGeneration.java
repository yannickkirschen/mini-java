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
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Clazz> clazzes = new ArrayList<>();
        // TODO
        Constructor m = new Constructor(new ObjectType("TestClass"), new ArrayList<>(), null);
        constr.add(m);
        clazzes.add(new Clazz(new Type("TestClass"), fields, constr, methods ));
        Program p = new Program(clazzes);

        CodeGenVisitor visitor = new CodeGenVisitor();
        visitor.visitClass(clazzes.get(0));


    }
}
