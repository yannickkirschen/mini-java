package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.statements.Block;
import de.dhbw.compiler.ast.statements.LocalVarDecl;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.codegeneration.ObjectType;
import de.dhbw.compiler.codegeneration.PrimitiveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodCheckerTest {
    MethodChecker methodChecker;

    @BeforeEach
    void setup(){
        Field field = new Field(null, null, "boolen");

        List<Field> fields = new ArrayList<>();
        fields.add(0, field);
        AstType astType0  = new AstType("boolean");
        Clazz  clazz = new Clazz(PrimitiveType.INTEGER,
            astType0,
            fields,
            null,
            null);
        methodChecker = new MethodChecker(clazz, null);
    }
    @Test
    void MethodcheckTest() throws SyntaxException, TypeException {
        AstType astType = new AstType("boolean");//Würde Statement gerne nicht gleich null haben weil sonst gints probleme
        LocalVarDecl localVarDecl = new LocalVarDecl(astType,"localVarDecl",PrimitiveType.BOOLEAN);
        Parameter parameter = new Parameter(new ObjectType("boolean"),astType,"parameter");
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(parameter);
        Method method1 = new Method(astType, "testing", parameters, localVarDecl);
        Method method2 = methodChecker.check(method1);
        assertEquals(PrimitiveType.BOOLEAN, method2.getType());
    }
    @Test
    void ParametercheckTest0() throws SyntaxException {
        AstType astType = new AstType("boolean");
        Parameter parameter = new Parameter(new ObjectType("boolean"),astType,"parameter");
        assertEquals(PrimitiveType.BOOLEAN, methodChecker.check(parameter));
    }
    @Test
    void ParametercheckTest1() throws SyntaxException {
        AstType astType = new AstType("int");
        Parameter parameter = new Parameter(new ObjectType("int"),astType,"parameter");
        assertEquals(PrimitiveType.INTEGER, methodChecker.check(parameter).getType());
    }
    @Test
    void ParametercheckTest2() throws SyntaxException {
        AstType astType = new AstType("char");
        Parameter parameter = new Parameter(new ObjectType("char"),astType,"parameter");
        assertEquals(PrimitiveType.CHARACTER, methodChecker.check(parameter).getType());
    }
    @Test
    void ParametercheckTest3() throws SyntaxException {
        AstType astType = new AstType("String");//Error unexpected method argument String
        Parameter parameter = new Parameter(new ObjectType("String"),astType,"parameter");
        assertEquals(ObjectType.string().getClass(), methodChecker.check(parameter).getType().getClass());
    }
    @Test
    void ParametercheckTest4() throws SyntaxException {
        AstType astType = new AstType("boolean");
        Parameter parameter = new Parameter(new ObjectType(methodChecker.getClass().getName()),astType,"parameter");
    }

}
