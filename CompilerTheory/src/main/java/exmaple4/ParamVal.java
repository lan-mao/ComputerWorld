package exmaple4;
/**
 * Create Date 2020/05/18 10:40
 * Created by lan-mao.top
 * TODO 
 *  - 这里存储一个函数的参数信息
 *  -
 */
 
public class ParamVal extends Val{
    String parameterName ;
    boolean isFunction;

    public ParamVal(String parameterName, boolean isFunction) {
        this.parameterName = parameterName;
        this.isFunction = isFunction;
    }

    public ParamVal(String parameterName) {
        this.parameterName = parameterName;
        isFunction = false;
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

}
