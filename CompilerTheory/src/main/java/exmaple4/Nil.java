package exmaple4;

import java.util.*;

final class Nil extends Exp
{
	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " nil");
	}
	
	Val Eval(HashMap<String, Val> state)
	{
		return NilVal.nilVal;
	}
}