package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.Field;
import de.dhbw.compiler.ast.Method;
import de.dhbw.compiler.ast.expressions.Expression;
import de.dhbw.compiler.ast.expressions.InstVar;
import de.dhbw.compiler.ast.expressions.LocalOrFieldVar;
import de.dhbw.compiler.ast.stmtexprs.Assign;
import de.dhbw.compiler.ast.stmtexprs.MethodCall;
import de.dhbw.compiler.ast.stmtexprs.New;
import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import de.dhbw.compiler.ast.ObjectType;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class StatementExpressionChecker implements BaseStatementExpressionChecker {
    private final String className;
    private final List<Field> fields;
    private final List<Method> methods;
    private final List<LocalOrFieldVar> localVariables;

    @Setter
    private BaseClassChecker baseClassChecker;

    @Setter
    private BaseExpressionChecker expressionChecker;

    @Override
    public StatementExpression check(StatementExpression statementExpression) throws SyntaxException, TypeException {
        Class<?> clazz = statementExpression.getClass();

        if (clazz.equals(Assign.class)) {
            return check((Assign) statementExpression);
        } else if (clazz.equals(MethodCall.class)) {
            return check((MethodCall) statementExpression);
        } else if (clazz.equals(New.class)) {
            return check((New) statementExpression);
        }

        throw new SyntaxException("Unexpected statement expression: %s", statementExpression);
    }

    @Override
    public Assign check(Assign assign) throws SyntaxException, TypeException {
        Expression targetExpression = expressionChecker.check(assign.target);
        Expression valueExpression = expressionChecker.check(assign.value);

        String name;
        if (targetExpression.getClass().equals(LocalOrFieldVar.class)) {
            name = ((LocalOrFieldVar) targetExpression).name;
        } else if (targetExpression.getClass().equals(InstVar.class)) {
            name = ((InstVar) targetExpression).varName;
        } else {
            throw new SyntaxException("Unexpected target expression: %s", targetExpression);
        }

        for (LocalOrFieldVar localVar : localVariables) {
            if (localVar.name.equals(name)) {
                if (localVar.getType().equals(valueExpression.getType())) {
                    assign.setType(localVar.getType());
                    return assign;
                } else {
                    throw new TypeException("Type mismatch: %s and %s for variable %s", localVar.getType(), valueExpression.getType(), localVar.name);
                }
            }
        }

        for (Field field : fields) {
            if (field.name.equals(name)) {
                if (field.getType().equals(valueExpression.getType())) {
                    assign.setType(field.getType());
                    return assign;
                } else {
                    throw new TypeException("Type mismatch: %s and %s for field %s", field.getType(), valueExpression.getType(), field.name);
                }
            }
        }

        throw new SyntaxException("Variable or field %s not found in type %s", name, className);
    }

    @Override
    public MethodCall check(MethodCall methodCall) throws SyntaxException, TypeException {
        Expression receiver = expressionChecker.check(methodCall.thisExpr);

        if (receiver.getType().getName().equals(className)) {
            for (Method method : methods) {
                if (method.name.equals(methodCall.name)) {
                    if (method.parameters.size() == methodCall.args.size()) {
                        for (int i = 0; i < method.parameters.size(); i++) {
                            Expression argument = expressionChecker.check(methodCall.args.get(i));

                            if (!method.parameters.get(i).getType().getName().equals(argument.getType().getName())) {
                                throw new TypeException("Type mismatch: %s and %s for argument %d in method %s", method.parameters.get(i).getType().getName(), argument.getType().getName(), i, method.name);
                            }
                        }

                        methodCall.setType(method.getType());
                        return methodCall;
                    } else {
                        throw new SyntaxException("Wrong number of arguments for method %s", method.name);
                    }
                }
            }

            Method method = baseClassChecker.check(methodCall.name);
            methods.add(method);
            return check(methodCall);
        }

        throw new SyntaxException("Cannot resolve method %s in type %s", methodCall.name, className);
    }

    @Override
    public New check(New new_) throws SyntaxException, TypeException {
        if (new_.getPassedType().name().equals(className)) {
            List<Expression> expressions = new ArrayList<>(new_.expressions.size());
            for (Expression expression : new_.expressions) {
                expressions.add(expressionChecker.check(expression));
            }

            for (Method method : methods) {
                if (method.name.equals("<init>")) {
                    if (method.parameters.size() == new_.expressions.size()) {
                        for (int i = 0; i < method.parameters.size(); i++) {
                            if (!method.parameters.get(i).getType().getName().equals(expressions.get(i).getType().getName())) {
                                throw new TypeException("Type mismatch: %s and %s for argument %d in constructor", method.parameters.get(i).getType().getName(), expressions.get(i).getType().getName(), i);
                            }
                        }

                        new_.setType(new ObjectType(className));
                        return new_;
                    } else {
                        // This would be the location to add overloading.
                        throw new SyntaxException("Wrong number of arguments for constructor");
                    }
                }
            }

            Method method = baseClassChecker.check("<init>");
            methods.add(method);
            return check(new_);
        }

        throw new SyntaxException("Cannot resolve type %s", new_.getPassedType().name());
    }
}
