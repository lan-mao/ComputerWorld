package cs316project;

import java.util.ArrayList;
import java.util.List;

public class ExpIf extends Exp {
    Exp exp1, exp2, exp3;

    public ExpIf(Exp exp1, Exp exp2, Exp exp3) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.exp3 = exp3;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <exp>");
        IO.println(indent1 +indent1.length() + " if" );
        exp1.printParseTree(indent1);
        IO.println(indent1 +indent1.length() + " then" );
        exp2.printParseTree(indent1);
        IO.println(indent1 +indent1.length() + " else" );
        exp3.printParseTree(indent1);
    }

    /**
     * state的增减，应在什么时候
     * @param state
     * @return
     */
    @Override
    public Val eval(List<Val> state) {
        Val b = exp1.eval(new ArrayList<>());
        Val e1 = exp2.eval(new ArrayList<>());
        Val e2 = exp3.eval(new ArrayList<>());
        if (b instanceof ValError) {
            return b;
        } else if (b instanceof ValBool){
            boolean temp = ((ValBool) b).getValue();
            if (temp){
                return e1;
            } else {
                return e2;
            }
        } else {
            return new ValError("boolean condition of if-then-else evaluated to non-boolean value --> " + b);
        }
    }
}