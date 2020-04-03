package cs316project;

public class FunOpId extends FunOp {
    String id;

    public FunOpId(String id) {
        this.id = id;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <fun op>");
        IO.println(indent1 +indent1.length() + " " + id);
    }
}
