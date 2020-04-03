package cs316project;
/**
 * Create Date 2020/04/02 23:21
 * Created by lan-mao.top
 */
 
public class FunDef extends FunDefList{

    Header header ;
    Exp exp;

    public FunDef(Header header, Exp exp) {
        this.header = header;
        this.exp = exp;
    }

    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <fun def>");
        header.printParseTree(indent1);
        IO.println(indent1 +indent1.length() + " {" );
        exp.printParseTree(indent1);
        IO.println(indent1 +indent1.length() + " }" );
    }
}
