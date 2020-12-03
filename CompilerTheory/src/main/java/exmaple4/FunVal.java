package exmaple4;

import java.util.ArrayList;
import java.util.List;

final class FunVal extends Val
{
	String funName;

	/**
	 * todo：
	 *  一个函数应该包含
	 *  函数名
	 *  参数列表
	 *  函数体
	 */
	List<ParamVal> parameterList = new ArrayList<>();
	Exp exp ;

	public FunVal(String funName, ParameterList parameterList, Exp exp) {
		this.funName = funName;
		parameterList.saveParameterList(this.parameterList);
		this.exp = exp;
	}

	@Override
	Val cloneVal() {
		return null;
	}

	@Override
	float floatVal() {
		return 0;
	}

	@Override
	boolean isNumber() {
		return false;
	}

	@Override
	boolean isZero() {
		return false;
	}

	boolean isFunction() {
		return false;
	}
}
