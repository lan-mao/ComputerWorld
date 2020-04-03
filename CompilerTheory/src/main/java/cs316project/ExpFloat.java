package cs316project;

public class ExpFloat extends Exp {
    float floatValue;

    public ExpFloat(float floatValue) {
        this.floatValue = floatValue;
    }

    @Override
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <exp>");
        IO.println(indent1 +indent1.length() + " " + floatValue);
    }
}
