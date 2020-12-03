package exmaple4;

import java.util.*;

final class AndE extends FunExp
{	
	AndE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "and";
	}

	Val Eval(HashMap<String, Object> state)
	{
		return expList.andEval(state);
	}
}