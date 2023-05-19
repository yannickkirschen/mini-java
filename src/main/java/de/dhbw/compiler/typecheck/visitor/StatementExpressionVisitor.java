package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.ast.stmtexprs.*;
import de.dhbw.compiler.typecheck.*;
import de.dhbw.compiler.typecheck.model.*;
import lombok.*;

import java.util.*;

@RequiredArgsConstructor
public class StatementExpressionVisitor implements BaseStatementExpressionVisitor {
    private final String className;
    private final List<TypedField> fields;
    private final List<TypedMethod<? extends Statement>> methods;
    private final List<TypedLocalVar> localVariables;

    @Setter
    private BaseClassVisitor baseClassVisitor;

    @Setter
    private BaseExpressionVisitor expressionVisitor;

    @Override
    public TypedStatementExpression visit(StatementExpression statementExpression) throws SyntaxException, TypeException {
        Class<?> clazz = statementExpression.getClass();

        if (clazz.equals(Assign.class)) {
            return visit((Assign) statementExpression);
        } else if (clazz.equals(MethodCall.class)) {
            return visit((MethodCall) statementExpression);
        } else if (clazz.equals(New.class)) {
            return visit((New) statementExpression);
        }

        throw new SyntaxException("Unexpected statement expression: %s", statementExpression);
    }

    @Override
    public TypedStatementExpression visit(Assign assign) throws SyntaxException, TypeException {
        TypedExpression<? extends Expression> expression = expressionVisitor.visit(assign.value());

        for (TypedLocalVar localVar : localVariables) {
            if (localVar.name().equals(assign.var())) {
                if (localVar.type().equals(expression.type())) {
                    return new TypedStatementExpression(localVar.type(), assign);
                } else {
                    throw new TypeException("Type mismatch: %s and %s for variable %s", localVar.type(), expression.type(), localVar.name());
                }
            }
        }

        for (TypedField field : fields) {
            if (field.name().equals(assign.var())) {
                if (field.type().equals(expression.type())) {
                    return new TypedStatementExpression(field.type(), assign);
                } else {
                    throw new TypeException("Type mismatch: %s and %s for field %s", field.type(), expression.type(), field.name());
                }
            }
        }

        throw new SyntaxException("Variable or field %s not found in type %s", assign.var(), className);
    }

    @Override
    public TypedStatementExpression visit(MethodCall methodCall) throws SyntaxException, TypeException {
        TypedExpression<? extends Expression> receiver = expressionVisitor.visit(methodCall.thisExpr());

        if (receiver.type().name().equals(className)) {
            for (TypedMethod<? extends Statement> method : methods) {
                if (method.name().equals(methodCall.name())) {
                    if (method.typedParameters().size() == methodCall.args().size()) {
                        for (int i = 0; i < method.typedParameters().size(); i++) {
                            TypedExpression<? extends Expression> argument = expressionVisitor.visit(methodCall.args().get(i));

                            if (!method.typedParameters().get(i).typedType().name().equals(argument.type().name())) {
                                throw new TypeException("Type mismatch: %s and %s for argument %d in method %s", method.typedParameters().get(i).typedType(), argument.type(), i, method.name());
                            }
                        }

                        return new TypedStatementExpression(method.returnTypedType(), methodCall);
                    } else {
                        throw new SyntaxException("Wrong number of arguments for method %s", method.name());
                    }
                }
            }

            TypedMethod<? extends Statement> method = baseClassVisitor.visit(methodCall.name());
            methods.add(method);
            return visit(methodCall);
        }

        throw new SyntaxException("Cannot resolve method %s in type %s", methodCall.name(), className);
    }

    @Override
    public TypedStatementExpression visit(New new_) throws SyntaxException, TypeException {
        if (new_.type().name().equals(className)) {
            List<TypedExpression<? extends Expression>> expressions = new ArrayList<>(new_.expressions().size());
            for (Expression expression : new_.expressions()) {
                expressions.add(expressionVisitor.visit(expression));
            }

            for (TypedMethod<? extends Statement> method : methods) {
                if (method.name().equals("<init>")) {
                    if (method.typedParameters().size() == new_.expressions().size()) {
                        for (int i = 0; i < method.typedParameters().size(); i++) {
                            if (!method.typedParameters().get(i).typedType().name().equals(expressions.get(i).type().name())) {
                                throw new TypeException("Type mismatch: %s and %s for argument %d in constructor", method.typedParameters().get(i).typedType(), expressions.get(i).type(), i);
                            }
                        }

                        return new TypedStatementExpression(new TypedType(className), new_);
                    } else {
                        // This would be the location to add overloading.
                        throw new SyntaxException("Wrong number of arguments for constructor");
                    }
                }
            }

            TypedMethod<? extends Statement> method = baseClassVisitor.visit("<init>");
            methods.add(method);
            return visit(new_);
        }

        throw new SyntaxException("Cannot resolve type %s", new_.type().name());
    }
}
