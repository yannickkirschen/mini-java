package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
//import de.dhbw.compiler.typecheck.model.*;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CodeGenVisitor implements Opcodes {

    public void visitClass(Clazz clazz) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(V1_8, ACC_PUBLIC, clazz.name.name(), null, "java/lang/Object", null);
        for (Field t : clazz.fields) {
            visitField(t, cw);
        }

        for(Constructor c : clazz.constructors){
            MethodCodeVisitor mcv = new MethodCodeVisitor(cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null));
            mcv.visit(c);
        }

        for (Method m : clazz.methods) {
            MethodCodeVisitor mcv = new MethodCodeVisitor(cw.visitMethod(Opcodes.ACC_PUBLIC, m.name, extractMethodDescriptor(m.astType, m.parameters), null, null));
            mcv.visit(m);
        }
        cw.visitEnd();
        writeFile(cw.toByteArray(), clazz.name.name());
    }

    public void visitField(Field field, ClassWriter cw) {
        cw.visitField(ACC_PUBLIC, field.name, extractTypeString(field.getType()), null, null).visitEnd();
    }

    private String extractTypeString(AstType astType) {
        return "";
    }

    /*public void visitMethod(Method method, ClassWriter cw) {
        MethodVisitor v = cw.visitMethod(extractMethodKeywords(), method.name(), extractMethodDescriptor(method.returnType(), method.parameters()), null, null);
        v.visitCode();
        // TODO introduce localVarStack
        method.parameters().forEach(t -> );
        // TODO transform classes and add visitor
        // visitStatement(method.typedStatement(), v);

    }
    */

    private String extractMethodDescriptor(AstType astType, List<Parameter> parameters) {
        return "()V";
    }


    public void visitExpression(Expression stmt) {

    }

    public Type parseType(Expression obj) {
        return parseType(obj.getType());
    }
    public Type parseType(Statement obj) {
        return parseType(obj.getType());
    }
    public Type parseType(StatementExpression obj) {
        return parseType(obj.getType());
    }

    public Type parseType(Type t){
        return parseType(t.getName());
    }

    public Type parseType(String type) {
        switch (type) {
            case "java.lang.Integer" -> {
                return PrimitiveType.INTEGER;
            }
            case "java.lang.Character" -> {
                return PrimitiveType.CHARAKTER;
            }
            case "java.lang.Boolean" -> {
                return PrimitiveType.BOOLEAN;
            }
            default -> {
                return new ObjectType(type);
            }
        }
    }


    public String extractTypeString(Type t) {
        //TODO extract type to String

        return "Ljava/lang/String;";
    }

    public int extractMethodKeywords() {
        // TODO
        // TODO also find out where / how they are passed in the first place
        return 0;
    }

    public String extractMethodDescriptor(Type returnType, List<Parameter> params) {
        return "(I)I";
    }

    public void writeFile(byte[] bytes, String filename) {
        File output = new File(filename + ".class");
        try (FileOutputStream out = new FileOutputStream(output)) {
            out.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}