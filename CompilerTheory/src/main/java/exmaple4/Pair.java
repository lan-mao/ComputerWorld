package exmaple4;

import java.util.*;

final class Pair extends FunExp
{	
	Pair(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "pair";
	}
	
	Val Eval(HashMap<String, Object> state)
	{
		return expList.pairEval(state);
	}
}