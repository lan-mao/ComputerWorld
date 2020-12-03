package exmaple4;

import java.util.*;

final class EqE extends FunExp
{	
	EqE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "=";
	}

	Val Eval(HashMap<String, Object> state)
	{
		return expList.eqEval(state);
	}
}