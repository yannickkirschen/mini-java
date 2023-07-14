package de.dhbw.compiler.ast;

import de.dhbw.compiler.ast.Type;
import de.dhbw.compiler.ast.statements.*;
import de.dhbw.compiler.ast.expressions.*;
import de.dhbw.compiler.ast.stmtexprs.*;
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

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(this.name.name());
        for(Field f : this.fields){
            builder.append("\n").append(f.astType.name()).append(" ").append(f.name);
        }
        for(Constructor c : this.constructors){
            builder.append("\n").append(this.name.name()).append("(");
            for(Parameter p : c.parameterList){
                builder.append(p.astType.name()).append("\s").append(p.name).append("\s");
            }
            builder.append(")");
            builder.append("\n");
            builder.append(printStatement(c.body));
        }
        for(Method m : this.methods){
            builder.append("\n").append(m.astType.name()).append("\s").append(m.name).append("(");
            for(Parameter p : m.parameters){
                builder.append(m.astType.name()).append("\s").append(p.name).append("\s");
            }
            builder.append(")");
            builder.append("\n");
            builder.append(printStatement(m.statement));
        }
        return builder.toString();
    }
      private String printStatement(Statement statement) {
        if(statement == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        if (statement.getClass().equals(Block.class)) {
            Block castedStatement = (Block) statement;
            builder.append("Block").append("(");
            for (Statement s : castedStatement.stmts) {
                builder.append(printStatement(s));
            }
            builder.append(")");
        } else if (statement.getClass().equals(If.class)) {
            If castedStatement = (If) statement;
            builder.append("If").append("(");
            builder.append("Expression: ");
            builder.append(printExpression(castedStatement.condition));
            builder.append("if body: ").append(printStatement(castedStatement.ifBody));
            builder.append("else body: ").append(printStatement(castedStatement.elseBody));
            builder.append(")");
        } else if (statement.getClass().equals(LocalVarDecl.class)) {
            LocalVarDecl castedStatement = (LocalVarDecl) statement;
            builder.append("LocalVarDecl").append(castedStatement.getPassedType().name()).append("(");
            builder.append("Name: ").append(castedStatement.name);
            builder.append(")");
        } else if (statement.getClass().equals(Return.class)) {
            Return castedStatement = (Return) statement;
            builder.append("Return").append("(");
            builder.append("Expression: ");
            builder.append(printExpression(castedStatement.expression));
            builder.append(")");
        } else if (statement.getClass().equals(StmtExprStmt.class)) {
            StmtExprStmt castedStatement = (StmtExprStmt) statement;
            builder.append("StmtExprStmt").append("(");
            builder.append("StatementExpression: ");
            builder.append(printStatementExpression(castedStatement.statementExpression));
            builder.append(")");
        } else if (statement.getClass().equals(While.class)) {
            While castedStatement = (While) statement;
            builder.append("While").append("(");
            builder.append("Expression: ");
            builder.append(printExpression(castedStatement.condition));
            builder.append("Statement: ").append(printStatement(castedStatement.statement));
            builder.append(")");
        }
        return builder.toString();
    }
    private String printExpression(Expression expr){
        if(expr == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        if(expr.getClass() == InstVar.class){
            InstVar castedExpression = (InstVar)expr;
            builder.append("InstVar:");
            builder.append(castedExpression.varName);
            builder.append("=");
            builder.append(printExpression(castedExpression.thisExpr));
        } else if(expr.getClass() == JBoolean.class){
            JBoolean castedExpression = (JBoolean)expr;
            builder.append("JBoolean:");
            builder.append(castedExpression.value);
        } else if(expr.getClass() == JCharacter.class){
            JCharacter castedExpression = (JCharacter)expr;
            builder.append("JCharacter:");
            builder.append(castedExpression.value);
        } else if(expr.getClass() == JInteger.class){
            JInteger castedExpression = (JInteger)expr;
            builder.append("JInteger:");
            builder.append(castedExpression.value);
        } else if(expr.getClass() == JNull.class){
            JNull castedExpression = (JNull)expr;
            builder.append("JNull:");
        } else if(expr.getClass() == JString.class){
            JString castedExpression = (JString)expr;
            builder.append("JString:");
            builder.append(castedExpression.value);
        } else if(expr.getClass() == LocalOrFieldVar.class){
            LocalOrFieldVar castedExpression = (LocalOrFieldVar)expr;
            builder.append("LocalOrFieldVar:");
            builder.append(castedExpression.name);
        } else if(expr.getClass() == StmtExprExpr.class){
            StmtExprExpr castedExpression = (StmtExprExpr)expr;
            builder.append("StmtExprExpr:");
            builder.append(printStatementExpression(castedExpression.statementExpression));
        } else if(expr.getClass() == Super.class){
            Super castedExpression = (Super)expr;
            builder.append("Super:");
        } else if(expr.getClass() == This.class){
            This castedExpression = (This)expr;
            builder.append("This:");
        } else if(expr.getClass() == Unary.class){
            Unary castedExpression = (Unary)expr;
            builder.append("Unary:");
            builder.append(printExpression(castedExpression.argument));
            builder.append(castedExpression.operator);
        } else if(expr.getClass() == Binary.class){
            Binary castedExpression = (Binary)expr;
            builder.append("Binary:");
            builder.append(printExpression(castedExpression.left));
            builder.append(castedExpression.operator);
            builder.append(printExpression(castedExpression.right));
        }
        return builder.toString();
    }
    private String printStatementExpression(StatementExpression stmtExpr){
        if(stmtExpr == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        if(stmtExpr.getClass() == Assign.class){
            Assign castedStmtExpression = (Assign)stmtExpr;
            builder.append("Assign:");
            builder.append(printExpression(castedStmtExpression.target));
            builder.append("=");
            builder.append(printExpression(castedStmtExpression.value));
        } else if(stmtExpr.getClass() == MethodCall.class) {
            MethodCall castedStmtExpression = (MethodCall) stmtExpr;
            builder.append("MethodCall:");
            builder.append(printExpression(castedStmtExpression.thisExpr));
            builder.append(castedStmtExpression.name);
            builder.append(":args:");
            for( Expression expr : castedStmtExpression.args) {
                builder.append(expr);
            }
        } else if(stmtExpr.getClass() == New.class) {
            New castedStmtExpression = (New)stmtExpr;
            builder.append("New: Type:").append(castedStmtExpression.getPassedType());
            for(Expression expr : castedStmtExpression.expressions) {
                builder.append(printExpression(expr));
            }
        }
        return builder.toString();
    }
}
