package exmaple3;

class NotE extends FunExp
{	
	NotE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "not";
	}
}