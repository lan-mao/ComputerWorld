package cs316project;


public class ArithOp {
    String token;

    public ArithOp(String token) {
        this.token = token;
    }

    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent + indent.length() + " <arith op>");
        IO.println(indent1 + indent1.length() + " " + token);
    }
}
