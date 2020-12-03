package exmaple4;

import java.util.*;

final class LtE extends FunExp
{	
	LtE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "<";
	}
	
	Val Eval(HashMap<String, Object> state)
	{
		return expList.ltEval(state);
	}
}