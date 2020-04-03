package exmaple;

class Id extends Primary
{
	String id;

	Id(String ident)
	{
		id = ident;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <primary> " + id);
	}

}
