package exmaple;

class SingleTerm extends E
{
	// exmaple.Term term; inherited from exmaple.E

	SingleTerm(Term t)
	{
		term = t;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exmaple.E>");
		term.printParseTree(indent+" ");
	}

}
