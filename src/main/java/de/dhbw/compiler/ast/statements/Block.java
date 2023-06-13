package de.dhbw.compiler.ast.statements;

import de.dhbw.compiler.codegeneration.MethodCodeVisitor;
import de.dhbw.compiler.codegeneration.Type;

import java.util.List;

public non-sealed class Block implements Statement {
    public List<Statement> stmts;
    Type type;

    public Block(List<Statement> stmts, Type type) {
        this.stmts = stmts;
        this.type = type;
    }

    public Block(List<Statement> stmts) {
        this.stmts = stmts;
    }

    @Override
    public void accept(MethodCodeVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public de.dhbw.compiler.codegeneration.Type getType() {
        return type;
    }

    @Override
    public void setType(Type t) {
        type = t;
    }
}
