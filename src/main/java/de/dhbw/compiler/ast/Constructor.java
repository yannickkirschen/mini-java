package de.dhbw.compiler.ast;

import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;

import java.util.List;

public class Constructor {
    Type type;
    public List<Parameter> parameterList;
    public Statement body;

    public Constructor(Type type, List<Parameter> parameterList, Statement body) {
        this.type = type;
        this.parameterList = parameterList;
        this.body = body;
    }

    public Constructor(List<Parameter> parameterList, Statement body) {
        this.parameterList = parameterList;
        this.body = body;
    }

    public void accept(MethodCodeVisitor v){
        v.visit(this);
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

    public Statement getBody() {
        return body;
    }

    public void setBody(Statement body) {
        this.body = body;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
