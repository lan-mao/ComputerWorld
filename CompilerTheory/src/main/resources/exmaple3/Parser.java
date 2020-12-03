package exmaple3;

/**

This class is a top-down, recursive-descent parser for the following syntactic categories:

<fun def list> --> <fun def> | <fun def> <fun def list>
<fun def> --> <header> "{" <exp> "}" 
<header> --> <fun name> <parameter list>
<fun name> --> <id> 
<parameter list> --> epsilon | <id> <parameter list> 
<exp> --> <id> | <int> | <foat> | <floatE> | <floatF> | "nil" | "(" <fun exp> ")" | "if" <exp> "then" <exp> "else" <exp>
<fun exp> --> <fun op> <exp list>
<fun op> --> <id> | "pair" | "first" | "second" | <arith op> | <bool op> | <comp op>
<arith op> --> + | - | * | /
<bool op> --> "or" | "and" | "not"
<comp op> --> "<" | "<=" | ">" | ">=" | "="
<exp list> --> epsilon | <exp> <exp list>
 
Note: "epsilon" denotes the empty string.
 
The definitions of the tokens are given in the lexical analyzer class file "LexAnalyzer.java". 

The following variables/functions of "IO"/"LexAnalyzer" classes are used:

static void display(String s)
static void displayln(String s)
static void setIO(String inFile, String outFile)
static void closeIO()

static void setLex()
static String t // holds an extracted token
static State state // the current state of the finite automaton
static int getToken() // extracts the next token

An explicit parse tree is constructed in the form of nested class objects.

The main function will display the parse tree in linearly indented form.
Each syntactic category name labeling a node is displayed on a separate line, 
prefixed with the integer i representing the node's depth and indented by i blanks. 

**/


public abstract class Parser extends LexAnalyzer
{
	static final EmptyParameterList emptyParameterList = new EmptyParameterList();
	static final Nil nil = new Nil();
	static final EmptyExpList emptyExpList = new EmptyExpList();
	static boolean syntaxErrorFound = false;


	public static FunDefList funDefList()
	
	// <fun def list> --> <fun def> | <fun def> <fun def list>
		
	{
		FunDef funDef = funDef();
		if ( state == State.Id ) // Function name is present.
		{
			FunDefList funDefList = funDefList();
			return new MultipleFunDef(funDef, funDefList);
		}
		else
			return funDef;
	}
	
	public static FunDef funDef()
	
	// <fun def> --> <header> "{" <exp> "}"
	
	{
		if ( state == State.Id ) // Function name is present.
		{
			Header header = header();
			if (state == State.LBrace )
			{
				getToken();
				Exp exp = exp();
				if ( state == State.RBrace )
				{
					getToken();
					return new FunDef(header, exp);
				}
				else
				{
					errorMsg(2);
					return null;
				}
			}
			else
			{
				errorMsg(1);
				return null;
			}
		}
		else
		{
			errorMsg(0);
			return null;
		}
	}

	public static Header header()
	
	// <header> --> <fun name> <parameter list>
	// <fun name> --> <id>
	
	{
		String funName = t;
		getToken();
		ParameterList parameterList = parameterList();
		return new Header(funName, parameterList);
	}

	public static ParameterList parameterList()
	
	// <parameter list> --> epsilon | <id> <parameter list>
	
	{
		if ( state == State.Id )
		{
			String id = t;
			getToken();
			ParameterList parameterList = parameterList();
			return new NonEmptyParameterList(id, parameterList);
		}
		else
			return emptyParameterList; // emptyParameterList is a static constant object.
	}
	
	public static Exp exp()
	
	// <exp> --> <id> | <int> | <float> | <floatE> | <floatF> | "nil" | "(" <fun exp> ")" | "if" <exp> "then" <exp> "else" <exp>
	
	{
		switch ( state )
		{
			case Id:
				Id id = new Id(t);
				getToken();				
				return id;
				
			case Int:
				Int intElem = new Int(Integer.parseInt(t));
				getToken();
				return intElem;
				
			case Float: case FloatE: case FloatF:
				Floatp floatElem = new Floatp(Float.parseFloat(t));
				getToken();
				return floatElem;

			case Keyword_nil:
				getToken();
				return nil;  // nil is a static constant object.
				
			case LParen:
				getToken();
				FunExp funExp = funExp();
				if ( state == State.RParen )
				{
					getToken();
					return funExp;
				}
				else 
				{
					errorMsg(3);
					return null;
				}
				
			case Keyword_if:
				getToken();
				Exp exp1 = exp();
				if ( state == State.Keyword_then )
				{
					getToken();
					Exp exp2 = exp();
					if ( state == State.Keyword_else )
					{
						getToken();
						Exp exp3 = exp();
						return new If(exp1, exp2, exp3);
					}
					else
						errorMsg(5);
				}
				else
					errorMsg(4);
				return null;
			
			default:
				errorMsg(6);
				return null;
		}
	}
	
	public static FunExp funExp()
	
	// <fun exp> --> <fun op> <exp list>
	// <fun op> --> <id> | "pair" | "first" | "second" | <arith op> | <bool op> | <comp op>
	// <arith op> --> + | - | * | /
	// <bool op> --> "or" | "and" | "not"
	// <comp op> --> "<" | "<=" | ">" | ">=" | "="
	
	{	
		if ( state == State.Id )
		{
			Id id = new Id(t);
			getToken();
			ExpList expList = expList();
			return new FunCall(id, expList);
		}
		else if ( state.isPairOp() || state.isArithOp() || state.isBoolOp() || state.isCompOp() )
		{
			State opState = state;
			getToken();
			ExpList expList = expList();
			switch ( opState )
			{
				case Keyword_pair:   return new Pair(expList);
				case Keyword_first:  return new First(expList);
				case Keyword_second: return new Second(expList);
				case Add:            return new AddE(expList);
				case Sub:            return new SubE(expList);
				case Mul:            return new MulE(expList);
				case Div:            return new DivE(expList);
				case Keyword_or:     return new OrE(expList);
				case Keyword_and:    return new AndE(expList);
				case Keyword_not:    return new NotE(expList);
				case Lt:             return new LtE(expList);
				case Le:             return new LeE(expList);
				case Gt:             return new GtE(expList);
				case Ge:             return new GeE(expList);
				default:             return new EqE(expList); // case Eq
			}
		}
		else
		{
			errorMsg(7);
			return null;
		}
	}

	public static boolean beginsExp()
	{
		return
		state.compareTo(State.Id) >= 0 && state.compareTo(State.FloatF) <= 0 ||
		state == State.LParen || state == State.Keyword_if || state == State.Keyword_nil
		;
	}
	
	public static ExpList expList()
	
	// <exp list> --> epsilon | <exp> <exp list>
	
	{
		if ( beginsExp() )
		{
			Exp exp = exp();
			ExpList expList = expList();
			return new NonEmptyExpList(exp, expList);
		}
		else
			return emptyExpList; // emptyExpList is a static constant object.
	}
	
	public static void errorMsg(int i)
	{
		syntaxErrorFound = true;
		String msg = "";

		display(t + " : Syntax Error, unexpected symbol where ");

		switch( i )
		{
		case 0:	msg = "fun name expected"; break;
		case 1:	msg = "{ expected"; break;							
		case 2: msg = "} expected"; break;
		case 3: msg = ") expected"; break;
		case 4:	msg = "then expected"; break;				
		case 5:	msg = "else expected"; break;				
		case 6:	msg = "id, int, float, nil, (, or if expected"; break;
		case 7:	msg = "fun name, pair, first, second, arith op, bool op, or comp op expected"; break;
		}

		displayln(msg);
		return;
	}
		
	public static void main(String argv[])
	{
		// argv[0]: input file containing a string of <fun def list>
		// argv[1]: output file displaying the parse tree or error messages

		setIO( argv[0], argv[1] );
		setLex();

		getToken();
		FunDefList funDefList = funDefList();
		if ( ! t.isEmpty() )
			errorMsg(0);
		else if ( ! syntaxErrorFound )
			funDefList.printParseTree("");
		
		closeIO();
	}
}
