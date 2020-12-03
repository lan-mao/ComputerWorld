package exmaple3;

abstract class FunDefList
{
	void printParseTree(String indent)
	{
		FunDefList p = this;

		while ( p instanceof MultipleFunDef )
		{
			((MultipleFunDef)p).funDef.printParseTree(indent);
			p = ((MultipleFunDef)p).funDefList;
		}

		p.printParseTree(indent); // p is the last FunDef
	}
}