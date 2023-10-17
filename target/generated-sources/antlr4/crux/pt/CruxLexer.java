// Generated from crux/pt/Crux.g4 by ANTLR 4.7.2
package crux.pt;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CruxLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"And", "Or", "Not", "If", "Else", "For", "Break", "SemiColon", "Return", 
			"OpenParen", "CloseParen", "OpenBracket", "CloseBracket", "OpenBrace", 
			"CloseBrace", "Add", "Sub", "Mul", "Div", "GreaterEqual", "LesserEqual", 
			"NotEqual", "Equal", "GreaterThan", "LessThan", "Assign", "Comma", "Integer", 
			"True", "False", "Identifier", "WhiteSpaces", "Comment"
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


	public CruxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Crux.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00be\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\35\7\35\u0094\n\35\f\35\16\35\u0097\13\35\5\35\u0099\n\35\3"+
		"\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \7 \u00a8\n"+
		" \f \16 \u00ab\13 \3!\6!\u00ae\n!\r!\16!\u00af\3!\3!\3\"\3\"\3\"\3\"\7"+
		"\"\u00b8\n\"\f\"\16\"\u00bb\13\"\3\"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#\3\2\b\3\2\63;\3"+
		"\2\62;\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u00c2"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5H\3\2\2"+
		"\2\7K\3\2\2\2\tM\3\2\2\2\13P\3\2\2\2\rU\3\2\2\2\17Y\3\2\2\2\21_\3\2\2"+
		"\2\23a\3\2\2\2\25h\3\2\2\2\27j\3\2\2\2\31l\3\2\2\2\33n\3\2\2\2\35p\3\2"+
		"\2\2\37r\3\2\2\2!t\3\2\2\2#v\3\2\2\2%x\3\2\2\2\'z\3\2\2\2)|\3\2\2\2+\177"+
		"\3\2\2\2-\u0082\3\2\2\2/\u0085\3\2\2\2\61\u0088\3\2\2\2\63\u008a\3\2\2"+
		"\2\65\u008c\3\2\2\2\67\u008e\3\2\2\29\u0098\3\2\2\2;\u009a\3\2\2\2=\u009f"+
		"\3\2\2\2?\u00a5\3\2\2\2A\u00ad\3\2\2\2C\u00b3\3\2\2\2EF\7(\2\2FG\7(\2"+
		"\2G\4\3\2\2\2HI\7~\2\2IJ\7~\2\2J\6\3\2\2\2KL\7#\2\2L\b\3\2\2\2MN\7k\2"+
		"\2NO\7h\2\2O\n\3\2\2\2PQ\7g\2\2QR\7n\2\2RS\7u\2\2ST\7g\2\2T\f\3\2\2\2"+
		"UV\7h\2\2VW\7q\2\2WX\7t\2\2X\16\3\2\2\2YZ\7d\2\2Z[\7t\2\2[\\\7g\2\2\\"+
		"]\7c\2\2]^\7m\2\2^\20\3\2\2\2_`\7=\2\2`\22\3\2\2\2ab\7t\2\2bc\7g\2\2c"+
		"d\7v\2\2de\7w\2\2ef\7t\2\2fg\7p\2\2g\24\3\2\2\2hi\7*\2\2i\26\3\2\2\2j"+
		"k\7+\2\2k\30\3\2\2\2lm\7]\2\2m\32\3\2\2\2no\7_\2\2o\34\3\2\2\2pq\7}\2"+
		"\2q\36\3\2\2\2rs\7\177\2\2s \3\2\2\2tu\7-\2\2u\"\3\2\2\2vw\7/\2\2w$\3"+
		"\2\2\2xy\7,\2\2y&\3\2\2\2z{\7\61\2\2{(\3\2\2\2|}\7@\2\2}~\7?\2\2~*\3\2"+
		"\2\2\177\u0080\7>\2\2\u0080\u0081\7?\2\2\u0081,\3\2\2\2\u0082\u0083\7"+
		"#\2\2\u0083\u0084\7?\2\2\u0084.\3\2\2\2\u0085\u0086\7?\2\2\u0086\u0087"+
		"\7?\2\2\u0087\60\3\2\2\2\u0088\u0089\7@\2\2\u0089\62\3\2\2\2\u008a\u008b"+
		"\7>\2\2\u008b\64\3\2\2\2\u008c\u008d\7?\2\2\u008d\66\3\2\2\2\u008e\u008f"+
		"\7.\2\2\u008f8\3\2\2\2\u0090\u0099\7\62\2\2\u0091\u0095\t\2\2\2\u0092"+
		"\u0094\t\3\2\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u0090\3\2\2\2\u0098\u0091\3\2\2\2\u0099:\3\2\2\2\u009a\u009b\7v\2\2\u009b"+
		"\u009c\7t\2\2\u009c\u009d\7w\2\2\u009d\u009e\7g\2\2\u009e<\3\2\2\2\u009f"+
		"\u00a0\7h\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7u\2\2"+
		"\u00a3\u00a4\7g\2\2\u00a4>\3\2\2\2\u00a5\u00a9\t\4\2\2\u00a6\u00a8\t\5"+
		"\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa@\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\t\6\2\2"+
		"\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\b!\2\2\u00b2B\3\2\2\2\u00b3\u00b4"+
		"\7\61\2\2\u00b4\u00b5\7\61\2\2\u00b5\u00b9\3\2\2\2\u00b6\u00b8\n\7\2\2"+
		"\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\b\"\2\2\u00bd"+
		"D\3\2\2\2\b\2\u0095\u0098\u00a9\u00af\u00b9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}