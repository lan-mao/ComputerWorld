package exmaple;

class SubE extends E
{
	// exmaple.Term term; inherited from exmaple.E

	E e;

	SubE(Term t, E e_)
	{
		term = t;
		e = e_;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";

		IO.displayln(indent + indent.length() + " <exmaple.E>");
		term.printParseTree(indent1);
		IO.displayln(indent1 + indent1.length() + " -");
		e.printParseTree(indent1);
	}

}
