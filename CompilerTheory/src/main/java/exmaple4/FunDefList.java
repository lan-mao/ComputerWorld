package exmaple4;

import java.util.HashMap;

abstract class FunDefList
{
	void printParseTree(String indent)
	{
		FunDefList p = this;

		while ( p instanceof MultipleFunDef)
		{
			((MultipleFunDef)p).funDef.printParseTree(indent);
			p = ((MultipleFunDef)p).funDefList;
		}

		p.printParseTree(indent); // p is the last FunDef
	}

	/**
	 * 将函数信息存储到map结构中
	 * @return
	 */
	abstract HashMap<String, Val> saveFunction();
}