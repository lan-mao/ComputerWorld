package cs316project;
/**
 * Create Date 2020/04/26 20:03
 * Created by lan-mao.top
 */

public class ValInt extends ValNum{
    int value;

    public ValInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value + "";
    }

    public ValFloat toValFloat(){
        return new ValFloat(value);
    }
    public void arithInt(ValInt val, String token){
        switch (token){
            case "+":{
                value += val.getValue();
                break;
            }case "-":{
                value = val.getValue() - value;
                break;
            }case "*":{
                value *= val.getValue();
                break;
            }case "/":{
                value = (int) (val.getValue() / ((double) value));
                break;
            }
        }
    }

    @Override
    public boolean compareSize(ValNum valNum, String token) {
        if (valNum instanceof ValFloat){
            return new ValFloat(value).compareSize(valNum, token);
        }
        ValInt temp = (ValInt) valNum;
        switch (token){
            case ">":{
                return value > temp.getValue();
            } case ">=":{
                return value >= temp.getValue();
            } case "<":{
                return value < temp.getValue();
            } case "<=":{
                return value <= temp.getValue();
            } case "=" :{
                return value == temp.getValue();
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