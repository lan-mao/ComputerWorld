package cs316project;


public class Parser extends LexAnalyzer{

    static boolean errorFound = false;

    public static FunDefList funDefList(){
        // fun def list --> fun def | fun_def fun_def_list
        FunDef funDef = funDef();
        if (state == State.Id){
            FunDefList funDefList = funDefList();
            return new FunDefListFun(funDef, funDefList);
        } else {
            return funDef;
        }
    }

    public static FunDef funDef(){
        // fun_def --> header { exp }
        Header header = header();
        if (state == State.LBrace) {
            getState();
            Exp exp = exp();
            if (state == State.RBrace) {
                getState();
                return new FunDef(header, exp);
            } else {
                errorMsg("}");
            }
        } else
            errorMsg("{");
        return null;
    }

    public static Header header(){
        FunName funName = funName();
        ParameterList parameterList = parameterList();
        return new Header(funName, parameterList);
    }

    public static FunName funName(){
        if (state == State.Id){
            String id = sb.toString();
            getState();
            return new FunName(id);
        } else {
            errorMsg("fun name");
            return null;
        }
    }

    public static ParameterList parameterList(){
        // parameter_list --> empty | id parameter_list
        switch (state) {
            default:{
                return new ParameterListEmpty();
            }
            case Id:{
                String id = sb.toString();
                getState();
                ParameterList parameterList = parameterList();
                return new ParameterListId(id, parameterList);
            }
        }
    }

    public static Exp exp(){
        // exp --> id | int | float | floatE | floatF | nil | ( fun_exp ) | if exp then exp else exp
        switch (state){
            case Id:{
                String id = sb.toString();
                getState();
                return new ExpId(id);
            }
            case Int:{
                int intValue = Integer.parseInt(sb.toString());
                getState();
                return new ExpInt(intValue);
            }
            case Float:case FloatE:case FloatF:{
                float floatValue = Float.parseFloat(sb.toString());
                getState();
                return new ExpFloat(floatValue);
            }
            case Keyword_nil:{
                getState();
                return new ExpNil();
            }
            case LParen:{
                getState();
                FunExp funExp = funExp();
                if (state == State.RParen) {
                    getState();
                    return new ExpFunExp(funExp);
                }else {
                    errorMsg(")");
                    return null;
                }
            }
            case Keyword_if:{
                getState();
                Exp exp1 = exp();
                if (state == State.Keyword_then) {
                    getState();
                    Exp exp2 = exp();
                    if (state == State.Keyword_else) {
                        getState();
                        Exp exp3 = exp();
                        return new ExpIf(exp1, exp2, exp3);
                    } else {
                        errorMsg("else");
                        return null;
                    }
                } else {
                    errorMsg("then");
                    return null;
                }
            }
            default:{
                errorMsg("exp");
                return null;
            }

        }
    }

    public static FunExp funExp(){
        // fun exp --> fun_op exp_list
        FunOp funOp = funOp();
        ExpList expList = expList();
        return new FunExp(funOp, expList);
    }

    public static FunOp funOp(){
        switch (state){
            case Id:{
                String id = sb.toString();
                getState();
                return new FunOpId(sb.toString());
            }
            case Keyword_pair: {
                getState();
                return new FunOpPair();
            }
            case Keyword_first:{
                getState();
                return new FunOpFirst();
            }
            case Keyword_second:{
                getState();
                return new FunOpSecond();
            }
            case Add:case Sub:case Mul:case Div:{
                ArithOp arithOp = arithOp();
                return new FunOpArithOp(arithOp);
            }
            case Keyword_or:case Keyword_and:case Keyword_not:{
                BoolOp boolOp = boolOp();
                return new FunOpBoolOp(boolOp);
            }
            case Lt:case Le:case Gt:case Ge:case Eq:{
                CompOp compOp = compOp();
                return new FunOpCompOp(compOp);
            }
            default:{
                errorMsg("fun op");
                return null;
            }
        }
    }

    public static ArithOp arithOp(){
        String token = sb.toString();
        getState();
        return new ArithOp(token);
    }

    public static BoolOp boolOp(){
        String token = sb.toString();
        getState();
        return new BoolOp(token);
    }

    public static CompOp compOp(){
        String token = sb.toString();
        getState();
        return new CompOp(token);
    }

    public static ExpList expList(){
        switch (state){
            default:{
                return new ExpListEmpty();
            }
            case Id:case Int:case Float:case FloatE:case FloatF:case Keyword_nil:case LParen: case Keyword_if:{
                Exp exp = exp();
                ExpList expList = expList();
                return new ExpListExp(exp, expList);
            }
        }
    }

    public static void errorMsg(String msg){
        errorFound = true;
        IO.println(sb + " : Syntax Error, unexpected symbol where " + msg + " expected");
    }

    public static void driver(){
        getState();
        FunDefList funDefList = funDefList();
        if (sb.length() > 0){
            errorMsg("all");
        } else if (!errorFound) {
            funDefList.printParseTree("");
        }
    }
    public static void main(String[] args) {
        IO.setIO(args);
        driver();
        IO.close();
    }
}

