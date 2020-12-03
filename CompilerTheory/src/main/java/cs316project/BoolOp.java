package cs316project;

import java.util.List;

public class BoolOp implements Eval{
    String token ;

    public BoolOp(String token) {
        this.token = token;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <bool op>");
        IO.println(indent1 +indent1.length() + " " + token);
    }

    @Override
    public Val eval(List<Val> state) {
        Val result = null;
        for (Val val : state) {
            if (val instanceof ValFloat ||val instanceof ValInt ||val instanceof ValError ||val instanceof ValNil ||val instanceof ValPair){
                result = (val instanceof ValError ? val : new ValError( token + " operator cannot be applied to " + val));
                break;
            }else {
                if (result == null){
                    result = val;
                } else {
                    ValBool valBool = (ValBool) val;
                    valBool.compareValBool((ValBool) result, token);
                    result = valBool;
                }
            }
        }
        state.clear();
        if (result == null){
            switch (token){
                case "or":{
                    result = new ValBool(false);
                    break;
                } case "and":{
                    result = new ValBool(true);
                    break;
                } case "not":{
                    result = new ValError("not operator missing argument ");
                    break;
                }
            }
        }
        return result;
    }
}
