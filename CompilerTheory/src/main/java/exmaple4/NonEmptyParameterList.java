package exmaple4;

import java.util.List;

final class NonEmptyParameterList extends ParameterList
{
	String id;
	ParameterList parameterList;
	
	NonEmptyParameterList(String s, ParameterList pl)
	{
		id = s;
		parameterList = pl;
	}

	@Override
	void saveParameterList(List<ParamVal> list) {
		list.add(new ParamVal(id));
		parameterList.saveParameterList(list);
	}
}