package cs316project;

public class FunName {
    String id;

    public FunName(String id) {
        this.id = id;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <fun name>");
        IO.println(indent1 +indent1.length() + " " + id );
    }
}
