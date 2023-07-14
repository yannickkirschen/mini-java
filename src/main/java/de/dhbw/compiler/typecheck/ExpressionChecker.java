package de.dhbw.compiler.typecheck;

import de.dhbw.compiler.ast.Field;
import de.dhbw.compiler.ast.ObjectType;
import de.dhbw.compiler.ast.PrimitiveType;
import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.ast.stmtexprs.StatementExpression;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ExpressionChecker implements BaseExpressionChecker {
    private final String className;
    private final List<Field> fields;
    private final List<LocalOrFieldVar> localVariables;

    private final BaseStatementExpressionChecker statementExpressionChecker;

    @Override
    public Expression check(Expression expression) throws SyntaxException, TypeException {
        Class<?> clazz = expression.getClass();

        if (clazz.equals(Binary.class)) {
            return check((Binary) expression);
        } else if (clazz.equals(InstVar.class)) {
            return check((InstVar) expression);
        } else if (clazz.equals(JBoolean.class)) {
            return check((JBoolean) expression);
        } else if (clazz.equals(JCharacter.class)) {
            return check((JCharacter) expression);
        } else if (clazz.equals(JInteger.class)) {
            return check((JInteger) expression);
        } else if (clazz.equals(JNull.class)) {
            return check((JNull) expression);
        } else if (clazz.equals(JString.class)) {
            return check((JString) expression);
        } else if (clazz.equals(LocalOrFieldVar.class)) {
            return check((LocalOrFieldVar) expression);
        } else if (clazz.equals(StmtExprExpr.class)) {
            return check((StmtExprExpr) expression);
        } else if (clazz.equals(Super.class)) {
            return check((Super) expression);
        } else if (clazz.equals(This.class)) {
            return check((This) expression);
        } else if (clazz.equals(Unary.class)) {
            return check((Unary) expression);
        }

        throw new SyntaxException("Unexpected expression: %s", expression);
    }

    @Override
    public Binary check(Binary binary) throws SyntaxException, TypeException {
        Expression left = this.check(binary.left);
        Expression right = this.check(binary.right);

        if (left.getType().equals(right.getType())) {
            if (left.getType().getName().equals("")) {
                if (binary.operator.equals("+")
                    || binary.operator.equals("-")
                    || binary.operator.equals("*")
                    || binary.operator.equals("%")) {
                    binary.setType(PrimitiveType.INTEGER);
                    return binary;
                } else {
                    throw new SyntaxException("Unexpected operator: %s. Expected +, -, * or %.", binary.operator);
                }
            } else if (left.getType() == PrimitiveType.BOOLEAN) {
                if (binary.operator.equals("&&")
                    || binary.operator.equals("||")) {
                    binary.setType(PrimitiveType.BOOLEAN);
                    return binary;
                } else {
                    throw new SyntaxException("Unexpected operator: %s. Expected && or ||.", binary.operator);
                }
            }
        }

        throw new TypeException("Incompatible types in binary expression: %s and %s", left.getType(), right.getType());
    }

    @Override
    public InstVar check(InstVar instVar) throws SyntaxException, TypeException {
        Expression expression = this.check(instVar.thisExpr);

        if (expression.getType().getName().equals(className)) {
            for (Field field : fields) {
                if (field.name.equals(instVar.varName)) {
                    instVar.setType(expression.getType());
                    return instVar;
                }
            }

            throw new SyntaxException("Unknown field: %s", instVar.varName);
        } else {
            throw new TypeException("Unexpected type: %s. Expected %s.", expression.getType(), className);
        }
    }

    @Override
    public JBoolean check(JBoolean jBoolean) throws SyntaxException {
        if (jBoolean.value.equals("true") || jBoolean.value.equals("false")) {
            jBoolean.setType(PrimitiveType.BOOLEAN);
            return jBoolean;
        }

        throw new SyntaxException("Unexpected value: %s. Expected true or false.", jBoolean.value);
    }

    @Override
    public JCharacter check(JCharacter jChar) throws SyntaxException {
        if (jChar.value.length() == 1) {
            jChar.setType(PrimitiveType.CHARACTER);
            return jChar;
        }

        throw new SyntaxException("Unexpected value: %s. Expected single character.", jChar.value);
    }

    @Override
    public JInteger check(JInteger jInt) throws SyntaxException {
        try {
            Integer.parseInt(jInt.value);
            jInt.setType(PrimitiveType.INTEGER);
            return jInt;
        } catch (NumberFormatException e) {
            throw new SyntaxException("Unexpected value: %s. Expected integer.", jInt.value);
        }
    }

    @Override
    public JNull check(JNull jnull) {
        jnull.setType(ObjectType.jNull());
        return jnull;
    }

    @Override
    public JString check(JString jString) {
        jString.setType(ObjectType.string());
        return jString;
    }

    @Override
    public LocalOrFieldVar check(LocalOrFieldVar localOrFieldVar) throws SyntaxException {
        for (LocalOrFieldVar localVar : this.localVariables) {
            if (localVar.name.equals(localOrFieldVar.name)) {
                localOrFieldVar.setType(localVar.getType());
                return localOrFieldVar;
            }
        }

        for (Field field : this.fields) {
            if (field.name.equals(localOrFieldVar.name)) {
                localOrFieldVar.setType(field.getType());
                return localOrFieldVar;
            }
        }

        throw new SyntaxException("Cannot resolve symbol: %s", localOrFieldVar.name);
    }

    @Override
    public StmtExprExpr check(StmtExprExpr stmtExprExpr) throws SyntaxException, TypeException {
        StatementExpression typedStmtExprExpr = statementExpressionChecker.check(stmtExprExpr.statementExpression);

        stmtExprExpr.setType(typedStmtExprExpr.getType());
        return stmtExprExpr;
    }

    @Override
    public Super check(Super super_) {
        super_.setType(new ObjectType(className));
        return super_;
    }

    @Override
    public This check(This this_) {
        this_.setType(new ObjectType(className));
        return this_;
    }

    @Override
    public Unary check(Unary unary) throws SyntaxException, TypeException {
        Expression expression = this.check(unary.argument);
        if (expression.getType() == PrimitiveType.INTEGER) {
            if (unary.operator.equals("+") || unary.operator.equals("-")) {
                unary.setType(PrimitiveType.INTEGER);
                return unary;
            } else {
                throw new SyntaxException("Unexpected operator: %s. Expected + or -.", unary.operator);
            }
        } else if (expression.getType() == PrimitiveType.BOOLEAN) {
            if (unary.operator.equals("!")) {
                unary.setType(PrimitiveType.BOOLEAN);
                return unary;
            } else {
                throw new SyntaxException("Unexpected operator: %s. Expected !.", unary.operator);
            }
        }

        throw new TypeException("Unexpected type: %s", unary.argument.getClass().getSimpleName());
    }
}
