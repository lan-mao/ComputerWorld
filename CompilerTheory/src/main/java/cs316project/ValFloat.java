package cs316project;
/**
 * Create Date 2020/04/26 20:03
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class ValFloat extends ValNum{
    float value;

    public ValFloat(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value + "";
    }

    public void arithFloat(ValFloat val, String token){
        switch (token){
            case "+":{
                value += val.getValue();
                break;
            }
            case "-":{
                value = val.getValue() - value;
                break;
            }case "*":{
                value *= val.getValue();
                break;
            }case "/":{
                value = val.getValue() /value;
                break;
            }
        }
    }

    @Override
    public boolean compareSize(ValNum valNum, String token) {
        ValFloat temp = null;
        if (valNum instanceof ValInt)
            temp = new ValFloat(((ValInt)valNum).getValue());
        else
            temp = (ValFloat) valNum;
        switch (token) {
            case "<":{
                return ((Float)value).compareTo(temp.getValue())<0;
            } case "<=":{
                return ((Float)value).compareTo(temp.getValue())<=0;
            } case ">":{
                return ((Float)value).compareTo(temp.getValue())>0;
            } case ">=":{
                return ((Float)value).compareTo(temp.getValue())>=0;
            }case "=":{
                return ((Float)value).compareTo(temp.getValue())==0;
            }
        }
        return false;
    }

    @Override
    public boolean compareEqual(Val val) {
        if (val instanceof ValNum){
            return compareSize((ValNum)val, "=");
        }else {
            return false;
        }
    }
}
