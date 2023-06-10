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
	 * Enter a parse tree produced by {@link MinijavaParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(MinijavaParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(MinijavaParser.VarContext ctx);
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
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(MinijavaParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(MinijavaParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Return}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn(MinijavaParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn(MinijavaParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile(MinijavaParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile(MinijavaParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalVarDecl}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDecl(MinijavaParser.LocalVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalVarDecl}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDecl(MinijavaParser.LocalVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code If}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf(MinijavaParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code If}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf(MinijavaParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtExprStmt}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtExprStmt(MinijavaParser.StmtExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtExprStmt}
	 * labeled alternative in {@link MinijavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtExprStmt(MinijavaParser.StmtExprStmtContext ctx);
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
	 * Enter a parse tree produced by the {@code LocationExpr}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLocationExpr(MinijavaParser.LocationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocationExpr}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLocationExpr(MinijavaParser.LocationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Null}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNull(MinijavaParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Null}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNull(MinijavaParser.NullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Character}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCharacter(MinijavaParser.CharacterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Character}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCharacter(MinijavaParser.CharacterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MinijavaParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MinijavaParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOperation}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(MinijavaParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOperation}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(MinijavaParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstVar}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInstVar(MinijavaParser.InstVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstVar}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInstVar(MinijavaParser.InstVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(MinijavaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(MinijavaParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryOperationPost}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperationPost(MinijavaParser.UnaryOperationPostContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryOperationPost}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperationPost(MinijavaParser.UnaryOperationPostContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Super}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSuper(MinijavaParser.SuperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Super}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSuper(MinijavaParser.SuperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MinijavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MinijavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryOperationPre}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperationPre(MinijavaParser.UnaryOperationPreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryOperationPre}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperationPre(MinijavaParser.UnaryOperationPreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtExprExpr}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStmtExprExpr(MinijavaParser.StmtExprExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtExprExpr}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStmtExprExpr(MinijavaParser.StmtExprExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code This}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterThis(MinijavaParser.ThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code This}
	 * labeled alternative in {@link MinijavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitThis(MinijavaParser.ThisContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(MinijavaParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(MinijavaParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MinijavaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MinijavaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code New}
	 * labeled alternative in {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterNew(MinijavaParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code New}
	 * labeled alternative in {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitNew(MinijavaParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(MinijavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link MinijavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(MinijavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#unaryOpPre}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOpPre(MinijavaParser.UnaryOpPreContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#unaryOpPre}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOpPre(MinijavaParser.UnaryOpPreContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#unaryOpPost}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOpPost(MinijavaParser.UnaryOpPostContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#unaryOpPost}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOpPost(MinijavaParser.UnaryOpPostContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(MinijavaParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(MinijavaParser.BinaryOpContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MinijavaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MinijavaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(MinijavaParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(MinijavaParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(MinijavaParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(MinijavaParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinijavaParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(MinijavaParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinijavaParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(MinijavaParser.IdContext ctx);
}