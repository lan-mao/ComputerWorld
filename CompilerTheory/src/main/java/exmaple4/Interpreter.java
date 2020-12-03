package exmaple4;

import java.util.*;

public abstract class Interpreter extends Parser
{
	//将所有的变量值设为一个map集合
	public static String variableMapName = "`";
	public static void main(String argv[])
	
	/* 
	   argv[0]: source program file containing function definitions
	   argv[1]: lexical/syntactical error messages for the source program in argv[0]
	   argv[2]: single expression to be evaluated
	   argv[3]: lexical/syntactical error messages for the expression in argv[2]
	 
	   The evaluation result and runtime errors will be displayed on the terminal.
	*/
	
	{
		setIO( argv[0], argv[1] );
		setLex();
		
		getToken();
		FunDefList funDefList = funDefList();
		if ( ! t.isEmpty() )
			errorMsg(0);
		else if ( ! syntaxErrorFound )
		{
			//建立一个函数的调用
			/**
			 * todo:
			 *  此处的hashmap应该由函数构建
			 *  这里的map对应的值应该是FunVal类型
			 */
			HashMap<String, Val> map = funDefList.saveFunction();
			//存储变量id对应的值
			closeIO();
			setIO( argv[2], argv[3] );
			getToken();
			Exp exp = exp();
			if ( ! t.isEmpty() )
				displayln(t + "  -- unexpected symbol");
			else if ( ! syntaxErrorFound )
			{
				Val v = exp.Eval(new HashMap<String, Val>());  // evaluate the given expression
				if ( v != null )
					System.out.println( v.toString() );   // display the value on the terminal
			}
		}

		closeIO();
	}
}
