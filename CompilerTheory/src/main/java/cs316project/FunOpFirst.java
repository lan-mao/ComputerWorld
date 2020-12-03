package cs316project;

import java.util.List;

public class FunOpFirst extends FunOp {
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent.length() + " <fun op>");
        IO.println(indent1.length() + " first");
    }

    @Override
    public Val eval(List<Val> state) {
        if (state.size() != 1 || state.get(0) instanceof ValError){
            return state.get(0) instanceof ValError ? state.get(0) :new ValError("first operator missing argument");
        } else if (state.get(0) instanceof ValPair){
            return ((ValPair)state.get(0)).getFirst();
        } else {
            return new ValError("first operator cannot be applied to " + state.get(0));
        }
    }
}
