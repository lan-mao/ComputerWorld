package cs316project;

import java.util.List;

public class FunOpSecond extends FunOp {
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <fun op>");
        IO.println(indent1 +indent1.length() + " second");
    }

    @Override
    public Val eval(List<Val> state) {
        if (state.size() != 1 || state.get(0) instanceof ValError){
            return state.get(0) instanceof ValError ? state.get(0) :new ValError("second operator missing argument");
        } else if (state.get(0) instanceof ValPair){
            return ((ValPair)state.get(0)).getSecond();
        } else {
            return new ValError("second operator cannot be applied to " + state.get(0));
        }
    }
}
