package exmaple3;

class LeE extends FunExp
{	
	LeE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "<=";
	}
}