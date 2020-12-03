package exmaple4;

import java.util.*;

final class Id extends Exp
{
	String id;
	
	Id(String s)
	{
		id = s;
	}
	
	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " " + id);
	}
	
	Val Eval(HashMap<String, Val> state)
	{
		// You implement body code.
		//此处应在map中查找对应的函数
		//此处保存的应该是变量名称
		//如果变量名称是一个函数，则递归的调用
		//todo:一个函数如何执行？？？

	}
}