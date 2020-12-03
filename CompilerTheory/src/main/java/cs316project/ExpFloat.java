package cs316project;

import java.util.List;

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

    @Override
    public Val eval(List<Val> state) {
        ValFloat valFloat = new ValFloat(floatValue);
        state.add(0, valFloat);
        return valFloat;
    }
}
