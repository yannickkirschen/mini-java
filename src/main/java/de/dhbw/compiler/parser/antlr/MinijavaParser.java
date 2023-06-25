// Generated from /Users/malterichert/IdeaProjects/mini-java/src/main/java/de/dhbw/compiler/parser/Minijava.g4 by ANTLR 4.12.0
package de.dhbw.compiler.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MinijavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, This=17, 
		Super=18, Null=19, Incr=20, Decr=21, Not=22, Plus=23, Minus=24, Mul=25, 
		Div=26, Mod=27, Equal=28, NotEqual=29, Greater=30, GreaterOrEqual=31, 
		Less=32, LessOrEqual=33, Or=34, And=35, Int=36, Bool=37, Char=38, String=39, 
		Void=40, Boolean=41, Id=42, Number=43, Character=44, WS=45, Comment=46, 
		BlockComment=47;
	public static final int
		RULE_program = 0, RULE_class = 1, RULE_varDecl = 2, RULE_type = 3, RULE_refType = 4, 
		RULE_meth = 5, RULE_params = 6, RULE_param = 7, RULE_constructor = 8, 
		RULE_block = 9, RULE_return = 10, RULE_while = 11, RULE_localVarDeclAssign = 12, 
		RULE_if = 13, RULE_stmt = 14, RULE_instVar = 15, RULE_localOrFieldVar = 16, 
		RULE_unaryOperation = 17, RULE_constant = 18, RULE_char = 19, RULE_string = 20, 
		RULE_expression = 21, RULE_binaryOperation = 22, RULE_arithmeticBinOp = 23, 
		RULE_mulOp = 24, RULE_mulSubOp = 25, RULE_logicalBinOp = 26, RULE_expr = 27, 
		RULE_subExpression = 28, RULE_unaryAssign = 29, RULE_new = 30, RULE_methodCall = 31, 
		RULE_assign = 32, RULE_assignable = 33, RULE_stmtExpr = 34, RULE_unaryAssOp = 35, 
		RULE_unaryOp = 36, RULE_binMulOperator = 37, RULE_binAddOperator = 38, 
		RULE_binLogicalOperator = 39, RULE_args = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "class", "varDecl", "type", "refType", "meth", "params", "param", 
			"constructor", "block", "return", "while", "localVarDeclAssign", "if", 
			"stmt", "instVar", "localOrFieldVar", "unaryOperation", "constant", "char", 
			"string", "expression", "binaryOperation", "arithmeticBinOp", "mulOp", 
			"mulSubOp", "logicalBinOp", "expr", "subExpression", "unaryAssign", "new", 
			"methodCall", "assign", "assignable", "stmtExpr", "unaryAssOp", "unaryOp", 
			"binMulOperator", "binAddOperator", "binLogicalOperator", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'{'", "';'", "'}'", "'('", "')'", "','", "'return'", 
			"'while'", "'='", "'if'", "'else'", "'.'", "'''", "'\"'", "'new'", "'this'", 
			"'super'", "'null'", "'++'", "'--'", "'!'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'=='", "'!='", "'>'", "'>='", "'<'", "'<='", "'||'", "'&&'", 
			"'int'", "'boolean'", "'char'", "'String'", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "This", "Super", "Null", "Incr", "Decr", 
			"Not", "Plus", "Minus", "Mul", "Div", "Mod", "Equal", "NotEqual", "Greater", 
			"GreaterOrEqual", "Less", "LessOrEqual", "Or", "And", "Int", "Bool", 
			"Char", "String", "Void", "Boolean", "Id", "Number", "Character", "WS", 
			"Comment", "BlockComment"
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
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				class_();
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
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
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<MethContext> meth() {
			return getRuleContexts(MethContext.class);
		}
		public MethContext meth(int i) {
			return getRuleContext(MethContext.class,i);
		}
		public List<ConstructorContext> constructor() {
			return getRuleContexts(ConstructorContext.class);
		}
		public ConstructorContext constructor(int i) {
			return getRuleContext(ConstructorContext.class,i);
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
			setState(87);
			match(T__0);
			setState(88);
			type();
			setState(89);
			match(T__1);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6528350289920L) != 0)) {
				{
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(90);
					varDecl();
					setState(91);
					match(T__2);
					}
					break;
				case 2:
					{
					setState(93);
					meth();
					}
					break;
				case 3:
					{
					setState(94);
					constructor();
					}
					break;
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
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
	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Id() { return getToken(MinijavaParser.Id, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			type();
			setState(103);
			match(Id);
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
		public TerminalNode Int() { return getToken(MinijavaParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MinijavaParser.Bool, 0); }
		public TerminalNode Char() { return getToken(MinijavaParser.Char, 0); }
		public TerminalNode String() { return getToken(MinijavaParser.String, 0); }
		public TerminalNode Void() { return getToken(MinijavaParser.Void, 0); }
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
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(Int);
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(Bool);
				}
				break;
			case Char:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				match(Char);
				}
				break;
			case String:
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				match(String);
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 5);
				{
				setState(109);
				match(Void);
				}
				break;
			case Id:
				enterOuterAlt(_localctx, 6);
				{
				setState(110);
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
		public TerminalNode Id() { return getToken(MinijavaParser.Id, 0); }
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
			setState(113);
			match(Id);
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
		public TerminalNode Id() { return getToken(MinijavaParser.Id, 0); }
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
			setState(115);
			type();
			setState(116);
			match(Id);
			setState(117);
			match(T__4);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6528350289920L) != 0)) {
				{
				setState(118);
				params();
				}
			}

			setState(121);
			match(T__5);
			setState(122);
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
			setState(124);
			param();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(125);
				match(T__6);
				setState(126);
				param();
				}
				}
				setState(131);
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
		public TerminalNode Id() { return getToken(MinijavaParser.Id, 0); }
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
			setState(132);
			type();
			setState(133);
			match(Id);
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
	public static class ConstructorContext extends ParserRuleContext {
		public RefTypeContext refType() {
			return getRuleContext(RefTypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			refType();
			setState(136);
			match(T__4);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6528350289920L) != 0)) {
				{
				setState(137);
				params();
				}
			}

			setState(140);
			match(T__5);
			setState(141);
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
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__1);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6528353635076L) != 0)) {
				{
				{
				setState(144);
				stmt();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
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
	public static class ReturnContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
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

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__7);
			setState(153);
			expr();
			setState(154);
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
	public static class WhileContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
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

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__8);
			setState(157);
			match(T__4);
			setState(158);
			expr();
			setState(159);
			match(T__5);
			setState(160);
			stmt();
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
	public static class LocalVarDeclAssignContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LocalVarDeclAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVarDeclAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterLocalVarDeclAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitLocalVarDeclAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitLocalVarDeclAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVarDeclAssignContext localVarDeclAssign() throws RecognitionException {
		LocalVarDeclAssignContext _localctx = new LocalVarDeclAssignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_localVarDeclAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			varDecl();
			setState(163);
			match(T__9);
			setState(164);
			expr();
			setState(165);
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
	public static class IfContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
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

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(T__10);
			setState(168);
			match(T__4);
			setState(169);
			expr();
			setState(170);
			match(T__5);
			setState(171);
			stmt();
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(172);
				match(T__11);
				setState(173);
				stmt();
				}
				break;
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
	public static class StmtContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public LocalVarDeclAssignContext localVarDeclAssign() {
			return getRuleContext(LocalVarDeclAssignContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stmt);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				return_();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				while_();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				localVarDeclAssign();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				varDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
				if_();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(182);
				stmtExpr();
				setState(183);
				match(T__2);
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
	public static class InstVarContext extends ParserRuleContext {
		public TerminalNode This() { return getToken(MinijavaParser.This, 0); }
		public List<TerminalNode> Id() { return getTokens(MinijavaParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(MinijavaParser.Id, i);
		}
		public InstVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instVar; }
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

	public final InstVarContext instVar() throws RecognitionException {
		InstVarContext _localctx = new InstVarContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_instVar);
		int _la;
		try {
			int _alt;
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(This);
				setState(188);
				match(T__12);
				setState(189);
				match(Id);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==This) {
					{
					setState(190);
					match(This);
					setState(191);
					match(T__12);
					}
				}

				setState(196); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(194);
						match(Id);
						setState(195);
						match(T__12);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(198); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(200);
				match(Id);
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
	public static class LocalOrFieldVarContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MinijavaParser.Id, 0); }
		public LocalOrFieldVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localOrFieldVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterLocalOrFieldVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitLocalOrFieldVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitLocalOrFieldVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalOrFieldVarContext localOrFieldVar() throws RecognitionException {
		LocalOrFieldVarContext _localctx = new LocalOrFieldVarContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_localOrFieldVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(Id);
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
	public static class UnaryOperationContext extends ParserRuleContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperation; }
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

	public final UnaryOperationContext unaryOperation() throws RecognitionException {
		UnaryOperationContext _localctx = new UnaryOperationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unaryOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			unaryOp();
			setState(206);
			expr();
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
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(MinijavaParser.Number, 0); }
		public TerminalNode Boolean() { return getToken(MinijavaParser.Boolean, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
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

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !(_la==Boolean || _la==Number) ) {
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
	public static class CharContext extends ParserRuleContext {
		public TerminalNode Character() { return getToken(MinijavaParser.Character, 0); }
		public CharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitChar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharContext char_() throws RecognitionException {
		CharContext _localctx = new CharContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_char);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__13);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Character) {
				{
				setState(211);
				match(Character);
				}
			}

			setState(214);
			match(T__13);
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
	public static class StringContext extends ParserRuleContext {
		public List<TerminalNode> Character() { return getTokens(MinijavaParser.Character); }
		public TerminalNode Character(int i) {
			return getToken(MinijavaParser.Character, i);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
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

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__14);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Character) {
				{
				{
				setState(217);
				match(Character);
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
			match(T__14);
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
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

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__4);
			setState(226);
			expr();
			setState(227);
			match(T__5);
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
	public static class BinaryOperationContext extends ParserRuleContext {
		public ArithmeticBinOpContext arithmeticBinOp() {
			return getRuleContext(ArithmeticBinOpContext.class,0);
		}
		public LogicalBinOpContext logicalBinOp() {
			return getRuleContext(LogicalBinOpContext.class,0);
		}
		public BinaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperation; }
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

	public final BinaryOperationContext binaryOperation() throws RecognitionException {
		BinaryOperationContext _localctx = new BinaryOperationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_binaryOperation);
		try {
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				arithmeticBinOp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				logicalBinOp();
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
	public static class ArithmeticBinOpContext extends ParserRuleContext {
		public SubExpressionContext subExpression() {
			return getRuleContext(SubExpressionContext.class,0);
		}
		public BinMulOperatorContext binMulOperator() {
			return getRuleContext(BinMulOperatorContext.class,0);
		}
		public MulOpContext mulOp() {
			return getRuleContext(MulOpContext.class,0);
		}
		public ArithmeticBinOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticBinOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterArithmeticBinOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitArithmeticBinOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitArithmeticBinOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticBinOpContext arithmeticBinOp() throws RecognitionException {
		ArithmeticBinOpContext _localctx = new ArithmeticBinOpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arithmeticBinOp);
		try {
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				subExpression();
				setState(234);
				binMulOperator();
				setState(235);
				mulOp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				mulOp(0);
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
	public static class MulOpContext extends ParserRuleContext {
		public MulSubOpContext mulSubOp() {
			return getRuleContext(MulSubOpContext.class,0);
		}
		public MulOpContext mulOp() {
			return getRuleContext(MulOpContext.class,0);
		}
		public BinMulOperatorContext binMulOperator() {
			return getRuleContext(BinMulOperatorContext.class,0);
		}
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterMulOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitMulOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitMulOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulOpContext mulOp() throws RecognitionException {
		return mulOp(0);
	}

	private MulOpContext mulOp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulOpContext _localctx = new MulOpContext(_ctx, _parentState);
		MulOpContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_mulOp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(241);
			mulSubOp();
			}
			_ctx.stop = _input.LT(-1);
			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulOpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulOp);
					setState(243);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(244);
					binMulOperator();
					setState(245);
					mulSubOp();
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
	public static class MulSubOpContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(MinijavaParser.Number, 0); }
		public LocalOrFieldVarContext localOrFieldVar() {
			return getRuleContext(LocalOrFieldVarContext.class,0);
		}
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ArithmeticBinOpContext arithmeticBinOp() {
			return getRuleContext(ArithmeticBinOpContext.class,0);
		}
		public MulSubOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulSubOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterMulSubOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitMulSubOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitMulSubOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulSubOpContext mulSubOp() throws RecognitionException {
		MulSubOpContext _localctx = new MulSubOpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_mulSubOp);
		try {
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				match(Number);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				localOrFieldVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				instVar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(255);
				methodCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(256);
				match(T__4);
				setState(257);
				arithmeticBinOp();
				setState(258);
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
	public static class LogicalBinOpContext extends ParserRuleContext {
		public SubExpressionContext subExpression() {
			return getRuleContext(SubExpressionContext.class,0);
		}
		public BinLogicalOperatorContext binLogicalOperator() {
			return getRuleContext(BinLogicalOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LogicalBinOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalBinOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterLogicalBinOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitLogicalBinOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitLogicalBinOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalBinOpContext logicalBinOp() throws RecognitionException {
		LogicalBinOpContext _localctx = new LogicalBinOpContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_logicalBinOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			subExpression();
			setState(263);
			binLogicalOperator();
			setState(264);
			expression();
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
		public SubExpressionContext subExpression() {
			return getRuleContext(SubExpressionContext.class,0);
		}
		public BinaryOperationContext binaryOperation() {
			return getRuleContext(BinaryOperationContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expr);
		try {
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				subExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				binaryOperation();
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
	public static class SubExpressionContext extends ParserRuleContext {
		public TerminalNode This() { return getToken(MinijavaParser.This, 0); }
		public TerminalNode Super() { return getToken(MinijavaParser.Super, 0); }
		public LocalOrFieldVarContext localOrFieldVar() {
			return getRuleContext(LocalOrFieldVarContext.class,0);
		}
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public UnaryOperationContext unaryOperation() {
			return getRuleContext(UnaryOperationContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public CharContext char_() {
			return getRuleContext(CharContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode Null() { return getToken(MinijavaParser.Null, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public SubExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterSubExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitSubExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitSubExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubExpressionContext subExpression() throws RecognitionException {
		SubExpressionContext _localctx = new SubExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_subExpression);
		try {
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				match(This);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				match(Super);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
				localOrFieldVar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(273);
				instVar();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(274);
				unaryOperation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(275);
				constant();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(276);
				char_();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(277);
				string();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(278);
				match(Null);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(279);
				expression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(280);
				stmtExpr();
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
	public static class UnaryAssignContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public UnaryAssOpContext unaryAssOp() {
			return getRuleContext(UnaryAssOpContext.class,0);
		}
		public UnaryAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterUnaryAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitUnaryAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitUnaryAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryAssignContext unaryAssign() throws RecognitionException {
		UnaryAssignContext _localctx = new UnaryAssignContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unaryAssign);
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case This:
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				assignable();
				setState(284);
				unaryAssOp();
				}
				break;
			case Incr:
			case Decr:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				unaryAssOp();
				setState(287);
				assignable();
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
	public static class NewContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public NewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new; }
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

	public final NewContext new_() throws RecognitionException {
		NewContext _localctx = new NewContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_new);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(T__15);
			setState(292);
			type();
			setState(293);
			match(T__4);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15393196326944L) != 0)) {
				{
				setState(294);
				args();
				}
			}

			setState(297);
			match(T__5);
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
	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MinijavaParser.Id, 0); }
		public LocalOrFieldVarContext localOrFieldVar() {
			return getRuleContext(LocalOrFieldVarContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
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

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(299);
				localOrFieldVar();
				setState(300);
				match(T__12);
				}
				break;
			}
			setState(304);
			match(Id);
			setState(305);
			match(T__4);
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15393196326944L) != 0)) {
				{
				setState(306);
				args();
				}
			}

			setState(309);
			match(T__5);
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
	public static class AssignContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
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

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			assignable();
			setState(312);
			match(T__9);
			setState(313);
			expr();
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
	public static class AssignableContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MinijavaParser.Id, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public AssignableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterAssignable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitAssignable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitAssignable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignableContext assignable() throws RecognitionException {
		AssignableContext _localctx = new AssignableContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_assignable);
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				match(Id);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				instVar();
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
	public static class StmtExprContext extends ParserRuleContext {
		public UnaryAssignContext unaryAssign() {
			return getRuleContext(UnaryAssignContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public NewContext new_() {
			return getRuleContext(NewContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public StmtExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterStmtExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitStmtExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitStmtExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtExprContext stmtExpr() throws RecognitionException {
		StmtExprContext _localctx = new StmtExprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_stmtExpr);
		try {
			setState(323);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				unaryAssign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				assign();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(321);
				new_();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(322);
				methodCall();
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
		public TerminalNode Incr() { return getToken(MinijavaParser.Incr, 0); }
		public TerminalNode Decr() { return getToken(MinijavaParser.Decr, 0); }
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
		enterRule(_localctx, 70, RULE_unaryAssOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if ( !(_la==Incr || _la==Decr) ) {
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
		public TerminalNode Not() { return getToken(MinijavaParser.Not, 0); }
		public TerminalNode Plus() { return getToken(MinijavaParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(MinijavaParser.Minus, 0); }
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
		enterRule(_localctx, 72, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360128L) != 0)) ) {
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
	public static class BinMulOperatorContext extends ParserRuleContext {
		public TerminalNode Mul() { return getToken(MinijavaParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MinijavaParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MinijavaParser.Mod, 0); }
		public BinMulOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binMulOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterBinMulOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitBinMulOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitBinMulOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinMulOperatorContext binMulOperator() throws RecognitionException {
		BinMulOperatorContext _localctx = new BinMulOperatorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_binMulOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
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
	public static class BinAddOperatorContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(MinijavaParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(MinijavaParser.Minus, 0); }
		public BinAddOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binAddOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterBinAddOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitBinAddOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitBinAddOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinAddOperatorContext binAddOperator() throws RecognitionException {
		BinAddOperatorContext _localctx = new BinAddOperatorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_binAddOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_la = _input.LA(1);
			if ( !(_la==Plus || _la==Minus) ) {
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
	public static class BinLogicalOperatorContext extends ParserRuleContext {
		public TerminalNode Equal() { return getToken(MinijavaParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(MinijavaParser.NotEqual, 0); }
		public TerminalNode Greater() { return getToken(MinijavaParser.Greater, 0); }
		public TerminalNode GreaterOrEqual() { return getToken(MinijavaParser.GreaterOrEqual, 0); }
		public TerminalNode Less() { return getToken(MinijavaParser.Less, 0); }
		public TerminalNode LessOrEqual() { return getToken(MinijavaParser.LessOrEqual, 0); }
		public TerminalNode And() { return getToken(MinijavaParser.And, 0); }
		public TerminalNode Or() { return getToken(MinijavaParser.Or, 0); }
		public BinLogicalOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binLogicalOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).enterBinLogicalOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinijavaListener ) ((MinijavaListener)listener).exitBinLogicalOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinijavaVisitor ) return ((MinijavaVisitor<? extends T>)visitor).visitBinLogicalOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinLogicalOperatorContext binLogicalOperator() throws RecognitionException {
		BinLogicalOperatorContext _localctx = new BinLogicalOperatorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_binLogicalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 68451041280L) != 0)) ) {
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
		enterRule(_localctx, 80, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			expr();
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(336);
				match(T__6);
				setState(337);
				expr();
				}
				}
				setState(342);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 24:
			return mulOp_sempred((MulOpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean mulOp_sempred(MulOpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u0158\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0001\u0000\u0004\u0000T\b\u0000\u000b\u0000\f\u0000U\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001`\b\u0001\n\u0001\f\u0001c\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003p\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005x\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006\u0080\b\u0006\n\u0006\f\u0006\u0083"+
		"\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u008b\b\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0005\t\u0092\b\t"+
		"\n\t\f\t\u0095\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00af\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00ba\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00c1\b\u000f\u0001\u000f\u0001\u000f\u0004\u000f"+
		"\u00c5\b\u000f\u000b\u000f\f\u000f\u00c6\u0001\u000f\u0003\u000f\u00ca"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u00d5\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0005\u0014\u00db\b\u0014\n"+
		"\u0014\f\u0014\u00de\t\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u00e8"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u00ef\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u00f8\b\u0018\n\u0018\f\u0018"+
		"\u00fb\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0105\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u010d\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u011a\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0003\u001d\u0122\b\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u0128\b\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u012f\b\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0003\u001f\u0134\b\u001f\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0003!\u013e\b!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0003\"\u0144\b\"\u0001#\u0001#\u0001$\u0001$\u0001"+
		"%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0005(\u0153"+
		"\b(\n(\f(\u0156\t(\u0001(\u0000\u00010)\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:"+
		"<>@BDFHJLNP\u0000\u0006\u0002\u0000))++\u0001\u0000\u0014\u0015\u0001"+
		"\u0000\u0016\u0018\u0001\u0000\u0019\u001b\u0001\u0000\u0017\u0018\u0001"+
		"\u0000\u001c#\u0162\u0000S\u0001\u0000\u0000\u0000\u0002W\u0001\u0000"+
		"\u0000\u0000\u0004f\u0001\u0000\u0000\u0000\u0006o\u0001\u0000\u0000\u0000"+
		"\bq\u0001\u0000\u0000\u0000\ns\u0001\u0000\u0000\u0000\f|\u0001\u0000"+
		"\u0000\u0000\u000e\u0084\u0001\u0000\u0000\u0000\u0010\u0087\u0001\u0000"+
		"\u0000\u0000\u0012\u008f\u0001\u0000\u0000\u0000\u0014\u0098\u0001\u0000"+
		"\u0000\u0000\u0016\u009c\u0001\u0000\u0000\u0000\u0018\u00a2\u0001\u0000"+
		"\u0000\u0000\u001a\u00a7\u0001\u0000\u0000\u0000\u001c\u00b9\u0001\u0000"+
		"\u0000\u0000\u001e\u00c9\u0001\u0000\u0000\u0000 \u00cb\u0001\u0000\u0000"+
		"\u0000\"\u00cd\u0001\u0000\u0000\u0000$\u00d0\u0001\u0000\u0000\u0000"+
		"&\u00d2\u0001\u0000\u0000\u0000(\u00d8\u0001\u0000\u0000\u0000*\u00e1"+
		"\u0001\u0000\u0000\u0000,\u00e7\u0001\u0000\u0000\u0000.\u00ee\u0001\u0000"+
		"\u0000\u00000\u00f0\u0001\u0000\u0000\u00002\u0104\u0001\u0000\u0000\u0000"+
		"4\u0106\u0001\u0000\u0000\u00006\u010c\u0001\u0000\u0000\u00008\u0119"+
		"\u0001\u0000\u0000\u0000:\u0121\u0001\u0000\u0000\u0000<\u0123\u0001\u0000"+
		"\u0000\u0000>\u012e\u0001\u0000\u0000\u0000@\u0137\u0001\u0000\u0000\u0000"+
		"B\u013d\u0001\u0000\u0000\u0000D\u0143\u0001\u0000\u0000\u0000F\u0145"+
		"\u0001\u0000\u0000\u0000H\u0147\u0001\u0000\u0000\u0000J\u0149\u0001\u0000"+
		"\u0000\u0000L\u014b\u0001\u0000\u0000\u0000N\u014d\u0001\u0000\u0000\u0000"+
		"P\u014f\u0001\u0000\u0000\u0000RT\u0003\u0002\u0001\u0000SR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001"+
		"\u0000\u0000\u0000V\u0001\u0001\u0000\u0000\u0000WX\u0005\u0001\u0000"+
		"\u0000XY\u0003\u0006\u0003\u0000Ya\u0005\u0002\u0000\u0000Z[\u0003\u0004"+
		"\u0002\u0000[\\\u0005\u0003\u0000\u0000\\`\u0001\u0000\u0000\u0000]`\u0003"+
		"\n\u0005\u0000^`\u0003\u0010\b\u0000_Z\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000"+
		"a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000"+
		"\u0000ca\u0001\u0000\u0000\u0000de\u0005\u0004\u0000\u0000e\u0003\u0001"+
		"\u0000\u0000\u0000fg\u0003\u0006\u0003\u0000gh\u0005*\u0000\u0000h\u0005"+
		"\u0001\u0000\u0000\u0000ip\u0005$\u0000\u0000jp\u0005%\u0000\u0000kp\u0005"+
		"&\u0000\u0000lp\u0005\'\u0000\u0000mp\u0005(\u0000\u0000np\u0003\b\u0004"+
		"\u0000oi\u0001\u0000\u0000\u0000oj\u0001\u0000\u0000\u0000ok\u0001\u0000"+
		"\u0000\u0000ol\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000on\u0001"+
		"\u0000\u0000\u0000p\u0007\u0001\u0000\u0000\u0000qr\u0005*\u0000\u0000"+
		"r\t\u0001\u0000\u0000\u0000st\u0003\u0006\u0003\u0000tu\u0005*\u0000\u0000"+
		"uw\u0005\u0005\u0000\u0000vx\u0003\f\u0006\u0000wv\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0005\u0006\u0000"+
		"\u0000z{\u0003\u0012\t\u0000{\u000b\u0001\u0000\u0000\u0000|\u0081\u0003"+
		"\u000e\u0007\u0000}~\u0005\u0007\u0000\u0000~\u0080\u0003\u000e\u0007"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082\r\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0003\u0006\u0003\u0000\u0085\u0086\u0005*\u0000\u0000\u0086\u000f"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0003\b\u0004\u0000\u0088\u008a\u0005"+
		"\u0005\u0000\u0000\u0089\u008b\u0003\f\u0006\u0000\u008a\u0089\u0001\u0000"+
		"\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0005\u0006\u0000\u0000\u008d\u008e\u0003\u0012"+
		"\t\u0000\u008e\u0011\u0001\u0000\u0000\u0000\u008f\u0093\u0005\u0002\u0000"+
		"\u0000\u0090\u0092\u0003\u001c\u000e\u0000\u0091\u0090\u0001\u0000\u0000"+
		"\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0096\u0001\u0000\u0000"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u0004\u0000"+
		"\u0000\u0097\u0013\u0001\u0000\u0000\u0000\u0098\u0099\u0005\b\u0000\u0000"+
		"\u0099\u009a\u00036\u001b\u0000\u009a\u009b\u0005\u0003\u0000\u0000\u009b"+
		"\u0015\u0001\u0000\u0000\u0000\u009c\u009d\u0005\t\u0000\u0000\u009d\u009e"+
		"\u0005\u0005\u0000\u0000\u009e\u009f\u00036\u001b\u0000\u009f\u00a0\u0005"+
		"\u0006\u0000\u0000\u00a0\u00a1\u0003\u001c\u000e\u0000\u00a1\u0017\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0003\u0004\u0002\u0000\u00a3\u00a4\u0005"+
		"\n\u0000\u0000\u00a4\u00a5\u00036\u001b\u0000\u00a5\u00a6\u0005\u0003"+
		"\u0000\u0000\u00a6\u0019\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u000b"+
		"\u0000\u0000\u00a8\u00a9\u0005\u0005\u0000\u0000\u00a9\u00aa\u00036\u001b"+
		"\u0000\u00aa\u00ab\u0005\u0006\u0000\u0000\u00ab\u00ae\u0003\u001c\u000e"+
		"\u0000\u00ac\u00ad\u0005\f\u0000\u0000\u00ad\u00af\u0003\u001c\u000e\u0000"+
		"\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000"+
		"\u00af\u001b\u0001\u0000\u0000\u0000\u00b0\u00ba\u0003\u0012\t\u0000\u00b1"+
		"\u00ba\u0003\u0014\n\u0000\u00b2\u00ba\u0003\u0016\u000b\u0000\u00b3\u00ba"+
		"\u0003\u0018\f\u0000\u00b4\u00ba\u0003\u0004\u0002\u0000\u00b5\u00ba\u0003"+
		"\u001a\r\u0000\u00b6\u00b7\u0003D\"\u0000\u00b7\u00b8\u0005\u0003\u0000"+
		"\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b1\u0001\u0000\u0000\u0000\u00b9\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b3\u0001\u0000\u0000\u0000\u00b9\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b5\u0001\u0000\u0000\u0000\u00b9\u00b6\u0001\u0000\u0000"+
		"\u0000\u00ba\u001d\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u0011\u0000"+
		"\u0000\u00bc\u00bd\u0005\r\u0000\u0000\u00bd\u00ca\u0005*\u0000\u0000"+
		"\u00be\u00bf\u0005\u0011\u0000\u0000\u00bf\u00c1\u0005\r\u0000\u0000\u00c0"+
		"\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005*\u0000\u0000\u00c3\u00c5"+
		"\u0005\r\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00ca\u0005"+
		"*\u0000\u0000\u00c9\u00bb\u0001\u0000\u0000\u0000\u00c9\u00c0\u0001\u0000"+
		"\u0000\u0000\u00ca\u001f\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005*\u0000"+
		"\u0000\u00cc!\u0001\u0000\u0000\u0000\u00cd\u00ce\u0003H$\u0000\u00ce"+
		"\u00cf\u00036\u001b\u0000\u00cf#\u0001\u0000\u0000\u0000\u00d0\u00d1\u0007"+
		"\u0000\u0000\u0000\u00d1%\u0001\u0000\u0000\u0000\u00d2\u00d4\u0005\u000e"+
		"\u0000\u0000\u00d3\u00d5\u0005,\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0005\u000e\u0000\u0000\u00d7\'\u0001\u0000\u0000\u0000"+
		"\u00d8\u00dc\u0005\u000f\u0000\u0000\u00d9\u00db\u0005,\u0000\u0000\u00da"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u00de\u0001\u0000\u0000\u0000\u00dc"+
		"\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd"+
		"\u00df\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0005\u000f\u0000\u0000\u00e0)\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u0005\u0005\u0000\u0000\u00e2\u00e3\u00036\u001b\u0000\u00e3\u00e4\u0005"+
		"\u0006\u0000\u0000\u00e4+\u0001\u0000\u0000\u0000\u00e5\u00e8\u0003.\u0017"+
		"\u0000\u00e6\u00e8\u00034\u001a\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8-\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u00038\u001c\u0000\u00ea\u00eb\u0003J%\u0000\u00eb\u00ec\u0003"+
		"0\u0018\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed\u00ef\u00030\u0018"+
		"\u0000\u00ee\u00e9\u0001\u0000\u0000\u0000\u00ee\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ef/\u0001\u0000\u0000\u0000\u00f0\u00f1\u0006\u0018\uffff\uffff"+
		"\u0000\u00f1\u00f2\u00032\u0019\u0000\u00f2\u00f9\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f4\n\u0002\u0000\u0000\u00f4\u00f5\u0003J%\u0000\u00f5\u00f6"+
		"\u00032\u0019\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa1\u0001\u0000"+
		"\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u0105\u0005+\u0000"+
		"\u0000\u00fd\u0105\u0003 \u0010\u0000\u00fe\u0105\u0003\u001e\u000f\u0000"+
		"\u00ff\u0105\u0003>\u001f\u0000\u0100\u0101\u0005\u0005\u0000\u0000\u0101"+
		"\u0102\u0003.\u0017\u0000\u0102\u0103\u0005\u0006\u0000\u0000\u0103\u0105"+
		"\u0001\u0000\u0000\u0000\u0104\u00fc\u0001\u0000\u0000\u0000\u0104\u00fd"+
		"\u0001\u0000\u0000\u0000\u0104\u00fe\u0001\u0000\u0000\u0000\u0104\u00ff"+
		"\u0001\u0000\u0000\u0000\u0104\u0100\u0001\u0000\u0000\u0000\u01053\u0001"+
		"\u0000\u0000\u0000\u0106\u0107\u00038\u001c\u0000\u0107\u0108\u0003N\'"+
		"\u0000\u0108\u0109\u0003*\u0015\u0000\u01095\u0001\u0000\u0000\u0000\u010a"+
		"\u010d\u00038\u001c\u0000\u010b\u010d\u0003,\u0016\u0000\u010c\u010a\u0001"+
		"\u0000\u0000\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010d7\u0001\u0000"+
		"\u0000\u0000\u010e\u011a\u0005\u0011\u0000\u0000\u010f\u011a\u0005\u0012"+
		"\u0000\u0000\u0110\u011a\u0003 \u0010\u0000\u0111\u011a\u0003\u001e\u000f"+
		"\u0000\u0112\u011a\u0003\"\u0011\u0000\u0113\u011a\u0003$\u0012\u0000"+
		"\u0114\u011a\u0003&\u0013\u0000\u0115\u011a\u0003(\u0014\u0000\u0116\u011a"+
		"\u0005\u0013\u0000\u0000\u0117\u011a\u0003*\u0015\u0000\u0118\u011a\u0003"+
		"D\"\u0000\u0119\u010e\u0001\u0000\u0000\u0000\u0119\u010f\u0001\u0000"+
		"\u0000\u0000\u0119\u0110\u0001\u0000\u0000\u0000\u0119\u0111\u0001\u0000"+
		"\u0000\u0000\u0119\u0112\u0001\u0000\u0000\u0000\u0119\u0113\u0001\u0000"+
		"\u0000\u0000\u0119\u0114\u0001\u0000\u0000\u0000\u0119\u0115\u0001\u0000"+
		"\u0000\u0000\u0119\u0116\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000"+
		"\u0000\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a9\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0003B!\u0000\u011c\u011d\u0003F#\u0000\u011d\u0122"+
		"\u0001\u0000\u0000\u0000\u011e\u011f\u0003F#\u0000\u011f\u0120\u0003B"+
		"!\u0000\u0120\u0122\u0001\u0000\u0000\u0000\u0121\u011b\u0001\u0000\u0000"+
		"\u0000\u0121\u011e\u0001\u0000\u0000\u0000\u0122;\u0001\u0000\u0000\u0000"+
		"\u0123\u0124\u0005\u0010\u0000\u0000\u0124\u0125\u0003\u0006\u0003\u0000"+
		"\u0125\u0127\u0005\u0005\u0000\u0000\u0126\u0128\u0003P(\u0000\u0127\u0126"+
		"\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u0129"+
		"\u0001\u0000\u0000\u0000\u0129\u012a\u0005\u0006\u0000\u0000\u012a=\u0001"+
		"\u0000\u0000\u0000\u012b\u012c\u0003 \u0010\u0000\u012c\u012d\u0005\r"+
		"\u0000\u0000\u012d\u012f\u0001\u0000\u0000\u0000\u012e\u012b\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000"+
		"\u0000\u0000\u0130\u0131\u0005*\u0000\u0000\u0131\u0133\u0005\u0005\u0000"+
		"\u0000\u0132\u0134\u0003P(\u0000\u0133\u0132\u0001\u0000\u0000\u0000\u0133"+
		"\u0134\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135"+
		"\u0136\u0005\u0006\u0000\u0000\u0136?\u0001\u0000\u0000\u0000\u0137\u0138"+
		"\u0003B!\u0000\u0138\u0139\u0005\n\u0000\u0000\u0139\u013a\u00036\u001b"+
		"\u0000\u013aA\u0001\u0000\u0000\u0000\u013b\u013e\u0005*\u0000\u0000\u013c"+
		"\u013e\u0003\u001e\u000f\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013d"+
		"\u013c\u0001\u0000\u0000\u0000\u013eC\u0001\u0000\u0000\u0000\u013f\u0144"+
		"\u0003:\u001d\u0000\u0140\u0144\u0003@ \u0000\u0141\u0144\u0003<\u001e"+
		"\u0000\u0142\u0144\u0003>\u001f\u0000\u0143\u013f\u0001\u0000\u0000\u0000"+
		"\u0143\u0140\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000"+
		"\u0143\u0142\u0001\u0000\u0000\u0000\u0144E\u0001\u0000\u0000\u0000\u0145"+
		"\u0146\u0007\u0001\u0000\u0000\u0146G\u0001\u0000\u0000\u0000\u0147\u0148"+
		"\u0007\u0002\u0000\u0000\u0148I\u0001\u0000\u0000\u0000\u0149\u014a\u0007"+
		"\u0003\u0000\u0000\u014aK\u0001\u0000\u0000\u0000\u014b\u014c\u0007\u0004"+
		"\u0000\u0000\u014cM\u0001\u0000\u0000\u0000\u014d\u014e\u0007\u0005\u0000"+
		"\u0000\u014eO\u0001\u0000\u0000\u0000\u014f\u0154\u00036\u001b\u0000\u0150"+
		"\u0151\u0005\u0007\u0000\u0000\u0151\u0153\u00036\u001b\u0000\u0152\u0150"+
		"\u0001\u0000\u0000\u0000\u0153\u0156\u0001\u0000\u0000\u0000\u0154\u0152"+
		"\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155Q\u0001"+
		"\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u001cU_aow\u0081"+
		"\u008a\u0093\u00ae\u00b9\u00c0\u00c6\u00c9\u00d4\u00dc\u00e7\u00ee\u00f9"+
		"\u0104\u010c\u0119\u0121\u0127\u012e\u0133\u013d\u0143\u0154";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}