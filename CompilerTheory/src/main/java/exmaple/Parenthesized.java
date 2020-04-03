package exmaple;

class Parenthesized extends Primary
{
	E e;

	Parenthesized(E exp)
	{
		e = exp;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <primary>"); 
		e.printParseTree(indent+" ");
	}

}
