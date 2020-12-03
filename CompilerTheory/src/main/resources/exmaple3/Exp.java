package exmaple3;

abstract class Exp
{
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
	}
}