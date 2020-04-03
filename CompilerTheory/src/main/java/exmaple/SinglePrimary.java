package exmaple;

class SinglePrimary extends Term
{
	// exmaple.Primary primary; inherited from exmaple.Term

	SinglePrimary(Primary p)
	{
		primary = p;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <term>");
		primary.printParseTree(indent+" ");
	}

}
