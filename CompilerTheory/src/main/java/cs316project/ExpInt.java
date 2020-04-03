package cs316project;

public class ExpInt extends Exp {
    int intValue;

    public ExpInt(int intValue) {
        this.intValue = intValue;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <exp>");
        IO.println(indent1 +indent1.length() + " " + intValue );
    }
}
