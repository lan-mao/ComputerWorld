package exmaple3;

class NonEmptyExpList extends ExpList
{
	Exp exp;
	ExpList expList;
	
	NonEmptyExpList(Exp e, ExpList el)
	{
		exp = e;
		expList = el;
	}
}