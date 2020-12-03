package cs316project;

import java.util.ArrayList;
import java.util.List;

public class ExpListExp extends ExpList {
    Exp exp;
    ExpList expList;

    public ExpListExp(Exp exp, ExpList expList) {
        this.exp = exp;
        this.expList = expList;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <exp list>");
        exp.printParseTree(indent1);
        expList.printParseTree(indent1);
    }

    @Override
    public Val eval(List<Val> state) {
        List<Val> temp = new ArrayList<>();
        if (!(expList instanceof ExpListEmpty)) {
            Val valExpList = expList.eval(temp);
        }
        Val valExp = exp.eval(temp);
        state.addAll(temp);
        return valExp;
    }
}
