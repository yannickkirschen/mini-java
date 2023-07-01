package de.dhbw.compiler.ast;

import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.codegeneration.Type;
import lombok.Getter;

import java.util.List;

public class Method {
    @Getter
    public AstType astType;
    public String name;
    public List<Parameter> parameters;
    public Statement statement;
    Type type;

    public Method(Type type, AstType returnType, String name, List<Parameter> parameters, Statement statement) {
        this.type = type;
        this.astType = returnType;
        this.name = name;
        this.parameters = parameters;
        this.statement = statement;
    }

    public Method(AstType astType, String name, List<Parameter> parameters, Statement statement) {
        this.astType = astType;
        this.name = name;
        this.parameters = parameters;
        this.statement = statement;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
