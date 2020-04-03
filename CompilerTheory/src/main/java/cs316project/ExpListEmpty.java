package cs316project;

public class ExpListEmpty extends ExpList {
    @Override
    public void printParseTree(String indent) {
        IO.println(indent +indent.length() + " <exp list>");
    }
}
