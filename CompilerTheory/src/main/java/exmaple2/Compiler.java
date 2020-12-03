package exmaple2;

public abstract class Compiler extends Parser
{
			
	public static void main(String argv[])
	{
		// argv[0]: input file containing an assignment list
		// argv[1]: output file containing the compiled instruction stream
		
		setIO( argv[0], argv[1] );
		setLex();

		getToken();
		AssignmentList assignmentList = assignmentList(); // build a parse tree
		if ( ! t.isEmpty() )
			displayln(t + " : Syntax Error, unexpected symbol where id expected");
		else if ( ! errorFound )
		{
			assignmentList.emitInstructions();
		}

		closeIO();
	}
}
