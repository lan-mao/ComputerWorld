package exmaple3;

class OrE extends FunExp
{	
	OrE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "or";
	}
}