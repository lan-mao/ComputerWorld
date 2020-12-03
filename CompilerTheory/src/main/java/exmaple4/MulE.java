package exmaple4;

import java.util.*;

final class MulE extends FunExp
{	
	MulE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "*";
	}
	
	Val Eval(HashMap<String, Object> state)
	{
		return expList.mulEval(state);
	}
}