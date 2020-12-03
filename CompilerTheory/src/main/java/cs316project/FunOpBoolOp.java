package cs316project;

import java.util.List;

public class FunOpBoolOp extends FunOp {
    BoolOp boolOp;

    public FunOpBoolOp(BoolOp boolOp) {
        this.boolOp = boolOp;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <fun op>");
        boolOp.printParseTree(indent1);
    }

    @Override
    public Val eval(List<Val> state) {
        return boolOp.eval(state);
    }
}
