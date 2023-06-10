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
	 * Visit a parse tree produced by {@link MinijavaParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(MinijavaParser.VarContext ctx);
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
	 * Visit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MinijavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(MinijavaParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(MinijavaParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalVarDecl}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDecl(MinijavaParser.LocalVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(MinijavaParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtExprStmt}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtExprStmt(MinijavaParser.StmtExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Null}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(MinijavaParser.NullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Character}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter(MinijavaParser.CharacterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MinijavaParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOperation}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperation(MinijavaParser.BinaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstVar}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstVar(MinijavaParser.InstVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(MinijavaParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryOperationPost}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperationPost(MinijavaParser.UnaryOperationPostContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Super}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuper(MinijavaParser.SuperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MinijavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryOperationPre}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperationPre(MinijavaParser.UnaryOperationPreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtExprExpr}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtExprExpr(MinijavaParser.StmtExprExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code This}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThis(MinijavaParser.ThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Location}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(MinijavaParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MinijavaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code New}
	 * labeled alternative in {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(MinijavaParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(MinijavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#unaryOpPre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOpPre(MinijavaParser.UnaryOpPreContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#unaryOpPost}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOpPost(MinijavaParser.UnaryOpPostContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#binaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(MinijavaParser.BinaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(MinijavaParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MinijavaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(MinijavaParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(MinijavaParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinijavaParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(MinijavaParser.IdContext ctx);
}
