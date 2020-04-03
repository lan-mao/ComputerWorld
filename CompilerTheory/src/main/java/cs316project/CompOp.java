package cs316project;

public class CompOp {
    String token;

    public CompOp(String token) {
        this.token = token;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <comp op>");
        IO.println(indent1 +indent1.length() + " " + token);
    }
}
