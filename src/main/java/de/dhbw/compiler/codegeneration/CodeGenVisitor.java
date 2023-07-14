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
import java.util.Arrays;
import java.util.List;

public class CodeGenVisitor implements Opcodes {
    private static final String[] knownDescriptors = new String[]{"V", "B", "C", "D", "F", "I", "J", "S", "Z"};

    /**
     * visits a class.
     * Firstly a new classWriter is generated.
     * The java-version, the access-modifiers of the class (both hardcoded to java8 and public) and the class-name are put into the classwriter.
     * After that all the fields, constructors and methods are visited.
     * In the end the writing process is ended using cw.visitEnd() and the actual bytes are written into a file.
     * @param clazz the Clazz to be processed
     */
    public void visitClass(Clazz clazz) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(V1_8, ACC_PUBLIC, clazz.name.name(), null, "java/lang/Object", null);
        for (Field t : clazz.fields) {
            visitField(t, cw);
        }

        for (Constructor c : clazz.constructors) {
            MethodCodeVisitor mcv = new MethodCodeVisitor(cw.visitMethod(ACC_PUBLIC, "<init>", extractMethodDescriptor(PrimitiveType.VOID, c.getParameterList()), null, null), clazz.name.name());
            mcv.visit(c);
        }

        for (Method m : clazz.methods) {
            MethodCodeVisitor mcv = new MethodCodeVisitor(cw.visitMethod(Opcodes.ACC_PUBLIC, m.name, extractMethodDescriptor(m.getType(), m.parameters), null, null), clazz.name.name());
            mcv.visit(m);
        }
        cw.visitEnd();
        writeFile(cw.toByteArray(), clazz.name.name());
    }


    /**
     * visits a field.
     * This is done using the visitField method of the ASM-classwriter.
     * Since only public non-static fields are allowed, the ACC_PUBLIC can be hardcoded.
     * @param field the abstract-syntax description of the field
     * @param cw the classwriter for the class that the field is to be written to
     */
    public void visitField(Field field, ClassWriter cw) {
        cw.visitField(ACC_PUBLIC, field.name, extractTypeString(field.getType()), null, null).visitEnd();
    }

    private String extractTypeString(AstType astType) {
        return "";
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

    public Type parseType(Type t) {
        return parseType(t.getName());
    }

    public Type parseType(String type) {
        switch (type) {
            case "java.lang.Integer" -> {
                return PrimitiveType.INTEGER;
            }
            case "java.lang.Character" -> {
                return PrimitiveType.CHARACTER;
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
        if (t instanceof ObjectType) {
            return String.format("L%s;", t.getName());
        } else {
            return t.getName();
        }

    }

    public String extractMethodDescriptor(Type returnType, List<Parameter> params) {
        StringBuilder out = new StringBuilder("()");
        for (Parameter p : params) {
            out.insert(1, p.getType().getName());
        }
        out.append(Arrays.stream(knownDescriptors).anyMatch(n -> n.equals(returnType.getName())) ? returnType.getName() : "L" + returnType.getName() + ";");
        return out.toString();
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
