package cs316project;

public class ParameterListId extends ParameterList {
    String id;
    ParameterList parameterList;

    public ParameterListId(String id, ParameterList parameterList) {
        this.id = id;
        this.parameterList = parameterList;
    }
    public void printParseTree(String indent) {
        String indent1 = indent + " ";
        IO.println(indent +indent.length() + " <parameter list>");
        IO.println(indent1 +indent1.length() + " " + id);
        parameterList.printParseTree(indent1);
    }
}
