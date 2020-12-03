package cs316project;

import java.util.List;

public class FunOpArithOp extends FunOp {
    ArithOp arithOp;

    public FunOpArithOp(ArithOp arithOp) {
        this.arithOp = arithOp;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <fun op>");
        arithOp.printParseTree(indent1);
    }

    @Override
    public Val eval(List<Val> state) {
        return arithOp.eval(state);
    }
}
