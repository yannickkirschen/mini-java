// Generated from /Users/malterichert/IdeaProjects/mini-java/src/main/java/de/dhbw/compiler/parser/Minijava.g4 by ANTLR 4.12.0
package de.dhbw.compiler.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MinijavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MinijavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MinijavaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass(MinijavaParser.ClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MinijavaParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MinijavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#refType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefType(MinijavaParser.RefTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#meth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeth(MinijavaParser.MethContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(MinijavaParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(MinijavaParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(MinijavaParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MinijavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(MinijavaParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(MinijavaParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#localVarDeclAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDeclAssign(MinijavaParser.LocalVarDeclAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(MinijavaParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(MinijavaParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#instVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstVar(MinijavaParser.InstVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#localOrFieldVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalOrFieldVar(MinijavaParser.LocalOrFieldVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#unaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperation(MinijavaParser.UnaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MinijavaParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#char}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar(MinijavaParser.CharContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(MinijavaParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MinijavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#binaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperation(MinijavaParser.BinaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#arithmeticBinOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticBinOp(MinijavaParser.ArithmeticBinOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#mulOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOp(MinijavaParser.MulOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#mulSubOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulSubOp(MinijavaParser.MulSubOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#logicalBinOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalBinOp(MinijavaParser.LogicalBinOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MinijavaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#subExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpression(MinijavaParser.SubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#unaryAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryAssign(MinijavaParser.UnaryAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#new}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(MinijavaParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(MinijavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MinijavaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#assignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignable(MinijavaParser.AssignableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtExpr(MinijavaParser.StmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#unaryAssOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryAssOp(MinijavaParser.UnaryAssOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(MinijavaParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#binMulOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinMulOperator(MinijavaParser.BinMulOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#binAddOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinAddOperator(MinijavaParser.BinAddOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#binLogicalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinLogicalOperator(MinijavaParser.BinLogicalOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(MinijavaParser.ArgsContext ctx);
}