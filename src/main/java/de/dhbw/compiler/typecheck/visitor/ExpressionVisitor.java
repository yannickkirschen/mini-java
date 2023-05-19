package de.dhbw.compiler.typecheck.visitor;

import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.typecheck.*;
import de.dhbw.compiler.typecheck.model.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ExpressionVisitor implements BaseExpressionVisitor {
    private final String className;
    private final List<TypedField> fields;
    private final List<TypedLocalVar> localVariables;

    private final BaseStatementExpressionVisitor statementExpressionVisitor;

    @Override
    public TypedExpression<? extends Expression> visit(Expression expression) throws SyntaxException, TypeException {
        Class<?> clazz = expression.getClass();

        if (clazz.equals(Binary.class)) {
            return visit((Binary) expression);
        } else if (clazz.equals(InstVar.class)) {
            return visit((InstVar) expression);
        } else if (clazz.equals(JBoolean.class)) {
            return visit((JBoolean) expression);
        } else if (clazz.equals(JCharacter.class)) {
            return visit((JCharacter) expression);
        } else if (clazz.equals(JInteger.class)) {
            return visit((JInteger) expression);
        } else if (clazz.equals(JNull.class)) {
            return visit((JNull) expression);
        } else if (clazz.equals(JString.class)) {
            return visit((JString) expression);
        } else if (clazz.equals(LocalOrFieldVar.class)) {
            return visit((LocalOrFieldVar) expression);
        } else if (clazz.equals(StmtExprExpr.class)) {
            return visit((StmtExprExpr) expression);
        } else if (clazz.equals(Super.class)) {
            return visit((Super) expression);
        } else if (clazz.equals(This.class)) {
            return visit((This) expression);
        } else if (clazz.equals(Unary.class)) {
            return visit((Unary) expression);
        }

        throw new SyntaxException("Unexpected expression: %s", expression);
    }

    @Override
    public TypedExpression<Binary> visit(Binary binary) throws SyntaxException, TypeException {
        TypedExpression<? extends Expression> left = this.visit(binary.left());
        TypedExpression<? extends Expression> right = this.visit(binary.right());

        if (left.type().equals(right.type())) {
            if (left.type().name().equals("java.lang.Integer")) {
                if (binary.operator().equals("+")
                    || binary.operator().equals("-")
                    || binary.operator().equals("*")
                    || binary.operator().equals("%")) {
                    return new TypedExpression<>(left.type(), binary);
                } else {
                    throw new SyntaxException("Unexpected operator: %s. Expected +, -, * or %.", binary.operator());
                }
            } else if (left.type().name().equals("java.lang.Boolean")) {
                if (binary.operator().equals("&&")
                    || binary.operator().equals("||")) {
                    return new TypedExpression<>(left.type(), binary);
                } else {
                    throw new SyntaxException("Unexpected operator: %s. Expected && or ||.", binary.operator());
                }
            }
        }

        throw new TypeException("Incompatible types in binary expression: %s and %s", left.type(), right.type());
    }

    @Override
    public TypedExpression<InstVar> visit(InstVar instVar) throws SyntaxException, TypeException {
        TypedExpression<? extends Expression> expression = this.visit(instVar.thisExpr());

        if (expression.type().name().equals(className)) {
            for (TypedField field : fields) {
                if (field.name().equals(instVar.varName())) {
                    return new TypedExpression<>(field.type(), instVar);
                }
            }

            throw new SyntaxException("Unknown field: %s", instVar.varName());
        } else {
            throw new TypeException("Unexpected type: %s. Expected %s.", expression.type(), className);
        }
    }

    @Override
    public TypedExpression<JBoolean> visit(JBoolean jBoolean) throws SyntaxException {
        if (jBoolean.value().equals("true") || jBoolean.value().equals("false")) {
            return new TypedExpression<>(new TypedType("java.lang.Boolean"), jBoolean);
        }

        throw new SyntaxException("Unexpected value: %s. Expected true or false.", jBoolean.value());
    }

    @Override
    public TypedExpression<JCharacter> visit(JCharacter jChar) throws SyntaxException {
        if (jChar.value().length() == 1) {
            return new TypedExpression<>(new TypedType("java.lang.Character"), jChar);
        }

        throw new SyntaxException("Unexpected value: %s. Expected single character.", jChar.value());
    }

    @Override
    public TypedExpression<JInteger> visit(JInteger jInt) throws SyntaxException {
        try {
            Integer.parseInt(jInt.value());
            return new TypedExpression<>(new TypedType("java.lang.Integer"), jInt);
        } catch (NumberFormatException e) {
            throw new SyntaxException("Unexpected value: %s. Expected integer.", jInt.value());
        }
    }

    @Override
    public TypedExpression<JNull> visit(JNull jnull) {
        return new TypedExpression<>(new TypedType("null"), jnull);
    }

    @Override
    public TypedExpression<JString> visit(JString jString) {
        return new TypedExpression<>(new TypedType("java.lang.String"), jString);
    }

    @Override
    public TypedExpression<LocalOrFieldVar> visit(LocalOrFieldVar localOrFieldVar) throws SyntaxException {
        for (TypedLocalVar localVar : this.localVariables) {
            if (localVar.name().equals(localOrFieldVar.name())) {
                return new TypedExpression<>(localVar.type(), localOrFieldVar);
            }
        }

        for (TypedField field : this.fields) {
            if (field.name().equals(localOrFieldVar.name())) {
                return new TypedExpression<>(field.type(), localOrFieldVar);
            }
        }

        throw new SyntaxException("Cannot resolve symbol: %s", localOrFieldVar.name());
    }

    @Override
    public TypedExpression<StmtExprExpr> visit(StmtExprExpr stmtExprExpr) throws SyntaxException, TypeException {
        TypedStatementExpression typedStmtExprExpr = statementExpressionVisitor.visit(stmtExprExpr.statementExpression());
        return new TypedExpression<>(typedStmtExprExpr.type(), stmtExprExpr);
    }

    @Override
    public TypedExpression<Super> visit(Super super_) {
        return new TypedExpression<>(new TypedType(className), super_);
    }

    @Override
    public TypedExpression<This> visit(This this_) {
        return new TypedExpression<>(new TypedType(className), this_);
    }

    @Override
    public TypedExpression<Unary> visit(Unary unary) throws SyntaxException, TypeException {
        TypedExpression<? extends Expression> expression = this.visit(unary.argument());
        if (expression.type().name().equals("java.lang.Integer")) {
            if (unary.operator().equals("+") || unary.operator().equals("-")) {
                return new TypedExpression<>(new TypedType("java.lang.Integer"), unary);
            } else {
                throw new SyntaxException("Unexpected operator: %s. Expected + or -.", unary.operator());
            }
        } else if (expression.type().name().equals("java.lang.Boolean")) {
            if (unary.operator().equals("!")) {
                return new TypedExpression<>(new TypedType("java.lang.Boolean"), unary);
            } else {
                throw new SyntaxException("Unexpected operator: %s. Expected !.", unary.operator());
            }
        }

        throw new TypeException("Unexpected type: %s", unary.argument().getClass().getSimpleName());
    }
}
