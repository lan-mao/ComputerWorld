package exmaple;

class MultipleAssignment extends AssignmentList
{
	Assignment assignment;
	AssignmentList assignmentList;

	MultipleAssignment(Assignment a, AssignmentList al)
	{
		assignment = a;
		assignmentList = al;
	}
 
	void printParseTree(String indent)
	{		
		assignment.printParseTree(indent);
		assignmentList.printParseTree(indent);
	}

}
