package cs316project;

import java.util.List;

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

    @Override
    public Val eval(List<Val> state) {
        return new ValError("ID error");
    }
}
