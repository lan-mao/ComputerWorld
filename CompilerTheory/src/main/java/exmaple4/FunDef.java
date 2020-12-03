package exmaple4;

import java.util.HashMap;

final class FunDef extends FunDefList
{
	//此处header应该是一个id列表，使用PairVal类记录，每一个
	Header header;
	Exp exp;
	
	FunDef(Header h, Exp e)
	{
		header = h;
		exp = e;
	}
	
	void printParseTree(String indent)
	{
		String indent1 = indent+" ";
		
		IO.displayln(indent + indent.length() + " <fun def>");		
		header.printParseTree(indent1);
		exp.printParseTree(indent1);
		IO.displayln("");
	}

	@Override
    HashMap<String, Val> saveFunction() {
		FunVal val = new FunVal(header.funName, header.parameterList, exp);
		HashMap<String, Val> hashMap = new HashMap<>();
		hashMap.put(header.funName, val);
		return hashMap;
	}


}