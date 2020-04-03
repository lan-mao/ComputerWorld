package cs316project;

public class FunOpSecond extends FunOp {
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <fun op>");
        IO.println(indent1 +indent1.length() + " second");
    }
}
