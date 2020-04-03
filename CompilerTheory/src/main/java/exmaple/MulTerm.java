package exmaple;

class MulTerm extends Term
{
	// exmaple.Primary primary; inherited from exmaple.Term

	Term term;

	MulTerm(Primary p, Term t)
	{
		primary = p;
		term = t;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";

		IO.displayln(indent + indent.length() + " <term>");
		primary.printParseTree(indent1);
		IO.displayln(indent1 + indent1.length() + " *");
		term.printParseTree(indent1);
	}

}
