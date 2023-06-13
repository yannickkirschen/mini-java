package de.dhbw.compiler.ast;

import de.dhbw.compiler.codegeneration.Type;

import java.util.List;

public class Clazz {
    Type type;
    public AstType name;
    public List<Field> fields;
    public List<Constructor> constructors;
    public List<Method> methods;

    public Clazz(Type type, AstType name, List<Field> fields, List<Constructor> constructors, List<Method> methods) {
        this.type = type;
        this.name = name;
        this.fields = fields;
        this.constructors = constructors;
        this.methods = methods;
    }

    public Clazz(AstType name, List<Field> fields, List<Constructor> constructors, List<Method> methods) {
        this.name = name;
        this.fields = fields;
        this.constructors = constructors;
        this.methods = methods;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
