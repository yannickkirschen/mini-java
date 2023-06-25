// Generated from /Users/malterichert/IdeaProjects/mini-java/src/main/java/de/dhbw/compiler/parser/Minijava.g4 by ANTLR 4.12.0
package de.dhbw.compiler.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MinijavaParser}.
 */
public interface MinijavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MinijavaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MinijavaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(MinijavaParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(MinijavaParser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MinijavaParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MinijavaParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MinijavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MinijavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#refType}.
	 * @param ctx the parse tree
	 */
	void enterRefType(MinijavaParser.RefTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#refType}.
	 * @param ctx the parse tree
	 */
	void exitRefType(MinijavaParser.RefTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#meth}.
	 * @param ctx the parse tree
	 */
	void enterMeth(MinijavaParser.MethContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#meth}.
	 * @param ctx the parse tree
	 */
	void exitMeth(MinijavaParser.MethContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(MinijavaParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(MinijavaParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(MinijavaParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(MinijavaParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(MinijavaParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(MinijavaParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MinijavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MinijavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(MinijavaParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(MinijavaParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(MinijavaParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(MinijavaParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#localVarDeclAssign}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDeclAssign(MinijavaParser.LocalVarDeclAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#localVarDeclAssign}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDeclAssign(MinijavaParser.LocalVarDeclAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(MinijavaParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(MinijavaParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(MinijavaParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(MinijavaParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#instVar}.
	 * @param ctx the parse tree
	 */
	void enterInstVar(MinijavaParser.InstVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#instVar}.
	 * @param ctx the parse tree
	 */
	void exitInstVar(MinijavaParser.InstVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#localOrFieldVar}.
	 * @param ctx the parse tree
	 */
	void enterLocalOrFieldVar(MinijavaParser.LocalOrFieldVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#localOrFieldVar}.
	 * @param ctx the parse tree
	 */
	void exitLocalOrFieldVar(MinijavaParser.LocalOrFieldVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#unaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperation(MinijavaParser.UnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#unaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperation(MinijavaParser.UnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MinijavaParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MinijavaParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#char}.
	 * @param ctx the parse tree
	 */
	void enterChar(MinijavaParser.CharContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#char}.
	 * @param ctx the parse tree
	 */
	void exitChar(MinijavaParser.CharContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(MinijavaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(MinijavaParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MinijavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MinijavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(MinijavaParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(MinijavaParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#arithmeticBinOp}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticBinOp(MinijavaParser.ArithmeticBinOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#arithmeticBinOp}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticBinOp(MinijavaParser.ArithmeticBinOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void enterMulOp(MinijavaParser.MulOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void exitMulOp(MinijavaParser.MulOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#mulSubOp}.
	 * @param ctx the parse tree
	 */
	void enterMulSubOp(MinijavaParser.MulSubOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#mulSubOp}.
	 * @param ctx the parse tree
	 */
	void exitMulSubOp(MinijavaParser.MulSubOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#logicalBinOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalBinOp(MinijavaParser.LogicalBinOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#logicalBinOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalBinOp(MinijavaParser.LogicalBinOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MinijavaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MinijavaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#subExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpression(MinijavaParser.SubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#subExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpression(MinijavaParser.SubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#unaryAssign}.
	 * @param ctx the parse tree
	 */
	void enterUnaryAssign(MinijavaParser.UnaryAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#unaryAssign}.
	 * @param ctx the parse tree
	 */
	void exitUnaryAssign(MinijavaParser.UnaryAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#new}.
	 * @param ctx the parse tree
	 */
	void enterNew(MinijavaParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#new}.
	 * @param ctx the parse tree
	 */
	void exitNew(MinijavaParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(MinijavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(MinijavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MinijavaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MinijavaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#assignable}.
	 * @param ctx the parse tree
	 */
	void enterAssignable(MinijavaParser.AssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#assignable}.
	 * @param ctx the parse tree
	 */
	void exitAssignable(MinijavaParser.AssignableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtExpr(MinijavaParser.StmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtExpr(MinijavaParser.StmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#unaryAssOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryAssOp(MinijavaParser.UnaryAssOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#unaryAssOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryAssOp(MinijavaParser.UnaryAssOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(MinijavaParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(MinijavaParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#binMulOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinMulOperator(MinijavaParser.BinMulOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#binMulOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinMulOperator(MinijavaParser.BinMulOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#binAddOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinAddOperator(MinijavaParser.BinAddOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#binAddOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinAddOperator(MinijavaParser.BinAddOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#binLogicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinLogicalOperator(MinijavaParser.BinLogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#binLogicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinLogicalOperator(MinijavaParser.BinLogicalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(MinijavaParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(MinijavaParser.ArgsContext ctx);
}