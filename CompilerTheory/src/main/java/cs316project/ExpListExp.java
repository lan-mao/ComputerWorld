package cs316project;

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
}
