package cs316project;
/**
 * Create Date 2020/04/26 20:07
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class ValNil extends Val{
    @Override
    public String toString() {
        return "nil";
    }
    @Override
    public boolean compareEqual(Val val) {
        if (val instanceof ValNil){
            return true;
        }else {
            return false;
        }
    }
}
