package exmaple3;

class AndE extends FunExp
{	
	AndE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "and";
	}
}