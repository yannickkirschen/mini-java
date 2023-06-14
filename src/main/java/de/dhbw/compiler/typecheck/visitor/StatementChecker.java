package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.codegeneration.*;
import de.dhbw.compiler.typecheck.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StatementChecker implements BaseStatementChecker {
    private final String className;
    private final List<LocalOrFieldVar> localVariables;

    private final BaseExpressionChecker expressionVisitor;
    private final BaseStatementExpressionChecker statementExpressionVisitor;

    @Override
    public Statement check(Statement statement) throws SyntaxException, TypeException {
        Class<?> clazz = statement.getClass();

        if (clazz.equals(Block.class)) {
            return check((Block) statement);
        } else if (clazz.equals(If.class)) {
            return check((If) statement);
        } else if (clazz.equals(LocalVarDecl.class)) {
            return check((LocalVarDecl) statement);
        } else if (clazz.equals(Return.class)) {
            return check((Return) statement);
        } else if (clazz.equals(StmtExprStmt.class)) {
            return check((StmtExprStmt) statement);
        } else if (clazz.equals(While.class)) {
            return check((While) statement);
        }

        throw new SyntaxException("Unexpected statement: %s", statement);
    }

    @Override
    public Block check(Block block) throws SyntaxException, TypeException {
        for (Statement stmt : block.stmts) {
            Statement statement = check(stmt);

            if (statement.getClass().equals(Return.class)) {
                block.setType(statement.getType());
                return block;
            }
        }

        block.setType(PrimitiveType.VOID);
        return block;
    }

    @Override
    public If check(If if_) throws SyntaxException, TypeException {
        Expression expression = expressionVisitor.check(if_.condition);

        if (expression.getType().equals(PrimitiveType.BOOLEAN)) {
            Statement body = check(if_.ifBody);
            if (if_.elseBody != null) {
                Statement elseBody = check(if_.elseBody);
                if (body.getType().getName().equals(elseBody.getType().getName())) {
                    if_.setType(body.getType());
                    return if_;
                }

                throw new SyntaxException("If and else body must be of same type");
            }

            if_.setType(body.getType());
            return if_;
        }

        throw new SyntaxException("If condition must be of type Boolean");
    }

    @Override
    public LocalVarDecl check(LocalVarDecl localVarDecl) throws SyntaxException {
        switch (localVarDecl.getType().getName()) {
            case "Boolean", "boolean" -> localVarDecl.setType(PrimitiveType.BOOLEAN);
            case "Integer", "int" -> localVarDecl.setType(PrimitiveType.INTEGER);
            case "Character", "char" -> localVarDecl.setType(PrimitiveType.CHARACTER);
            case "String" -> localVarDecl.setType(ObjectType.string());
            default -> {
                if (localVarDecl.getType().getName().equals(className)) {
                    localVarDecl.setType(new ObjectType(className));
                }

                throw new SyntaxException("Unexpected type: %s", localVarDecl.getType().getName());
            }
        }

        localVariables.add(new LocalOrFieldVar(localVarDecl.name, localVarDecl.getType()));
        return localVarDecl;
    }

    @Override
    public Return check(Return return_) throws SyntaxException, TypeException {
        return_.setType(expressionVisitor.check(return_.expression).getType());
        return return_;
    }

    @Override
    public StmtExprStmt check(StmtExprStmt stmtExprStmt) throws SyntaxException, TypeException {
        stmtExprStmt.setType(statementExpressionVisitor.check(stmtExprStmt.statementExpression).getType());
        return stmtExprStmt;
    }

    @Override
    public While check(While while_) throws SyntaxException, TypeException {
        Expression expression = expressionVisitor.check(while_.condition);
        if (expression.getType().getName().equals("java.lang.Boolean")) {
            while_.setType(PrimitiveType.BOOLEAN);
            return while_;
        }

        throw new SyntaxException("While condition must be of type Boolean");
    }
}
