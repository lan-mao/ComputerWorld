package cs316project;

import java.util.List;

public class ExpListEmpty extends ExpList {
    @Override
    public void printParseTree(String indent) {
        IO.println(indent +indent.length() + " <exp list>");
    }

    @Override
    public Val eval(List<Val> state) {
        return new ValNil();
    }
}
