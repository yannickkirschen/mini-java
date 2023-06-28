package de.dhbw.compiler;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.expressions.LocalOrFieldVar;
import de.dhbw.compiler.ast.statements.Block;
import de.dhbw.compiler.ast.statements.Return;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.codegeneration.CodeGenerator;
import de.dhbw.compiler.typecheck.SyntaxException;
import de.dhbw.compiler.typecheck.TypeCheck;
import de.dhbw.compiler.typecheck.TypeException;

import java.util.ArrayList;

public class TypeCheckCodegen {



    public static void main(String[] args) throws SyntaxException, TypeException {

        ArrayList<Field> fields = new ArrayList<>();
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Constructor> constr = new ArrayList<>();
        ArrayList<Statement> bodyContent = new ArrayList<>();
        bodyContent.add(new Return(new LocalOrFieldVar("field")));
        Statement body = new Block(bodyContent);

        Method method = new Method(new AstType("int"), "getInt", new ArrayList<Parameter>(), body);
        methods.add(method);

        Field f = new Field(new AstType("int"), "field");
        fields.add(f);
        Constructor m = new Constructor(new ArrayList<>(), null);
        constr.add(m);

        //System.out.println(Type.getMethodDescriptor(TestCodeGeneration.class.getMethod("testCaseEmptyClass")));
        ArrayList<Clazz> clazzes = new ArrayList<>();
        clazzes.add(new Clazz(new AstType("TestClass"), fields, constr, methods));
        Program p = new Program(clazzes);
        TypeCheck types = new TypeCheck();
        p = types.check(p);
        CodeGenerator.generateCode(p);
    }
}
