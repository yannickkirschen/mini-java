package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.statements.Block;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.typecheck.model.*;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CodeGenVisitor implements Opcodes {

    public void visitClass(TypedClazz clazz){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(V1_8, ACC_PUBLIC, clazz.name(), null, "java/lang/Object", null);
        for(TypedField t : clazz.typedFields()){
            visitField(t, cw);
        }

        for(TypedMethod<? extends Statement> m : clazz.typedMethods()){
            visitMethod(m, cw);
        }
        cw.visitEnd();
        writeFile(cw.toByteArray(), clazz.name());
    }

    public void visitField(TypedField field, ClassWriter cw){
        cw.visitField(ACC_PUBLIC, field.name(), extractTypeString(field.type()), null, null).visitEnd();
    }

    public void visitMethod(TypedMethod<? extends Statement> method, ClassWriter cw){
        MethodVisitor v = cw.visitMethod(extractMethodKeywords(),method.name(), extractMethodDescriptor(method.returnTypedType(), method.typedParameters()), null, null);
        v.visitCode();
        // TODO introduce localVarStack
        // method.typedParameters().forEach(t -> pushToLocalVarStack);
        // TODO transform classes and add visitor
        // visitStatement(method.typedStatement(), v);

    }

    public void visitStatement(Block stmt, MethodVisitor v){

    }


    public String extractTypeString(TypedType t){
        //TODO extract type to String
        return "java/lang/String";
    }

    public int extractMethodKeywords(){
        // TODO
        // TODO also find out where / how they are passed in the first place
        return 0;
    }

    public String extractMethodDescriptor(TypedType returnType, List<TypedParameter> params) {
        return "(I)I";
    }

    public void writeFile(byte[] bytes, String filename){
        File output = new File(filename + ".class");
        try(FileOutputStream out = new FileOutputStream(output)){
            out.write(bytes);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
