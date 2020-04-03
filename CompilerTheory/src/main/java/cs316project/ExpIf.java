package cs316project;

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
}
