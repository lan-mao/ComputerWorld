package cs316project;

public class FunOpFirst extends FunOp {
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent.length() + " <fun op>");
        IO.println(indent1.length() + " first");
    }
}
