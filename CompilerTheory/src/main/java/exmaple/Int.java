package exmaple;

class Int extends Primary
{
	int val;

	Int(int i)
	{
		val = i;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <primary> " + val);
	}

}
