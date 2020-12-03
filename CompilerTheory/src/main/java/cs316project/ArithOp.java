package cs316project;


import java.util.List;

public class ArithOp implements Eval{
    String token;

    public ArithOp(String token) {
        this.token = token;
    }

    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent + indent.length() + " <arith op>");
        IO.println(indent1 + indent1.length() + " " + token);
    }

    @Override
    public Val eval(List<Val> state) {
        Val result = null;
        for (int i = state.size() -1; i >= 0; i--) {
            Val val = state.get(i);
            if (val instanceof ValBool || val instanceof ValError || val instanceof ValNil || val instanceof ValPair){
                result = (val instanceof ValError ? val : new ValError(token + " operator cannot be applied to " + val));
                break;
            } else {
                if (result == null) {
                    result = val;
                } else {
                    if (val instanceof ValInt) {
                        ValInt valInt = (ValInt) val;
                        if (result instanceof ValFloat) {
                            if (((ValFloat) result).getValue()== 0){
                                return new ValError("division by 0");
                            }
                            ((ValFloat) result).arithFloat(valInt.toValFloat(),token);
                        } else {
                            if (((ValInt) result).getValue()== 0){
                                return new ValError("division by 0");
                            }
                            ((ValInt) result).arithInt(valInt, token);
                        }
                    } else {
                        ValFloat valFloat = (ValFloat) val;
                        if (!(result instanceof ValFloat)) {
                            result = ((ValInt) result).toValFloat();
                        }
                        if (((ValFloat) result).getValue()== 0){
                            return new ValError("division by 0");
                        }
                        ((ValFloat) result).arithFloat(valFloat,token);
                    }
                }
            }
        }
        state.clear();
        if (result == null){
            switch (token){
                case "+": case "-":{
                    result = new ValInt(0);
                    break;
                } case "*": case "/":{
                    result = new ValInt(1);
                    break;
                }
            }
        }
        return result;
    }
}
