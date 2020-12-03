package exmaple3;

abstract class FunExp extends Exp
{
	ExpList expList;

	abstract String getFunOp();

	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " <fun exp>");

		String indent2 = indent1+" ";
		IO.displayln(indent2 + indent2.length() + " " + getFunOp());
		IO.displayln(indent2 + indent2.length() + " <exp list>");

		String indent3 = indent2+" ";

		ExpList p = expList;
		while ( p instanceof NonEmptyExpList)
		{
			((NonEmptyExpList)p).exp.printParseTree(indent3);			
			p = ((NonEmptyExpList)p).expList;	
		}
	}
}