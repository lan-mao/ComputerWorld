package exmaple4;

import java.util.*;

final class Second extends FunExp
{
	Second(ExpList e)
	{
		expList = e;
	}
	
	String getFunOp()
	{
		return "second";
	}
	
	Val Eval(HashMap<String, Val> state)
	{
		return expList.secondEval(state);	
	}
}