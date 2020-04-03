package cs316project;

public class ExpFunExp extends Exp {
    FunExp funExp;

    public ExpFunExp(FunExp funExp) {
        this.funExp = funExp;
    }

    @Override
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <exp>");
        IO.println(indent1 +indent1.length() + " (" );
        funExp.printParseTree(indent1);
        IO.println(indent1 +indent1.length() + " )" );
    }
}
