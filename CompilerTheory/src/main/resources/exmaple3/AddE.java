package exmaple3;

class AddE extends FunExp
{	
	AddE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "+";
	}
}