package cs316project;

import java.util.ArrayList;
import java.util.List;

public class FunExp implements Eval{
    FunOp funOp;
    ExpList expList;

    public FunExp(FunOp funOp, ExpList expList) {
        this.funOp = funOp;
        this.expList = expList;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <fun exp>");
        funOp.printParseTree(indent1);
        expList.printParseTree(indent1);
    }

    @Override
    /**
     * state列表中数据的清除与添加
     */
    public Val eval(List<Val> state) {
        List<Val> temp = new ArrayList<>();
        Val valExpList = expList.eval(temp);
        Val eval = funOp.eval(temp);
        state.add(0, eval);
        return eval;
    }
}