package cs316project;

public class Header {
    FunName funName ;
    ParameterList parameterList;

    public Header(FunName funName, ParameterList parameterList) {
        this.funName = funName;
        this.parameterList = parameterList;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <header>");
        funName.printParseTree(indent1);
        parameterList.printParseTree(indent1);
    }
}
