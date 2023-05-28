package de.dhbw.compiler.codegeneration;

import de.dhbw.compiler.ast.Method;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.MethodCall;
import de.dhbw.compiler.ast.stmtexprs.New;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodCodeVisitor implements Opcodes {

    MethodVisitor v;
    MethodVarStack vars;
    public MethodCodeVisitor(MethodVisitor v){
        this. v = v;
        this.vars = new MethodVarStack();

    }
    public void visit(Method m){
        vars.addVar("this");
        m.parameters().forEach(p -> vars.addVar(p.name()));
    }
    public void visit(Block stmt) {
        stmt.stmts().forEach(s -> s.accept(this));
    }

    public void visit(Return ret){
        ret.expression().accept(this);


        // TODO can we do void-return?
        if(ret.expression() == null){
            v.visitInsn(RETURN);
        }
        // return opcode for bool, int, char, byte, short
        // TODO find generic expression for type = bool or int or Boolean or java/lang/Integer, etc.
        else if(ret.expression().type() == "bool" || ret.expression().type() == "int" || ret.expression().type() == "char"){
            v.visitInsn(IRETURN);
        }
        else{
            v.visitInsn(ARETURN);
        }
    }

    public void visit(If stmt){

        Label elseBranch = new Label();
        Label end = new Label();

        stmt.condition().accept(this);

        v.visitJumpInsn(IFEQ, elseBranch);      // if result of above visit is false (i.e. 0) -> go to else label, otherwise continue here
        stmt.ifBody().accept(this);
        v.visitJumpInsn(GOTO, end);
        v.visitLabel(elseBranch);
        stmt.elseBody().accept(this);
        v.visitLabel(end);
    }

    public void visit(While stmt){
        Label whileStart = new Label();
        Label end = new Label();


        v.visitLabel(whileStart);
        stmt.condition().accept(this);
        v.visitJumpInsn(IFEQ, end);
        stmt.statement().accept(this);
        // TODO find out if we have to clear whatever to body put onto the operator stack?
        v.visitJumpInsn(GOTO, whileStart);
        v.visitLabel(end);
    }

    public void visit (StmtExprStmt stmt){
        stmt.statementExpression().accept(this);
    }

    public void visit (LocalVarDecl stmt){
        // assuming that declaration and initialization are not possible at the same time / line of code
        vars.addVar(stmt.name());
    }

    public void visit(Assign stmtExpr){
        // TODO only deals with local vars at this moment
        // TODO field vars

        // TODO do proper type matching
        if(stmtExpr.var() == "element of local vars") {
            stmtExpr.value().accept(this);

            if (stmtExpr.value().type() == "bool, int, char, byte, short, etc.") {
                v.visitVarInsn(ISTORE, vars.getVar(stmtExpr.var()));
            }
            // TODO if we have any other type than int-derivative and other, we need to add this here
            else {
                v.visitVarInsn(ASTORE, vars.getVar(stmtExpr.var()));
            }
        }
        else{
            // TODO putfield
        }


    }

    // TODO for the following two methods we might need a method stack or class stack to determine the references to methods based on their names

    public void visit(MethodCall stmtExpr){
        //TODO
    }

    public void visit(New stmtExpr){
        // TODO

    }

}
