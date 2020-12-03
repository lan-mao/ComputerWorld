package exmaple4;

import java.util.HashMap;

final class MultipleFunDef extends FunDefList
{
	FunDef funDef;
	FunDefList funDefList;
	
	MultipleFunDef(FunDef fdef, FunDefList fdeflist)
	{
		funDef = fdef;
		funDefList = fdeflist;
	}


	@Override
    HashMap<String, Val> saveFunction() {
		HashMap<String, Val> hashMap = new HashMap<>();
		hashMap.putAll(funDef.saveFunction());
		hashMap.putAll(funDefList.saveFunction());
		return hashMap;
	}
}