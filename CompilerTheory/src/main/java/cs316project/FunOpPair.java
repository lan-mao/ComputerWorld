package cs316project;

import java.util.List;

public class FunOpPair extends FunOp {
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <fun op>");
        IO.println(indent1 +indent1.length() + " pair");
    }

    @Override
    public Val eval(List<Val> state) {
        Val first = null;
        Val second = null;
        for (int i = 0; i < state.size(); i++) {
            if (i >=2 || state.get(i) instanceof ValError){
                return state.get(i) instanceof ValError ? state.get(i) : new ValError("pair expressions error");
            } else if (i ==0){
                first = state.get(i);
            } else if (i == 1) {
                second = state.get(i);
            }
        }
        if (first != null && second != null){
            return new ValPair(first, second);
        } else {
            return new ValError("pair operator missing 1st or 2nd argument");
        }
    }
}
