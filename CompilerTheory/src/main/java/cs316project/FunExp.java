package cs316project;

public class FunExp {
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
}
