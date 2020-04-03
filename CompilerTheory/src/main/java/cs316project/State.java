package cs316project;


public enum State {
    Start,
    Error,
    End,

    Id,
    Int,
    Float,
    FloatE,
    FloatF,
    Add,
    Sub,
    Mul,
    Div,
    Lt,
    Le,
    Gt,
    Ge,
    Eq,
    LParen,
    RParen,
    LBrace,
    RBrace,

    Dot,
    E,
    EPlusMinus,

    Keyword_if,
    Keyword_then,
    Keyword_else,
    Keyword_or,
    Keyword_and,
    Keyword_not,
    Keyword_first,
    Keyword_second,
    Keyword_nil,
    Keyword_pair;

    public static int size = 34;

    public boolean isError() {
        switch (this) {
            case Dot:
            case E:
            case EPlusMinus:
            case Error:
            case Start:
                return true;
            default:
                return false;
        }
    }
    public boolean isEnd(){
        switch (this) {
            case Start:
            case Dot:
            case E:
            case EPlusMinus:
                return false;
            default:
                return true;
        }
    }

    public String toString() {
        return isError() ? "Lexical Error, invalid token" : super.toString();
    }

    public static void main(String[] args) {
        System.out.println(State.Error);
    }
}

