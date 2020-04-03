package cs316project;



public class FunDefListFun extends FunDefList {
    FunDef funDef;
    FunDefList funDefList;

    public FunDefListFun(FunDef funDef, FunDefList funDefList) {
        this.funDef = funDef;
        this.funDefList = funDefList;
    }

    @Override
    public void printParseTree(String indent) {
        funDef.printParseTree(indent);
        funDefList.printParseTree(indent);
    }
}
