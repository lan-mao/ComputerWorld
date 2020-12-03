package cs316project;
/**
 * Create Date 2020/04/26 20:04
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class ValBool extends Val{
    private boolean value;

    public ValBool(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void compareValBool(ValBool valBool, String token){
        switch (token){
            case "or" :{
                value = valBool.getValue() || value;
                break;
            } case "and":{
                value = valBool.getValue() && value;
                break;
            } case "not":{
                value = !valBool.getValue();
            }
        }
    }

    @Override
    public boolean compareEqual(Val val) {
        if (val instanceof ValBool){
            return value == ((ValBool) val).getValue();
        }
        return false;
    }
}
