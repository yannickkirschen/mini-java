package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.typecheck.*;
import de.dhbw.compiler.typecheck.model.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StatementVisitor implements BaseStatementVisitor {
    private final String className;
    private final List<TypedLocalVar> localVariables;

    private final BaseExpressionVisitor expressionVisitor;
    private final BaseStatementExpressionVisitor statementExpressionVisitor;

    @Override
    public TypedStatement<? extends Statement> visit(Statement statement) throws SyntaxException, TypeException {
        Class<?> clazz = statement.getClass();

        if (clazz.equals(Block.class)) {
            return visit((Block) statement);
        } else if (clazz.equals(If.class)) {
            return visit((If) statement);
        } else if (clazz.equals(LocalVarDecl.class)) {
            return visit((LocalVarDecl) statement);
        } else if (clazz.equals(Return.class)) {
            return visit((Return) statement);
        } else if (clazz.equals(StmtExprStmt.class)) {
            return visit((StmtExprStmt) statement);
        } else if (clazz.equals(While.class)) {
            return visit((While) statement);
        }

        throw new SyntaxException("Unexpected statement: %s", statement);
    }

    @Override
    public TypedStatement<? extends Statement> visit(Block block) throws SyntaxException, TypeException {
        for (Statement stmt : block.stmts()) {
            TypedStatement<? extends Statement> typedStatement = visit(stmt);

            if (typedStatement.statement().getClass().equals(Return.class)) {
                return new TypedStatement<>(new TypedType(typedStatement.type().name()), block);
            }
        }

        return new TypedStatement<>(new TypedType("void"), block);
    }

    @Override
    public TypedStatement<? extends Statement> visit(If if_) throws SyntaxException, TypeException {
        TypedExpression<? extends Expression> typedExpression = expressionVisitor.visit(if_.condition());

        if (typedExpression.type().name().equals("java.lang.Boolean")) {
            TypedStatement<? extends Statement> typedStatementIfBody = visit(if_.ifBody());
            if (if_.elseBody() != null) {
                TypedStatement<? extends Statement> typedStatementElseBody = visit(if_.elseBody());
                if (typedStatementIfBody.type().name().equals(typedStatementElseBody.type().name())) {
                    return new TypedStatement<>(new TypedType(typedStatementIfBody.type().name()), if_);
                }

                throw new SyntaxException("If and else body must be of same type");
            }

            return new TypedStatement<>(new TypedType(typedStatementIfBody.type().name()), if_);
        }

        throw new SyntaxException("If condition must be of type Boolean");
    }

    @Override
    public TypedStatement<? extends Statement> visit(LocalVarDecl localVarDecl) throws SyntaxException {
        switch (localVarDecl.type().name()) {
            case "Boolean", "boolean", "Integer", "int", "Character", "char", "String" -> {
                localVariables.add(new TypedLocalVar(new TypedType(localVarDecl.type().name()), localVarDecl.name()));
                return new TypedStatement<>(new TypedType(localVarDecl.type().name()), localVarDecl);
            }
            default -> {
                if (localVarDecl.type().name().equals(className)) {
                    localVariables.add(new TypedLocalVar(new TypedType(localVarDecl.type().name()), localVarDecl.name()));
                    return new TypedStatement<>(new TypedType(localVarDecl.type().name()), localVarDecl);
                }

                throw new SyntaxException("Unexpected type: %s", localVarDecl.type().name());
            }
        }
    }

    @Override
    public TypedStatement<? extends Statement> visit(Return return_) throws SyntaxException, TypeException {
        return new TypedStatement<>(expressionVisitor.visit(return_.expression()).type(), return_);
    }

    @Override
    public TypedStatement<? extends Statement> visit(StmtExprStmt stmtExprStmt) throws SyntaxException, TypeException {
        TypedStatementExpression typedStatementExpression = statementExpressionVisitor.visit(stmtExprStmt.statementExpression());
        return new TypedStatement<>(typedStatementExpression.type(), stmtExprStmt);
    }

    @Override
    public TypedStatement<? extends Statement> visit(While while_) throws SyntaxException, TypeException {
        TypedExpression<? extends Expression> typedExpression = expressionVisitor.visit(while_.condition());
        if (typedExpression.type().name().equals("java.lang.Boolean")) {
            return new TypedStatement<>(visit(while_.statement()).type(), while_);
        }

        throw new SyntaxException("While condition must be of type Boolean");
    }
}
