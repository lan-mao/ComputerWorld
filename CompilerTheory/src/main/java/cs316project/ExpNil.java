package cs316project;

 
public class ExpNil extends Exp {

    @Override
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <exp>");
        IO.println(indent1 +indent1.length() + " nil"  );
    }
}
