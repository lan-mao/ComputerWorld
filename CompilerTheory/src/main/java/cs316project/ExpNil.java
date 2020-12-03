package cs316project;


import java.util.List;

public class ExpNil extends Exp {

    @Override
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <exp>");
        IO.println(indent1 +indent1.length() + " nil"  );
    }

    @Override
    public Val eval(List<Val> state) {
        ValNil valNil = new ValNil();
        state.add(0, valNil);
        return valNil;
    }
}
