package exmaple3; /**
 
This class is a lexical analyzer for the 18 token categories <id> through <RBrace> defined by:

<letter> --> a | b | ... | z | A | B | ... | Z
<digit> --> 0 | 1 | ... | 9
<id> --> <letter> { <letter> | <digit> }
<int> --> [+|-] {<digit>}+
<float> --> [+|-] ( {<digit>}+ "." {<digit>} | "." {<digit>}+ )
<floatE> --> (<int> | <float>) (e|E) [+|-] {<digit>}+
<floatF> --> (<int> | <float> | <floatE>) ("f" | "F")
<add> --> +
<sub> --> -
<mul> --> *
<div> --> /
<lt> --> <
<le> --> "<="
<gt> --> >
<ge> --> ">="
<eq> --> =
<LParen> --> (
<RParen> --> )
<LBrace> --> { 
<RBrace> --> } 

This class implements a DFA accepting the above tokens.
The DFA states are represented by the Enum type "State".
The DFA has 18 final and 4 non-final states represented by enum-type literals.

There are also 10 special states for the keywords:

  if, then, else, or, and, not, pair, first, second, nil

The keywords are initially extracted as identifiers.
The keywordCheck() function checks if the extracted token is a keyword,
and if so, moves the DFA to the corresponding special state.

The function "driver" operates the DFA. 
The array "nextState" returns the next state given the current state and the input character.

To recognize a different token set, modify the following:

  enum class "State"
  size of array "nextState"
  functions "setNextState", "setKeywordMap"

The functions "driver", "getToken", "setLex" remain the same.

**/


import java.util.HashMap;

public abstract class LexAnalyzer extends IO
{

	// The following variables of "IO" class are used:

	// static int a; the current input character
	// static char c; used to convert the variable "a" to the char type whenever necessary

	public static String t; // holds an extracted token
	public static State state; // the current state of the DFA

	private static State nextState[][] = new State[22][128];
 
          // This array implements the state transition function State x (ASCII char set) --> State.
          // The state argument is converted to its ordinal number used as
          // the first array index from 0 through 21. 

	private static HashMap<String, State> keywordMap = new HashMap<String, State>();

	private static void setKeywordMap()
	{
		keywordMap.put("if",     State.Keyword_if);
		keywordMap.put("then",   State.Keyword_then);
		keywordMap.put("else",   State.Keyword_else);
		keywordMap.put("or",     State.Keyword_or);
		keywordMap.put("and",    State.Keyword_and);
		keywordMap.put("not",    State.Keyword_not);
		keywordMap.put("pair",   State.Keyword_pair);
		keywordMap.put("first",  State.Keyword_first);
		keywordMap.put("second", State.Keyword_second);
		keywordMap.put("nil",    State.Keyword_nil);
	}

	private static int driver()

	// This is the driver of the DFA. 
	// If a valid token is found, assigns it to "t" and returns 1.
	// If an invalid token is found, assigns it to "t" and returns 0.
	// If end-of-stream is reached without finding any non-whitespace character, returns -1.

	{
		State nextSt; // the next state of the DFA

		t = "";
		state = State.Start;

		if ( Character.isWhitespace((char) a) )
			a = getChar(); // get the next non-whitespace character
		if ( a == -1 ) // end-of-stream is reached
			return -1;

		while ( a != -1 ) // do the body if "a" is not end-of-stream
		{
			c = (char) a;
			nextSt = nextState[state.ordinal()][a];
			if ( nextSt == State.UNDEF ) // The DFA will halt.
			{
				if ( state.isFinal() )
					return 1; // valid token extracted
				else // "c" is an unexpected character
				{
					t = t+c;
					a = getNextChar();
					return 0; // invalid token found
				}
			}
			else // The DFA will go on.
			{
				state = nextSt;
				t = t+c;
				a = getNextChar();
			}
		}

		// end-of-stream is reached while a token is being extracted

		if ( state.isFinal() )
			return 1; // valid token extracted
		else
			return 0; // invalid token found
	}

	private static void setNextState()
	{
		for (int s = 0; s <= 21; s++ )
			for (int c = 0; c <= 127; c++ )
				nextState[s][c] = State.UNDEF;

		for (char c = 'A'; c <= 'Z'; c++)
		{
			nextState[State.Start     .ordinal()][c] = State.Id;
			nextState[State.Id        .ordinal()][c] = State.Id;
		}

		for (char c = 'a'; c <= 'z'; c++)
		{
			nextState[State.Start     .ordinal()][c] = State.Id;
			nextState[State.Id        .ordinal()][c] = State.Id;
		}

		for (char d = '0'; d <= '9'; d++)
		{
			nextState[State.Start      .ordinal()][d] = State.Int;
			nextState[State.Id         .ordinal()][d] = State.Id;
			nextState[State.Int        .ordinal()][d] = State.Int;
			nextState[State.Add        .ordinal()][d] = State.Int;
			nextState[State.Sub        .ordinal()][d] = State.Int;
			nextState[State.Dot        .ordinal()][d] = State.Float;
			nextState[State.Float      .ordinal()][d] = State.Float;
			nextState[State.E          .ordinal()][d] = State.FloatE;
			nextState[State.EPlusMinus .ordinal()][d] = State.FloatE;
			nextState[State.FloatE     .ordinal()][d] = State.FloatE;
		}

		nextState[State.Start.ordinal()]['+'] = State.Add;
		nextState[State.Start.ordinal()]['-'] = State.Sub;
		nextState[State.Start.ordinal()]['*'] = State.Mul;
		nextState[State.Start.ordinal()]['/'] = State.Div;
		nextState[State.Start.ordinal()]['<'] = State.Lt;
		nextState[State.Start.ordinal()]['>'] = State.Gt;
		nextState[State.Start.ordinal()]['='] = State.Eq;
		nextState[State.Start.ordinal()]['('] = State.LParen;
		nextState[State.Start.ordinal()][')'] = State.RParen;
		nextState[State.Start.ordinal()]['{'] = State.LBrace;
		nextState[State.Start.ordinal()]['}'] = State.RBrace;
		nextState[State.Start.ordinal()]['.'] = State.Dot;

		nextState[State.Lt .ordinal()]['='] = State.Le;
		nextState[State.Gt .ordinal()]['='] = State.Ge;
		
		nextState[State.Add.ordinal()]['.'] = State.Dot;
		nextState[State.Sub.ordinal()]['.'] = State.Dot;
		nextState[State.Int.ordinal()]['.'] = State.Float;
			
		nextState[State.Float.ordinal()]['e'] = state.E;
		nextState[State.Float.ordinal()]['E'] = state.E;
		nextState[State.Int  .ordinal()]['e'] = State.E;
		nextState[State.Int  .ordinal()]['E'] = State.E;
		
		nextState[State.E.ordinal()]['+'] = State.EPlusMinus;
		nextState[State.E.ordinal()]['-'] = State.EPlusMinus;
		
		nextState[State.Int   .ordinal()]['f'] = State.FloatF;
		nextState[State.Int   .ordinal()]['F'] = State.FloatF;
		nextState[State.Float .ordinal()]['f'] = State.FloatF;
		nextState[State.Float .ordinal()]['F'] = State.FloatF;
		nextState[State.FloatE.ordinal()]['f'] = State.FloatF;
		nextState[State.FloatE.ordinal()]['F'] = State.FloatF;
	}

	private static void keywordCheck()
	{
		State keywordState = keywordMap.get(t);
		if ( keywordState != null )
			state = keywordState;
	}

	public static void getToken()

	// Extract the next token using the driver of the DFA.
	// If an invalid token is found, issue an error message.

	{
		int i = driver();
		if ( state == State.Id )
			keywordCheck();
		else if ( i == 0 )
			displayln(t + " : Lexical Error, invalid token");
	}

	public static void setLex()

	// Sets the nextState array and keywordMap.

	{
		setNextState();
		setKeywordMap();
	}

	public static void main(String argv[])

	{
		// argv[0]: input file containing source code using tokens defined above
		// argv[1]: output file displaying a list of the tokens 

		setIO( argv[0], argv[1] );
		setLex();

		int i;

		while ( a != -1 ) // while "a" is not end-of-stream
		{
			i = driver(); // extract the next token
			if ( i == 1 )
			{
				if ( state == State.Id )
					keywordCheck();
				displayln( t+"   : "+state.toString() );
			}
			else if ( i == 0 )
				displayln( t+" : Lexical Error, invalid token");
		} 

		closeIO();
	}
} 
