// Generated from crux/pt/Crux.g4 by ANTLR 4.7.2
package crux.pt;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CruxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		And=1, Or=2, Not=3, If=4, Else=5, For=6, Break=7, SemiColon=8, Return=9, 
		OpenParen=10, CloseParen=11, OpenBracket=12, CloseBracket=13, OpenBrace=14, 
		CloseBrace=15, Add=16, Sub=17, Mul=18, Div=19, GreaterEqual=20, LesserEqual=21, 
		NotEqual=22, Equal=23, GreaterThan=24, LessThan=25, Assign=26, Comma=27, 
		Integer=28, True=29, False=30, Identifier=31, WhiteSpaces=32, Comment=33;
	public static final int
		RULE_program = 0, RULE_declList = 1, RULE_decl = 2, RULE_varDecl = 3, 
		RULE_type = 4, RULE_literal = 5, RULE_designator = 6, RULE_op0 = 7, RULE_op1 = 8, 
		RULE_op2 = 9, RULE_expr0 = 10, RULE_expr1 = 11, RULE_expr2 = 12, RULE_expr3 = 13, 
		RULE_callExpr = 14, RULE_exprList = 15, RULE_param = 16, RULE_paramList = 17, 
		RULE_arrayDecl = 18, RULE_functionDefn = 19, RULE_assignStmt = 20, RULE_assignStmtNoSemi = 21, 
		RULE_callStmt = 22, RULE_ifStmt = 23, RULE_forStmt = 24, RULE_breakStmt = 25, 
		RULE_returnStmt = 26, RULE_stmt = 27, RULE_stmtList = 28, RULE_stmtBlock = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declList", "decl", "varDecl", "type", "literal", "designator", 
			"op0", "op1", "op2", "expr0", "expr1", "expr2", "expr3", "callExpr", 
			"exprList", "param", "paramList", "arrayDecl", "functionDefn", "assignStmt", 
			"assignStmtNoSemi", "callStmt", "ifStmt", "forStmt", "breakStmt", "returnStmt", 
			"stmt", "stmtList", "stmtBlock"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'&&'", "'||'", "'!'", "'if'", "'else'", "'for'", "'break'", "';'", 
			"'return'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'-'", "'*'", 
			"'/'", "'>='", "'<='", "'!='", "'=='", "'>'", "'<'", "'='", "','", null, 
			"'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "And", "Or", "Not", "If", "Else", "For", "Break", "SemiColon", 
			"Return", "OpenParen", "CloseParen", "OpenBracket", "CloseBracket", "OpenBrace", 
			"CloseBrace", "Add", "Sub", "Mul", "Div", "GreaterEqual", "LesserEqual", 
			"NotEqual", "Equal", "GreaterThan", "LessThan", "Assign", "Comma", "Integer", 
			"True", "False", "Identifier", "WhiteSpaces", "Comment"
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
	public String getGrammarFileName() { return "Crux.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CruxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public DeclListContext declList() {
			return getRuleContext(DeclListContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CruxParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			declList();
			setState(61);
			match(EOF);
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

	public static class DeclListContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitDeclList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclListContext declList() throws RecognitionException {
		DeclListContext _localctx = new DeclListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(63);
				decl();
				}
				}
				setState(68);
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

	public static class DeclContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ArrayDeclContext arrayDecl() {
			return getRuleContext(ArrayDeclContext.class,0);
		}
		public FunctionDefnContext functionDefn() {
			return getRuleContext(FunctionDefnContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				arrayDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				functionDefn();
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

	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CruxParser.Identifier, 0); }
		public TerminalNode SemiColon() { return getToken(CruxParser.SemiColon, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			type();
			setState(75);
			match(Identifier);
			setState(76);
			match(SemiColon);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CruxParser.Identifier, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(Identifier);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode Integer() { return getToken(CruxParser.Integer, 0); }
		public TerminalNode True() { return getToken(CruxParser.True, 0); }
		public TerminalNode False() { return getToken(CruxParser.False, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Integer) | (1L << True) | (1L << False))) != 0)) ) {
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

	public static class DesignatorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CruxParser.Identifier, 0); }
		public TerminalNode OpenBracket() { return getToken(CruxParser.OpenBracket, 0); }
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode CloseBracket() { return getToken(CruxParser.CloseBracket, 0); }
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitDesignator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_designator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(Identifier);
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(83);
				match(OpenBracket);
				setState(84);
				expr0();
				setState(85);
				match(CloseBracket);
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

	public static class Op0Context extends ParserRuleContext {
		public TerminalNode GreaterEqual() { return getToken(CruxParser.GreaterEqual, 0); }
		public TerminalNode LesserEqual() { return getToken(CruxParser.LesserEqual, 0); }
		public TerminalNode NotEqual() { return getToken(CruxParser.NotEqual, 0); }
		public TerminalNode Equal() { return getToken(CruxParser.Equal, 0); }
		public TerminalNode GreaterThan() { return getToken(CruxParser.GreaterThan, 0); }
		public TerminalNode LessThan() { return getToken(CruxParser.LessThan, 0); }
		public Op0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op0; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterOp0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitOp0(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitOp0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op0Context op0() throws RecognitionException {
		Op0Context _localctx = new Op0Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_op0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GreaterEqual) | (1L << LesserEqual) | (1L << NotEqual) | (1L << Equal) | (1L << GreaterThan) | (1L << LessThan))) != 0)) ) {
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

	public static class Op1Context extends ParserRuleContext {
		public TerminalNode Add() { return getToken(CruxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(CruxParser.Sub, 0); }
		public TerminalNode Or() { return getToken(CruxParser.Or, 0); }
		public Op1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterOp1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitOp1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitOp1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op1Context op1() throws RecognitionException {
		Op1Context _localctx = new Op1Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_op1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Or) | (1L << Add) | (1L << Sub))) != 0)) ) {
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

	public static class Op2Context extends ParserRuleContext {
		public TerminalNode Mul() { return getToken(CruxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(CruxParser.Div, 0); }
		public TerminalNode And() { return getToken(CruxParser.And, 0); }
		public Op2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterOp2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitOp2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitOp2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op2Context op2() throws RecognitionException {
		Op2Context _localctx = new Op2Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_op2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << And) | (1L << Mul) | (1L << Div))) != 0)) ) {
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

	public static class Expr0Context extends ParserRuleContext {
		public List<Expr1Context> expr1() {
			return getRuleContexts(Expr1Context.class);
		}
		public Expr1Context expr1(int i) {
			return getRuleContext(Expr1Context.class,i);
		}
		public Op0Context op0() {
			return getRuleContext(Op0Context.class,0);
		}
		public Expr0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr0; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterExpr0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitExpr0(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitExpr0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr0Context expr0() throws RecognitionException {
		Expr0Context _localctx = new Expr0Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			expr1(0);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GreaterEqual) | (1L << LesserEqual) | (1L << NotEqual) | (1L << Equal) | (1L << GreaterThan) | (1L << LessThan))) != 0)) {
				{
				setState(96);
				op0();
				setState(97);
				expr1(0);
				}
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

	public static class Expr1Context extends ParserRuleContext {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public Op1Context op1() {
			return getRuleContext(Op1Context.class,0);
		}
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitExpr1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitExpr1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr1Context expr1() throws RecognitionException {
		return expr1(0);
	}

	private Expr1Context expr1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr1Context _localctx = new Expr1Context(_ctx, _parentState);
		Expr1Context _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(102);
			expr2(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr1Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr1);
					setState(104);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(105);
					op1();
					setState(106);
					expr2(0);
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class Expr2Context extends ParserRuleContext {
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Op2Context op2() {
			return getRuleContext(Op2Context.class,0);
		}
		public Expr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterExpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitExpr2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitExpr2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr2Context expr2() throws RecognitionException {
		return expr2(0);
	}

	private Expr2Context expr2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr2Context _localctx = new Expr2Context(_ctx, _parentState);
		Expr2Context _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(114);
			expr3();
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr2Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr2);
					setState(116);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(117);
					op2();
					setState(118);
					expr3();
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class Expr3Context extends ParserRuleContext {
		public TerminalNode Not() { return getToken(CruxParser.Not, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public TerminalNode OpenParen() { return getToken(CruxParser.OpenParen, 0); }
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode CloseParen() { return getToken(CruxParser.CloseParen, 0); }
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public CallExprContext callExpr() {
			return getRuleContext(CallExprContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Expr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterExpr3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitExpr3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitExpr3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr3Context expr3() throws RecognitionException {
		Expr3Context _localctx = new Expr3Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr3);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(Not);
				setState(126);
				expr3();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(OpenParen);
				setState(128);
				expr0();
				setState(129);
				match(CloseParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				designator();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				callExpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				literal();
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

	public static class CallExprContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CruxParser.Identifier, 0); }
		public TerminalNode OpenParen() { return getToken(CruxParser.OpenParen, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(CruxParser.CloseParen, 0); }
		public CallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallExprContext callExpr() throws RecognitionException {
		CallExprContext _localctx = new CallExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_callExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(Identifier);
			setState(137);
			match(OpenParen);
			setState(138);
			exprList();
			setState(139);
			match(CloseParen);
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

	public static class ExprListContext extends ParserRuleContext {
		public List<Expr0Context> expr0() {
			return getRuleContexts(Expr0Context.class);
		}
		public Expr0Context expr0(int i) {
			return getRuleContext(Expr0Context.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CruxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CruxParser.Comma, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Not) | (1L << OpenParen) | (1L << Integer) | (1L << True) | (1L << False) | (1L << Identifier))) != 0)) {
				{
				setState(141);
				expr0();
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(142);
					match(Comma);
					setState(143);
					expr0();
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CruxParser.Identifier, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			type();
			setState(152);
			match(Identifier);
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

	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CruxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CruxParser.Comma, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(154);
				param();
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(155);
					match(Comma);
					setState(156);
					param();
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class ArrayDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CruxParser.Identifier, 0); }
		public TerminalNode OpenBracket() { return getToken(CruxParser.OpenBracket, 0); }
		public TerminalNode Integer() { return getToken(CruxParser.Integer, 0); }
		public TerminalNode CloseBracket() { return getToken(CruxParser.CloseBracket, 0); }
		public TerminalNode SemiColon() { return getToken(CruxParser.SemiColon, 0); }
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitArrayDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrayDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			type();
			setState(165);
			match(Identifier);
			setState(166);
			match(OpenBracket);
			setState(167);
			match(Integer);
			setState(168);
			match(CloseBracket);
			setState(169);
			match(SemiColon);
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

	public static class FunctionDefnContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CruxParser.Identifier, 0); }
		public TerminalNode OpenParen() { return getToken(CruxParser.OpenParen, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(CruxParser.CloseParen, 0); }
		public StmtBlockContext stmtBlock() {
			return getRuleContext(StmtBlockContext.class,0);
		}
		public FunctionDefnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterFunctionDefn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitFunctionDefn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitFunctionDefn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefnContext functionDefn() throws RecognitionException {
		FunctionDefnContext _localctx = new FunctionDefnContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionDefn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			type();
			setState(172);
			match(Identifier);
			setState(173);
			match(OpenParen);
			setState(174);
			paramList();
			setState(175);
			match(CloseParen);
			setState(176);
			stmtBlock();
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

	public static class AssignStmtContext extends ParserRuleContext {
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CruxParser.Assign, 0); }
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CruxParser.SemiColon, 0); }
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			designator();
			setState(179);
			match(Assign);
			setState(180);
			expr0();
			setState(181);
			match(SemiColon);
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

	public static class AssignStmtNoSemiContext extends ParserRuleContext {
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CruxParser.Assign, 0); }
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public AssignStmtNoSemiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmtNoSemi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterAssignStmtNoSemi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitAssignStmtNoSemi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitAssignStmtNoSemi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtNoSemiContext assignStmtNoSemi() throws RecognitionException {
		AssignStmtNoSemiContext _localctx = new AssignStmtNoSemiContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignStmtNoSemi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			designator();
			setState(184);
			match(Assign);
			setState(185);
			expr0();
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

	public static class CallStmtContext extends ParserRuleContext {
		public CallExprContext callExpr() {
			return getRuleContext(CallExprContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CruxParser.SemiColon, 0); }
		public CallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitCallStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallStmtContext callStmt() throws RecognitionException {
		CallStmtContext _localctx = new CallStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_callStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			callExpr();
			setState(188);
			match(SemiColon);
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(CruxParser.If, 0); }
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public List<StmtBlockContext> stmtBlock() {
			return getRuleContexts(StmtBlockContext.class);
		}
		public StmtBlockContext stmtBlock(int i) {
			return getRuleContext(StmtBlockContext.class,i);
		}
		public TerminalNode Else() { return getToken(CruxParser.Else, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(If);
			setState(191);
			expr0();
			setState(192);
			stmtBlock();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(193);
				match(Else);
				setState(194);
				stmtBlock();
				}
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

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(CruxParser.For, 0); }
		public TerminalNode OpenParen() { return getToken(CruxParser.OpenParen, 0); }
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CruxParser.SemiColon, 0); }
		public AssignStmtNoSemiContext assignStmtNoSemi() {
			return getRuleContext(AssignStmtNoSemiContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(CruxParser.CloseParen, 0); }
		public StmtBlockContext stmtBlock() {
			return getRuleContext(StmtBlockContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(For);
			setState(198);
			match(OpenParen);
			setState(199);
			assignStmt();
			setState(200);
			expr0();
			setState(201);
			match(SemiColon);
			setState(202);
			assignStmtNoSemi();
			setState(203);
			match(CloseParen);
			setState(204);
			stmtBlock();
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

	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(CruxParser.Break, 0); }
		public TerminalNode SemiColon() { return getToken(CruxParser.SemiColon, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitBreakStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(Break);
			setState(207);
			match(SemiColon);
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(CruxParser.Return, 0); }
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CruxParser.SemiColon, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(Return);
			setState(210);
			expr0();
			setState(211);
			match(SemiColon);
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

	public static class StmtContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public CallStmtContext callStmt() {
			return getRuleContext(CallStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_stmt);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				callStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				assignStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(217);
				forStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(218);
				breakStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				returnStmt();
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

	public static class StmtListContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitStmtList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitStmtList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_stmtList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << For) | (1L << Break) | (1L << Return) | (1L << Identifier))) != 0)) {
				{
				{
				setState(222);
				stmt();
				}
				}
				setState(227);
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

	public static class StmtBlockContext extends ParserRuleContext {
		public TerminalNode OpenBrace() { return getToken(CruxParser.OpenBrace, 0); }
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public TerminalNode CloseBrace() { return getToken(CruxParser.CloseBrace, 0); }
		public StmtBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).enterStmtBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CruxListener ) ((CruxListener)listener).exitStmtBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CruxVisitor ) return ((CruxVisitor<? extends T>)visitor).visitStmtBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtBlockContext stmtBlock() throws RecognitionException {
		StmtBlockContext _localctx = new StmtBlockContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_stmtBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(OpenBrace);
			setState(229);
			stmtList();
			setState(230);
			match(CloseBrace);
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
			return expr1_sempred((Expr1Context)_localctx, predIndex);
		case 12:
			return expr2_sempred((Expr2Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr1_sempred(Expr1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr2_sempred(Expr2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\3\7\3C\n\3\f\3\16\3F\13\3\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\bZ\n\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\5\ff\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\ro\n\r\f\r\16"+
		"\rr\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16{\n\16\f\16\16\16~\13"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0089\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u0093\n\21\f\21\16\21\u0096\13"+
		"\21\5\21\u0098\n\21\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u00a0\n\23\f\23"+
		"\16\23\u00a3\13\23\5\23\u00a5\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u00c6\n\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00df\n\35\3\36\7\36\u00e2"+
		"\n\36\f\36\16\36\u00e5\13\36\3\37\3\37\3\37\3\37\3\37\2\4\30\32 \2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\6\3\2\36 "+
		"\3\2\26\33\4\2\4\4\22\23\4\2\3\3\24\25\2\u00e3\2>\3\2\2\2\4D\3\2\2\2\6"+
		"J\3\2\2\2\bL\3\2\2\2\nP\3\2\2\2\fR\3\2\2\2\16T\3\2\2\2\20[\3\2\2\2\22"+
		"]\3\2\2\2\24_\3\2\2\2\26a\3\2\2\2\30g\3\2\2\2\32s\3\2\2\2\34\u0088\3\2"+
		"\2\2\36\u008a\3\2\2\2 \u0097\3\2\2\2\"\u0099\3\2\2\2$\u00a4\3\2\2\2&\u00a6"+
		"\3\2\2\2(\u00ad\3\2\2\2*\u00b4\3\2\2\2,\u00b9\3\2\2\2.\u00bd\3\2\2\2\60"+
		"\u00c0\3\2\2\2\62\u00c7\3\2\2\2\64\u00d0\3\2\2\2\66\u00d3\3\2\2\28\u00de"+
		"\3\2\2\2:\u00e3\3\2\2\2<\u00e6\3\2\2\2>?\5\4\3\2?@\7\2\2\3@\3\3\2\2\2"+
		"AC\5\6\4\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\5\3\2\2\2FD\3\2\2"+
		"\2GK\5\b\5\2HK\5&\24\2IK\5(\25\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2K\7\3\2"+
		"\2\2LM\5\n\6\2MN\7!\2\2NO\7\n\2\2O\t\3\2\2\2PQ\7!\2\2Q\13\3\2\2\2RS\t"+
		"\2\2\2S\r\3\2\2\2TY\7!\2\2UV\7\16\2\2VW\5\26\f\2WX\7\17\2\2XZ\3\2\2\2"+
		"YU\3\2\2\2YZ\3\2\2\2Z\17\3\2\2\2[\\\t\3\2\2\\\21\3\2\2\2]^\t\4\2\2^\23"+
		"\3\2\2\2_`\t\5\2\2`\25\3\2\2\2ae\5\30\r\2bc\5\20\t\2cd\5\30\r\2df\3\2"+
		"\2\2eb\3\2\2\2ef\3\2\2\2f\27\3\2\2\2gh\b\r\1\2hi\5\32\16\2ip\3\2\2\2j"+
		"k\f\3\2\2kl\5\22\n\2lm\5\32\16\2mo\3\2\2\2nj\3\2\2\2or\3\2\2\2pn\3\2\2"+
		"\2pq\3\2\2\2q\31\3\2\2\2rp\3\2\2\2st\b\16\1\2tu\5\34\17\2u|\3\2\2\2vw"+
		"\f\3\2\2wx\5\24\13\2xy\5\34\17\2y{\3\2\2\2zv\3\2\2\2{~\3\2\2\2|z\3\2\2"+
		"\2|}\3\2\2\2}\33\3\2\2\2~|\3\2\2\2\177\u0080\7\5\2\2\u0080\u0089\5\34"+
		"\17\2\u0081\u0082\7\f\2\2\u0082\u0083\5\26\f\2\u0083\u0084\7\r\2\2\u0084"+
		"\u0089\3\2\2\2\u0085\u0089\5\16\b\2\u0086\u0089\5\36\20\2\u0087\u0089"+
		"\5\f\7\2\u0088\177\3\2\2\2\u0088\u0081\3\2\2\2\u0088\u0085\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\35\3\2\2\2\u008a\u008b\7!\2\2"+
		"\u008b\u008c\7\f\2\2\u008c\u008d\5 \21\2\u008d\u008e\7\r\2\2\u008e\37"+
		"\3\2\2\2\u008f\u0094\5\26\f\2\u0090\u0091\7\35\2\2\u0091\u0093\5\26\f"+
		"\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u008f\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098!\3\2\2\2\u0099\u009a\5\n\6\2\u009a\u009b\7!\2\2\u009b"+
		"#\3\2\2\2\u009c\u00a1\5\"\22\2\u009d\u009e\7\35\2\2\u009e\u00a0\5\"\22"+
		"\2\u009f\u009d\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u009c\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5%\3\2\2\2\u00a6\u00a7\5\n\6\2\u00a7\u00a8\7!\2\2\u00a8"+
		"\u00a9\7\16\2\2\u00a9\u00aa\7\36\2\2\u00aa\u00ab\7\17\2\2\u00ab\u00ac"+
		"\7\n\2\2\u00ac\'\3\2\2\2\u00ad\u00ae\5\n\6\2\u00ae\u00af\7!\2\2\u00af"+
		"\u00b0\7\f\2\2\u00b0\u00b1\5$\23\2\u00b1\u00b2\7\r\2\2\u00b2\u00b3\5<"+
		"\37\2\u00b3)\3\2\2\2\u00b4\u00b5\5\16\b\2\u00b5\u00b6\7\34\2\2\u00b6\u00b7"+
		"\5\26\f\2\u00b7\u00b8\7\n\2\2\u00b8+\3\2\2\2\u00b9\u00ba\5\16\b\2\u00ba"+
		"\u00bb\7\34\2\2\u00bb\u00bc\5\26\f\2\u00bc-\3\2\2\2\u00bd\u00be\5\36\20"+
		"\2\u00be\u00bf\7\n\2\2\u00bf/\3\2\2\2\u00c0\u00c1\7\6\2\2\u00c1\u00c2"+
		"\5\26\f\2\u00c2\u00c5\5<\37\2\u00c3\u00c4\7\7\2\2\u00c4\u00c6\5<\37\2"+
		"\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\61\3\2\2\2\u00c7\u00c8"+
		"\7\b\2\2\u00c8\u00c9\7\f\2\2\u00c9\u00ca\5*\26\2\u00ca\u00cb\5\26\f\2"+
		"\u00cb\u00cc\7\n\2\2\u00cc\u00cd\5,\27\2\u00cd\u00ce\7\r\2\2\u00ce\u00cf"+
		"\5<\37\2\u00cf\63\3\2\2\2\u00d0\u00d1\7\t\2\2\u00d1\u00d2\7\n\2\2\u00d2"+
		"\65\3\2\2\2\u00d3\u00d4\7\13\2\2\u00d4\u00d5\5\26\f\2\u00d5\u00d6\7\n"+
		"\2\2\u00d6\67\3\2\2\2\u00d7\u00df\5\b\5\2\u00d8\u00df\5.\30\2\u00d9\u00df"+
		"\5*\26\2\u00da\u00df\5\60\31\2\u00db\u00df\5\62\32\2\u00dc\u00df\5\64"+
		"\33\2\u00dd\u00df\5\66\34\2\u00de\u00d7\3\2\2\2\u00de\u00d8\3\2\2\2\u00de"+
		"\u00d9\3\2\2\2\u00de\u00da\3\2\2\2\u00de\u00db\3\2\2\2\u00de\u00dc\3\2"+
		"\2\2\u00de\u00dd\3\2\2\2\u00df9\3\2\2\2\u00e0\u00e2\58\35\2\u00e1\u00e0"+
		"\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		";\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\7\20\2\2\u00e7\u00e8\5:\36\2"+
		"\u00e8\u00e9\7\21\2\2\u00e9=\3\2\2\2\20DJYep|\u0088\u0094\u0097\u00a1"+
		"\u00a4\u00c5\u00de\u00e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}