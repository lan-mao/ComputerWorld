package exmaple4;

import java.util.*;

final class Int extends Exp
{
	int intElem;
	
	Int(int i)
	{
		intElem = i;
	}
	
	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " " + intElem);
	}
	
	Val Eval(HashMap<String, Val> state)
	{
		return new IntVal(intElem);
	}
}