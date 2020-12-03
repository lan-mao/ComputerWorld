package exmaple4;

import java.util.*;

final class Floatp extends Exp
{
	float floatElem;
	
	Floatp(float f)
	{
		floatElem = f;
	}
	
	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " " + floatElem);
	}
	
	Val Eval(HashMap<String, Val> state)
	{
		return new FloatVal(floatElem);
	}
}