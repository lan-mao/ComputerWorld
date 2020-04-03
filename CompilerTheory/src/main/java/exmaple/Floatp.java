package exmaple;

class Floatp extends Primary
{
	float val;

	Floatp(float f)
	{
		val = f;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <primary> " + val);
	}

}
