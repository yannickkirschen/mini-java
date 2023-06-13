// Generated from /Users/malterichert/IdeaProjects/mini-java/src/main/java/de/dhbw/compiler/parser/Minijava.g4 by ANTLR 4.12.0
package de.dhbw.compiler.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MinijavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9,
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17,
		T__17=18, T__18=19, T__19=20, T__20=21, INCR=22, DECR=23, NOT=24, PLUS=25,
		MINUS=26, MUL=27, DIV=28, INT=29, BOOL=30, CHAR=31, STRING=32, VOID=33,
		IDENTIFIER=34, Number=35, CHARACTER=36, WS=37;
	public static final int
		RULE_program = 0, RULE_class = 1, RULE_var = 2, RULE_type = 3, RULE_refType = 4,
		RULE_meth = 5, RULE_params = 6, RULE_param = 7, RULE_const = 8, RULE_stmt = 9,
		RULE_block = 10, RULE_expr = 11, RULE_location = 12, RULE_stmtExpr = 13,
		RULE_unaryAssOp = 14, RULE_unaryOp = 15, RULE_binaryOp = 16, RULE_args = 17,
		RULE_literal = 18, RULE_boolean = 19, RULE_number = 20, RULE_id = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "class", "var", "type", "refType", "meth", "params", "param",
			"const", "stmt", "block", "expr", "location", "stmtExpr", "unaryAssOp",
			"unaryOp", "binaryOp", "args", "literal", "boolean", "number", "id"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'{'", "'}'", "';'", "'('", "')'", "','", "'return'",
			"'while'", "'if'", "'else'", "'this'", "'super'", "'.'", "'''", "'\"'",
			"'null'", "'='", "'new'", "'true'", "'false'", "'++'", "'--'", "'!'",
			"'+'", "'-'", "'*'", "'/'", "'int'", "'boolean'", "'char'", "'String'",
			"'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, "INCR", "DECR",
			"NOT", "PLUS", "MINUS", "MUL", "DIV", "INT", "BOOL", "CHAR", "STRING",
			"VOID", "IDENTIFIER", "Number", "CHARACTER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Minijava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MinijavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(44);
				class_();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<MethContext> meth() {
			return getRuleContexts(MethContext.class);
		}
		public MethContext meth(int i) {
			return getRuleContext(MethContext.class,i);
		}
		public List<ConstContext> const_() {
			return getRuleContexts(ConstContext.class);
		}
		public ConstContext const_(int i) {
			return getRuleContext(ConstContext.class,i);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			type();
			setState(52);
			match(T__1);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33822867456L) != 0)) {
				{
				setState(56);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(53);
					var();
					}
					break;
				case 2:
					{
					setState(54);
					meth();
					}
					break;
				case 3:
					{
					setState(55);
					const_();
					}
					break;
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			type();
			setState(64);
			id();
			setState(65);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MinijavaParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(MinijavaParser.BOOL, 0); }
		public TerminalNode CHAR() { return getToken(MinijavaParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(MinijavaParser.STRING, 0); }
		public TerminalNode VOID() { return getToken(MinijavaParser.VOID, 0); }
		public RefTypeContext refType() {
			return getRuleContext(RefTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(INT);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(BOOL);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				match(CHAR);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				match(STRING);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				match(VOID);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
				refType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RefTypeContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public RefTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterRefType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitRefType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitRefType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefTypeContext refType() throws RecognitionException {
		RefTypeContext _localctx = new RefTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_refType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public MethContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meth; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterMeth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitMeth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitMeth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethContext meth() throws RecognitionException {
		MethContext _localctx = new MethContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_meth);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			type();
			setState(78);
			id();
			setState(79);
			match(T__4);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33822867456L) != 0)) {
				{
				setState(80);
				params();
				}
			}

			setState(83);
			match(T__5);
			setState(84);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			param();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(87);
				match(T__6);
				setState(88);
				param();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			type();
			setState(95);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstContext extends ParserRuleContext {
		public RefTypeContext refType() {
			return getRuleContext(RefTypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstContext const_() throws RecognitionException {
		ConstContext _localctx = new ConstContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_const);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			refType();
			setState(98);
			match(T__4);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33822867456L) != 0)) {
				{
				setState(99);
				params();
				}
			}

			setState(102);
			match(T__5);
			setState(103);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }

		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends StmtContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalVarDeclContext extends StmtContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public LocalVarDeclContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterLocalVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitLocalVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitLocalVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtExprStmtContext extends StmtContext {
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public StmtExprStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterStmtExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitStmtExprStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitStmtExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stmt);
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				block();
				}
				break;
			case 2:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(T__7);
				setState(107);
				expr(0);
				setState(108);
				match(T__3);
				}
				break;
			case 3:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				match(T__8);
				setState(111);
				match(T__4);
				setState(112);
				expr(0);
				setState(113);
				match(T__5);
				setState(114);
				stmt();
				}
				break;
			case 4:
				_localctx = new LocalVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(116);
				var();
				}
				break;
			case 5:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(117);
				match(T__9);
				setState(118);
				match(T__4);
				setState(119);
				expr(0);
				setState(120);
				match(T__5);
				setState(121);
				stmt();
				setState(124);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(122);
					match(T__10);
					setState(123);
					stmt();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new StmtExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(126);
				stmtExpr();
				setState(127);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__1);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33835976452L) != 0)) {
				{
				{
				setState(132);
				stmt();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }

		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocationExprContext extends ExprContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LocationExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterLocationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitLocationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitLocationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullContext extends ExprContext {
		public NullContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitNull(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SuperContext extends ExprContext {
		public SuperContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterSuper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitSuper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitSuper(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperationContext extends ExprContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryOperationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterUnaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitUnaryOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitUnaryOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharacterContext extends ExprContext {
		public TerminalNode CHARACTER() { return getToken(MinijavaParser.CHARACTER, 0); }
		public CharacterContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterCharacter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitCharacter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitCharacter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ConstantContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtExprExprContext extends ExprContext {
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public StmtExprExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterStmtExprExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitStmtExprExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitStmtExprExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOperationContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryOpContext binaryOp() {
			return getRuleContext(BinaryOpContext.class,0);
		}
		public BinaryOperationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterBinaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitBinaryOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitBinaryOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstVarContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public InstVarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterInstVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitInstVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitInstVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ThisContext extends ExprContext {
		public ThisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterThis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitThis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitThis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public List<TerminalNode> CHARACTER() { return getTokens(MinijavaParser.CHARACTER); }
		public TerminalNode CHARACTER(int i) {
			return getToken(MinijavaParser.CHARACTER, i);
		}
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(141);
				match(T__11);
				}
				break;
			case 2:
				{
				_localctx = new SuperContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(T__12);
				}
				break;
			case 3:
				{
				_localctx = new LocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				location();
				}
				break;
			case 4:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				unaryOp();
				setState(145);
				expr(8);
				}
				break;
			case 5:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				literal();
				}
				break;
			case 6:
				{
				_localctx = new CharacterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				match(T__14);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHARACTER) {
					{
					setState(149);
					match(CHARACTER);
					}
				}

				setState(152);
				match(T__14);
				}
				break;
			case 7:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(T__15);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CHARACTER) {
					{
					{
					setState(154);
					match(CHARACTER);
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(160);
				match(T__15);
				}
				break;
			case 8:
				{
				_localctx = new NullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(T__16);
				}
				break;
			case 9:
				{
				_localctx = new ExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(T__4);
				setState(163);
				expr(0);
				setState(164);
				match(T__5);
				}
				break;
			case 10:
				{
				_localctx = new StmtExprExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				stmtExpr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOperationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(170);
						binaryOp();
						setState(171);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new InstVarContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(174);
						match(T__13);
						setState(175);
						id();
						}
						break;
					}
					}
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocationContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtExprContext extends ParserRuleContext {
		public StmtExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtExpr; }

		public StmtExprContext() { }
		public void copyFrom(StmtExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewContext extends StmtExprContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public NewContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryAssignPreContext extends StmtExprContext {
		public UnaryAssOpContext unaryAssOp() {
			return getRuleContext(UnaryAssOpContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public UnaryAssignPreContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterUnaryAssignPre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitUnaryAssignPre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitUnaryAssignPre(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends StmtExprContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends StmtExprContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public MethodCallContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryAssignPostContext extends StmtExprContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public UnaryAssOpContext unaryAssOp() {
			return getRuleContext(UnaryAssOpContext.class,0);
		}
		public UnaryAssignPostContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterUnaryAssignPost(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitUnaryAssignPost(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitUnaryAssignPost(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtExprContext stmtExpr() throws RecognitionException {
		StmtExprContext _localctx = new StmtExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stmtExpr);
		int _la;
		try {
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new UnaryAssignPostContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				id();
				setState(184);
				unaryAssOp();
				}
				break;
			case 2:
				_localctx = new UnaryAssignPreContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				unaryAssOp();
				setState(187);
				id();
				}
				break;
			case 3:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				id();
				setState(190);
				match(T__17);
				setState(191);
				expr(0);
				}
				break;
			case 4:
				_localctx = new NewContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				match(T__18);
				setState(194);
				type();
				setState(195);
				match(T__4);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 51673542688L) != 0)) {
					{
					setState(196);
					args();
					}
				}

				setState(199);
				match(T__5);
				}
				break;
			case 5:
				_localctx = new MethodCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(201);
					location();
					setState(202);
					match(T__13);
					}
					break;
				}
				setState(206);
				id();
				setState(207);
				match(T__4);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 51673542688L) != 0)) {
					{
					setState(208);
					args();
					}
				}

				setState(211);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryAssOpContext extends ParserRuleContext {
		public TerminalNode INCR() { return getToken(MinijavaParser.INCR, 0); }
		public TerminalNode DECR() { return getToken(MinijavaParser.DECR, 0); }
		public UnaryAssOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryAssOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterUnaryAssOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitUnaryAssOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitUnaryAssOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryAssOpContext unaryAssOp() throws RecognitionException {
		UnaryAssOpContext _localctx = new UnaryAssOpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unaryAssOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_la = _input.LA(1);
			if ( !(_la==INCR || _la==DECR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOpContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(MinijavaParser.NOT, 0); }
		public TerminalNode PLUS() { return getToken(MinijavaParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MinijavaParser.MINUS, 0); }
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 117440512L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(MinijavaParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MinijavaParser.MINUS, 0); }
		public TerminalNode MUL() { return getToken(MinijavaParser.MUL, 0); }
		public BinaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitBinaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOpContext binaryOp() throws RecognitionException {
		BinaryOpContext _localctx = new BinaryOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_binaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881024L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			expr(0);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(222);
				match(T__6);
				setState(223);
				expr(0);
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_literal);
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				number();
				}
				break;
			case T__19:
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				boolean_();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ParserRuleContext {
		public BooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanContext boolean_() throws RecognitionException {
		BooleanContext _localctx = new BooleanContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_boolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_la = _input.LA(1);
			if ( !(_la==T__19 || _la==T__20) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(MinijavaParser.Number, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(Number);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MinijavaParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00f0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0005\u0000.\b\u0000\n\u0000\f\u00001\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"9\b\u0001\n\u0001\f\u0001<\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003J\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"R\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006Z\b\u0006\n\u0006\f\u0006]\t\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0003\be\b\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t}\b\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u0082\b\t\u0001\n\u0001\n\u0005\n\u0086\b\n\n\n\f\n\u0089\t\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u0097\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u009c\b"+
		"\u000b\n\u000b\f\u000b\u009f\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a8\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00b1\b\u000b\n\u000b\f\u000b\u00b4\t\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c6\b\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00cd\b\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u00d2\b\r\u0001\r\u0001\r\u0003\r\u00d6\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u00e1\b\u0011\n\u0011\f\u0011\u00e4\t\u0011"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00e8\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0000\u0001"+
		"\u0016\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*\u0000\u0004\u0001\u0000\u0016\u0017\u0001"+
		"\u0000\u0018\u001a\u0001\u0000\u0019\u001b\u0001\u0000\u0014\u0015\u0102"+
		"\u0000/\u0001\u0000\u0000\u0000\u00022\u0001\u0000\u0000\u0000\u0004?"+
		"\u0001\u0000\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\bK\u0001\u0000"+
		"\u0000\u0000\nM\u0001\u0000\u0000\u0000\fV\u0001\u0000\u0000\u0000\u000e"+
		"^\u0001\u0000\u0000\u0000\u0010a\u0001\u0000\u0000\u0000\u0012\u0081\u0001"+
		"\u0000\u0000\u0000\u0014\u0083\u0001\u0000\u0000\u0000\u0016\u00a7\u0001"+
		"\u0000\u0000\u0000\u0018\u00b5\u0001\u0000\u0000\u0000\u001a\u00d5\u0001"+
		"\u0000\u0000\u0000\u001c\u00d7\u0001\u0000\u0000\u0000\u001e\u00d9\u0001"+
		"\u0000\u0000\u0000 \u00db\u0001\u0000\u0000\u0000\"\u00dd\u0001\u0000"+
		"\u0000\u0000$\u00e7\u0001\u0000\u0000\u0000&\u00e9\u0001\u0000\u0000\u0000"+
		"(\u00eb\u0001\u0000\u0000\u0000*\u00ed\u0001\u0000\u0000\u0000,.\u0003"+
		"\u0002\u0001\u0000-,\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000\u0000"+
		"/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000\u0001\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000023\u0005\u0001\u0000\u000034\u0003"+
		"\u0006\u0003\u00004:\u0005\u0002\u0000\u000059\u0003\u0004\u0002\u0000"+
		"69\u0003\n\u0005\u000079\u0003\u0010\b\u000085\u0001\u0000\u0000\u0000"+
		"86\u0001\u0000\u0000\u000087\u0001\u0000\u0000\u00009<\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000"+
		"\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0005\u0003\u0000\u0000>\u0003"+
		"\u0001\u0000\u0000\u0000?@\u0003\u0006\u0003\u0000@A\u0003*\u0015\u0000"+
		"AB\u0005\u0004\u0000\u0000B\u0005\u0001\u0000\u0000\u0000CJ\u0005\u001d"+
		"\u0000\u0000DJ\u0005\u001e\u0000\u0000EJ\u0005\u001f\u0000\u0000FJ\u0005"+
		" \u0000\u0000GJ\u0005!\u0000\u0000HJ\u0003\b\u0004\u0000IC\u0001\u0000"+
		"\u0000\u0000ID\u0001\u0000\u0000\u0000IE\u0001\u0000\u0000\u0000IF\u0001"+
		"\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IH\u0001\u0000\u0000\u0000"+
		"J\u0007\u0001\u0000\u0000\u0000KL\u0003*\u0015\u0000L\t\u0001\u0000\u0000"+
		"\u0000MN\u0003\u0006\u0003\u0000NO\u0003*\u0015\u0000OQ\u0005\u0005\u0000"+
		"\u0000PR\u0003\f\u0006\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000RS\u0001\u0000\u0000\u0000ST\u0005\u0006\u0000\u0000TU\u0003\u0014"+
		"\n\u0000U\u000b\u0001\u0000\u0000\u0000V[\u0003\u000e\u0007\u0000WX\u0005"+
		"\u0007\u0000\u0000XZ\u0003\u000e\u0007\u0000YW\u0001\u0000\u0000\u0000"+
		"Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\\r\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0003\u0006"+
		"\u0003\u0000_`\u0003*\u0015\u0000`\u000f\u0001\u0000\u0000\u0000ab\u0003"+
		"\b\u0004\u0000bd\u0005\u0005\u0000\u0000ce\u0003\f\u0006\u0000dc\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000"+
		"fg\u0005\u0006\u0000\u0000gh\u0003\u0014\n\u0000h\u0011\u0001\u0000\u0000"+
		"\u0000i\u0082\u0003\u0014\n\u0000jk\u0005\b\u0000\u0000kl\u0003\u0016"+
		"\u000b\u0000lm\u0005\u0004\u0000\u0000m\u0082\u0001\u0000\u0000\u0000"+
		"no\u0005\t\u0000\u0000op\u0005\u0005\u0000\u0000pq\u0003\u0016\u000b\u0000"+
		"qr\u0005\u0006\u0000\u0000rs\u0003\u0012\t\u0000s\u0082\u0001\u0000\u0000"+
		"\u0000t\u0082\u0003\u0004\u0002\u0000uv\u0005\n\u0000\u0000vw\u0005\u0005"+
		"\u0000\u0000wx\u0003\u0016\u000b\u0000xy\u0005\u0006\u0000\u0000y|\u0003"+
		"\u0012\t\u0000z{\u0005\u000b\u0000\u0000{}\u0003\u0012\t\u0000|z\u0001"+
		"\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0082\u0001\u0000\u0000"+
		"\u0000~\u007f\u0003\u001a\r\u0000\u007f\u0080\u0005\u0004\u0000\u0000"+
		"\u0080\u0082\u0001\u0000\u0000\u0000\u0081i\u0001\u0000\u0000\u0000\u0081"+
		"j\u0001\u0000\u0000\u0000\u0081n\u0001\u0000\u0000\u0000\u0081t\u0001"+
		"\u0000\u0000\u0000\u0081u\u0001\u0000\u0000\u0000\u0081~\u0001\u0000\u0000"+
		"\u0000\u0082\u0013\u0001\u0000\u0000\u0000\u0083\u0087\u0005\u0002\u0000"+
		"\u0000\u0084\u0086\u0003\u0012\t\u0000\u0085\u0084\u0001\u0000\u0000\u0000"+
		"\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008a\u0001\u0000\u0000\u0000"+
		"\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0003\u0000\u0000"+
		"\u008b\u0015\u0001\u0000\u0000\u0000\u008c\u008d\u0006\u000b\uffff\uffff"+
		"\u0000\u008d\u00a8\u0005\f\u0000\u0000\u008e\u00a8\u0005\r\u0000\u0000"+
		"\u008f\u00a8\u0003\u0018\f\u0000\u0090\u0091\u0003\u001e\u000f\u0000\u0091"+
		"\u0092\u0003\u0016\u000b\b\u0092\u00a8\u0001\u0000\u0000\u0000\u0093\u00a8"+
		"\u0003$\u0012\u0000\u0094\u0096\u0005\u000f\u0000\u0000\u0095\u0097\u0005"+
		"$\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u00a8\u0005\u000f"+
		"\u0000\u0000\u0099\u009d\u0005\u0010\u0000\u0000\u009a\u009c\u0005$\u0000"+
		"\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000\u0000"+
		"\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000"+
		"\u0000\u009e\u00a0\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a8\u0005\u0010\u0000\u0000\u00a1\u00a8\u0005\u0011\u0000"+
		"\u0000\u00a2\u00a3\u0005\u0005\u0000\u0000\u00a3\u00a4\u0003\u0016\u000b"+
		"\u0000\u00a4\u00a5\u0005\u0006\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a8\u0003\u001a\r\u0000\u00a7\u008c\u0001\u0000\u0000\u0000"+
		"\u00a7\u008e\u0001\u0000\u0000\u0000\u00a7\u008f\u0001\u0000\u0000\u0000"+
		"\u00a7\u0090\u0001\u0000\u0000\u0000\u00a7\u0093\u0001\u0000\u0000\u0000"+
		"\u00a7\u0094\u0001\u0000\u0000\u0000\u00a7\u0099\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a1\u0001\u0000\u0000\u0000\u00a7\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00b2\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\n\u0007\u0000\u0000\u00aa\u00ab\u0003 \u0010\u0000\u00ab"+
		"\u00ac\u0003\u0016\u000b\b\u00ac\u00b1\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\n\t\u0000\u0000\u00ae\u00af\u0005\u000e\u0000\u0000\u00af\u00b1\u0003"+
		"*\u0015\u0000\u00b0\u00a9\u0001\u0000\u0000\u0000\u00b0\u00ad\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u0017\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b6\u0003*\u0015"+
		"\u0000\u00b6\u0019\u0001\u0000\u0000\u0000\u00b7\u00b8\u0003*\u0015\u0000"+
		"\u00b8\u00b9\u0003\u001c\u000e\u0000\u00b9\u00d6\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0003\u001c\u000e\u0000\u00bb\u00bc\u0003*\u0015\u0000\u00bc"+
		"\u00d6\u0001\u0000\u0000\u0000\u00bd\u00be\u0003*\u0015\u0000\u00be\u00bf"+
		"\u0005\u0012\u0000\u0000\u00bf\u00c0\u0003\u0016\u000b\u0000\u00c0\u00d6"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005\u0013\u0000\u0000\u00c2\u00c3"+
		"\u0003\u0006\u0003\u0000\u00c3\u00c5\u0005\u0005\u0000\u0000\u00c4\u00c6"+
		"\u0003\"\u0011\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005"+
		"\u0006\u0000\u0000\u00c8\u00d6\u0001\u0000\u0000\u0000\u00c9\u00ca\u0003"+
		"\u0018\f\u0000\u00ca\u00cb\u0005\u000e\u0000\u0000\u00cb\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cc\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0003*\u0015"+
		"\u0000\u00cf\u00d1\u0005\u0005\u0000\u0000\u00d0\u00d2\u0003\"\u0011\u0000"+
		"\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u0006\u0000\u0000"+
		"\u00d4\u00d6\u0001\u0000\u0000\u0000\u00d5\u00b7\u0001\u0000\u0000\u0000"+
		"\u00d5\u00ba\u0001\u0000\u0000\u0000\u00d5\u00bd\u0001\u0000\u0000\u0000"+
		"\u00d5\u00c1\u0001\u0000\u0000\u0000\u00d5\u00cc\u0001\u0000\u0000\u0000"+
		"\u00d6\u001b\u0001\u0000\u0000\u0000\u00d7\u00d8\u0007\u0000\u0000\u0000"+
		"\u00d8\u001d\u0001\u0000\u0000\u0000\u00d9\u00da\u0007\u0001\u0000\u0000"+
		"\u00da\u001f\u0001\u0000\u0000\u0000\u00db\u00dc\u0007\u0002\u0000\u0000"+
		"\u00dc!\u0001\u0000\u0000\u0000\u00dd\u00e2\u0003\u0016\u000b\u0000\u00de"+
		"\u00df\u0005\u0007\u0000\u0000\u00df\u00e1\u0003\u0016\u000b\u0000\u00e0"+
		"\u00de\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3"+
		"#\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e8"+
		"\u0003(\u0014\u0000\u00e6\u00e8\u0003&\u0013\u0000\u00e7\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8%\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0007\u0003\u0000\u0000\u00ea\'\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0005#\u0000\u0000\u00ec)\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0005\"\u0000\u0000\u00ee+\u0001\u0000\u0000\u0000\u0015/8:IQ[d|\u0081"+
		"\u0087\u0096\u009d\u00a7\u00b0\u00b2\u00c5\u00cc\u00d1\u00d5\u00e2\u00e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
