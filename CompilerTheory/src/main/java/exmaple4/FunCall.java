package exmaple4;

import java.util.*;

final class FunCall extends FunExp
{
	Id func;  // identifier "func" may be a variable or a user-defined function name
	
	FunCall(Id i, ExpList e)
	{
		func = i;
		expList = e;
	}

	String getFunOp()
	{
		return func.id;
	}
	
	Val Eval(HashMap<String, Object> state)
	{
		// You implement body code.
		//state中应该包含所有的函数信息
		//所有解析到的函数都应加入集合中
		//此处应该用于函数调用，此时应该传入数据列表
		//函数的执行应该是将变量值一个个替换的过程
		return null;
	}
}