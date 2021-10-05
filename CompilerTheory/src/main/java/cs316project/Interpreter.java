package cs316project;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 *  - 语法解释器
 *  - 目前使用接口的继承
 *  -
 */

public class Interpreter extends Parser{
    public static HashMap<String, Val> varState = new HashMap<>();

    public static void driver(){
        getState();
        Exp exp = exp();
        if (sb.length() > 0){
            errorMsg("all");
        } else if (!errorFound) {
            Val val = exp.eval(new ArrayList<>());
            System.out.println(val);
        }
    }
    public static void main(String[] args) {
        IO.setIO(args);
        driver();
        IO.close();
    }
}