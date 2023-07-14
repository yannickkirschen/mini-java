package de.dhbw.compiler.ast;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.ibm.icu.impl.Assert;
import de.dhbw.compiler.ast.Program;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.parser.ASTGenerator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.Test;
import de.dhbw.compiler.ast.expressions.*;
import org.objectweb.asm.MethodVisitor;
import de.dhbw.compiler.parser.antlr.*;

public class UnitTests {
    protected void testParseTree(String in, String expected) {
        CharStream input = CharStreams.fromString( in );
        MinijavaLexer lexer = new MinijavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MinijavaParser parser = new MinijavaParser(tokens);
        MinijavaParser.ProgramContext tree = parser.program();
        Program out = ASTGenerator.generateAST(tree);

        String outString = out.classes().get(0).toString();
        assertEquals(expected, outString);
    }
    @Test
    void BinaryTestOK(){
        Binary i = new Binary("+", new JInteger("5", PrimitiveType.INTEGER), new JInteger("-2", PrimitiveType.INTEGER), PrimitiveType.INTEGER);
        assertEquals("+", i.operator);
        assertEquals(PrimitiveType.INTEGER, i.left.getType());
        assertEquals("5", ((JInteger)i.left).value);
        assertEquals(PrimitiveType.INTEGER, i.right.getType());
        assertEquals("-2", ((JInteger)i.right).value);
    }

    @Test
    void BinaryTestMixOK(){
        Binary i = new Binary("-", new JBoolean("true", PrimitiveType.BOOLEAN), new JInteger("-2", PrimitiveType.INTEGER), PrimitiveType.INTEGER);
        assertEquals("-", i.operator);
        assertEquals(PrimitiveType.BOOLEAN, i.left.getType());
        assertEquals("true", ((JBoolean)i.left).value);
        assertEquals(PrimitiveType.INTEGER, i.right.getType());
        assertEquals("-2", ((JInteger)i.right).value);
    }

    @Test
    void EmptyClass(){
        try {
            testParseTree("class Leer { }", "Leer\nLeer()\nBlock()");
        }catch(Exception e){
            fail("Leere Klasse Fall 1 fehlgeschlagen");
        }
        try {
            testParseTree("class Leer { Leer( ){  } }", "Leer\nLeer()\nBlock()");
        }catch(Exception e){
           fail("Leere Klasse Fall 2 fehlgeschlagen");
        }
        /*try {
            testParseTree("class Leer { int x; Leer(int x){ int i = x; } }", "Leer\nint x\nLeer(int x )\nBlock()");
        }catch(Exception e){
            fail("Leere Klasse Fall 3 fehlgeschlagen");
        }
        try{
            testParseTree("class Leer { int x; Leer(int x) Leer(boolean y) { int i = x; } }", "Leer\nint x\nLeer(int x )\nLeer(bool y )\n");
        }catch(Exception e){
            fail("Leere Klasse Fall 4 fehlgeschlagen");
        }*/
    }

    @Test
    void EmptyMethod(){
        testParseTree("class Leer { boolean boomethod(){ }}", "Leer\nLeer()\nBlock()\nboolean\sboomethod()\nBlock()");
    }

    @Test
    void Binary(){
        testParseTree("class Leer { void boomethod(){ int x = 0; x = x + x; }}", "Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclint(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JInteger:0))StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=Binary:LocalOrFieldVar:x+LocalOrFieldVar:x))");
    }

    @Test
    void Boolean(){
        testParseTree("class Leer { boolean boomethod(){ boolean x = true; }}", "Leer\nLeer()\nBlock()\nboolean\sboomethod()\nBlock(Block(LocalVarDeclboolean(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JBoolean:true)))");
    }

    @Test
    void InstVar(){
        testParseTree("class Leer  {boolean x; void boomethod(){ this.x = false; }}", "Leer\nboolean x\nLeer()\nBlock()\nvoid boomethod()\nBlock(StmtExprStmt(StatementExpression: Assign:InstVar:x=This:=JBoolean:false))");
    }

    @Test
    void Character(){
        testParseTree("class Leer  {void boomethod(){ char x='x'; }}", "Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclchar(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JCharacter:x)))");
    }

    @Test
    void Integer(){
        testParseTree("class Leer  {void boomethod(){ int x = 1; }}", "Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclint(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JInteger:1)))");
    }

    @Test
    void String(){
        testParseTree("class Leer  {void boomethod(){ string x = \"null\"; }}", "Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclstring(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JString:null)))");
    }

    @Test
    void Null(){
        testParseTree("class Leer  {void boomethod(){ string x = null; }}", "Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclstring(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JNull:)))");
    }

    @Test
    void LocalOrFieldVar(){
        testParseTree("class Leer  {void boomethod(){ int y; int x; x = y; }}", "Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(LocalVarDeclint(Name: y)LocalVarDeclint(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=LocalOrFieldVar:y))");
    }

    @Test
    void Unary(){
        testParseTree("class Leer  {void boomethod(){ boolean x = !true; }}", "Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclboolean(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=Unary:JBoolean:true!)))");
    }

    @Test
    void If(){
        testParseTree("class Leer { int x; boolean boomethod(){ if(true) {int a = 1;} else { int z = -99;}}}", "Leer\n" +
            "int x\n" +
            "Leer()\n" +
            "Block()\n" +
            "boolean boomethod()\n" +
            "Block(If(Expression: JBoolean:trueif body: Block(Block(LocalVarDeclint(Name: a)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:a=JInteger:1)))else body: Block(Block(LocalVarDeclint(Name: z)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:z=Binary:JInteger:0-JInteger:99)))))");
    }

    @Test
    void Return(){
        testParseTree("class Leer { int boomethod(){ return 25; }}", "Leer\n" +
            "Leer()\n" +
            "Block()\n" +
            "int boomethod()\n" +
            "Block(Return(Expression: JInteger:25))");
    }

    @Test
    void While(){
        testParseTree("class Leer { void boomethod(){ while( true == false ){ return true; } }}", "Leer\n" +
            "Leer()\n" +
            "Block()\n" +
            "void boomethod()\n" +
            "Block(While(Expression: Binary:JBoolean:true==JBoolean:falseStatement: Block(Return(Expression: JBoolean:true))))");
    }

    @Test
    void MethodCall(){
        testParseTree("class Leer { void boomethod(){ boomethod(); }}", "Leer\n" +
            "Leer()\n" +
            "Block()\n" +
            "void boomethod()\n" +
            "Block(StmtExprStmt(StatementExpression: MethodCall:This:boomethod:args:))");
    }

    @Test
    void New(){
        testParseTree("class Leer { Leer(){} void boomethod(){ Leer empty = new Leer(); } }", "Leer\n" +
            "Leer()\n" +
            "Block()\n" +
            "void boomethod()\n" +
            "Block(Block(LocalVarDeclLeer(Name: empty)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:empty=StmtExprExpr:New: Type:AstType[name=Leer])))");
    }
    //Verschiedenes

    @Test
    void SimpleClass(){
        testParseTree("class Leer { int x; Leer(int x){ int i = x; } boolean boomethod(){ if(true) {return false;} else { return true;}}}", "Leer\nint x\nLeer(int x )\nBlock(Block(LocalVarDeclint(Name: i)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:i=LocalOrFieldVar:x)))\nboolean boomethod()\nBlock(If(Expression: JBoolean:trueif body: Block(Return(Expression: JBoolean:false))else body: Block(Return(Expression: JBoolean:true))))");
    }

    @Test
    void CallOwnConstructor(){
        testParseTree("class Leer { int x; Leer(int x){ int i = x; } boolean boomethod( ){ if(true) {return false;} else { return true;} Leer blah = new Leer(); int i = blah.x;}}", "Leer\n" +
            "int x\n" +
            "Leer(int x )\n" +
            "Block(Block(LocalVarDeclint(Name: i)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:i=LocalOrFieldVar:x)))\n" +
            "boolean boomethod()\n" +
            "Block(If(Expression: JBoolean:trueif body: Block(Return(Expression: JBoolean:false))else body: Block(Return(Expression: JBoolean:true)))Block(LocalVarDeclLeer(Name: blah)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:blah=StmtExprExpr:New: Type:AstType[name=Leer]))Block(LocalVarDeclint(Name: i)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:i=InstVar:x=LocalOrFieldVar:blah)))");
    }
}
