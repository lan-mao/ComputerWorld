package cs316project;

public class ExpId extends Exp {
    String id;

    public ExpId(String id) {
        this.id = id;
    }

    @Override
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <exp>");
        IO.println(indent1 +indent1.length() + " " + id );
    }
}
