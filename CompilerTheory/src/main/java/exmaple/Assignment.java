package exmaple;

/**
 * 分配
 */
class Assignment extends AssignmentList
{
	String id; // variable on the left side of the assignment
	E e;       // expression on the right side of the assignment 作业右侧的表达式

	Assignment(String s, E exp)
	{
		id = s;
		e = exp;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
				
		IO.displayln(indent + indent.length() + " <assignment>");
		IO.displayln(indent1 + indent1.length() + " " + id);
		IO.displayln(indent1 + indent1.length() + " =");
		e.printParseTree(indent1);
	}
}
