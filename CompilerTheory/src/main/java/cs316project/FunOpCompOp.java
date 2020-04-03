package cs316project;

public class FunOpCompOp extends FunOp {
    CompOp compOp;

    public FunOpCompOp(CompOp compOp) {
        this.compOp = compOp;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <fun op>");
        compOp.printParseTree(indent1);
    }
}
