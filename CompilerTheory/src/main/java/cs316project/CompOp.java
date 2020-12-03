package cs316project;

import java.util.List;

public class CompOp implements Eval{
    String token;

    public CompOp(String token) {
        this.token = token;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <comp op>");
        IO.println(indent1 +indent1.length() + " " + token);
    }

    @Override
    public Val eval(List<Val> state) {
        Val result = null;
        for (Val val : state) {
            if (val instanceof ValError) {
                result = val;
                break;
            }else if (result == null){
                result = val;
            } else {
                switch (token){
                    case "<": case "<=": case ">": case ">=":{
                        if (val instanceof ValNum) {
                            if (result instanceof ValNum){
                                boolean temp = ((ValNum) result).compareSize((ValNum) val, token);
                                if (temp){
                                    result = val;
                                } else {
                                    result = new ValBool(false);
                                    return result;
                                }
                            }
                        } else {
                            result = (val instanceof ValError ? val : new ValError(token + " operator cannot be applied to " + val));
                            return result;
                        }
                        break;
                    } case "=":{
                        boolean temp = result.compareEqual(val);
                        if (temp){
                            result = val;
                            break;
                        } else {
                            result = new ValBool(false);
                            return result;
                        }
                    }
                }
            }
        }
        state.clear();
        if (result == null || !(result instanceof ValBool )){
            result = new ValBool(true);
        }
        return result;
    }
}
