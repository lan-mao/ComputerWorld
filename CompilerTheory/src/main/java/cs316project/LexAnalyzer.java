package cs316project;

import java.io.IOException;
import java.util.HashMap;

/**
 * 初级版本的词法分析器
 */

public class LexAnalyzer {


    //除去关键字的状态个数

    //保存每一个状态下，下个字符会处于的状态
    public static State nextState[][] = new State[State.size + 1][128];
    //保存关键字，以及关键字对应的状态
    public static HashMap<String, State> keywordMap = new HashMap<>();
    /**
     * 当前的状态
     */
    public static State state = State.Start;
    /**
     * 当前状态对应的令牌
     */
    public static StringBuilder sb = new StringBuilder();

    static {
        initKeywordMap();
        initNextState();
    }

    public static void initNextState() {
        for (int i = 0; i <= State.size; i++) {
            for (int y = 0; y < 128; y++) {
                nextState[i][y] = State.Error;
            }
        }
        for (int i = '0'; i <= '9'; i++) {
            nextState[State.Start.ordinal()][i] = State.Int;
            nextState[State.Id.ordinal()][i] = State.Id;
            nextState[State.Int.ordinal()][i] = State.Int;
            nextState[State.Add.ordinal()][i] = State.Int;
            nextState[State.Sub.ordinal()][i] = State.Int;
            nextState[State.Float.ordinal()][i] = State.Float;
            nextState[State.Dot.ordinal()][i] = State.Float;
            nextState[State.E.ordinal()][i] = State.FloatE;
            nextState[State.FloatE.ordinal()][i] = State.FloatE;
            nextState[State.EPlusMinus.ordinal()][i] = State.FloatE;
        }

        for (int i = 'a'; i <= 'z'; i++) {
            nextState[State.Start.ordinal()][i] = State.Id;
            nextState[State.Id.ordinal()][i] = State.Id;
        }

        for (int i = 'A'; i <= 'Z'; i++) {
            nextState[State.Start.ordinal()][i] = State.Id;
            nextState[State.Id.ordinal()][i] = State.Id;
        }

        nextState[State.Start.ordinal()]['*'] = State.Mul;
        nextState[State.Start.ordinal()]['/'] = State.Div;
        nextState[State.Start.ordinal()]['('] = State.LParen;
        nextState[State.Start.ordinal()][')'] = State.RParen;
        nextState[State.Start.ordinal()]['{'] = State.LBrace;
        nextState[State.Start.ordinal()]['}'] = State.RBrace;
        nextState[State.Start.ordinal()]['<'] = State.Lt;
        nextState[State.Start.ordinal()]['>'] = State.Gt;
        nextState[State.Start.ordinal()]['='] = State.Eq;
        nextState[State.Start.ordinal()]['+'] = State.Add;
        nextState[State.Start.ordinal()]['-'] = State.Sub;
        nextState[State.Start.ordinal()]['.'] = State.Dot;

        nextState[State.Lt.ordinal()]['='] = State.Le;
        nextState[State.Gt.ordinal()]['='] = State.Ge;

        nextState[State.Int.ordinal()]['f'] = State.FloatF;
        nextState[State.Int.ordinal()]['F'] = State.FloatF;
        nextState[State.Float.ordinal()]['f'] = State.FloatF;
        nextState[State.Float.ordinal()]['F'] = State.FloatF;
        nextState[State.FloatE.ordinal()]['f'] = State.FloatF;
        nextState[State.FloatE.ordinal()]['F'] = State.FloatF;

        nextState[State.Int.ordinal()]['e'] = State.E;
        nextState[State.Int.ordinal()]['E'] = State.E;
        nextState[State.Float.ordinal()]['e'] = State.E;
        nextState[State.Float.ordinal()]['E'] = State.E;

        nextState[State.Add.ordinal()]['.'] = State.Dot;
        nextState[State.Sub.ordinal()]['.'] = State.Dot;
        nextState[State.Int.ordinal()]['.'] = State.Float;

        nextState[State.E.ordinal()]['+'] = State.EPlusMinus;
        nextState[State.E.ordinal()]['-'] = State.EPlusMinus;


    }

    public static void initKeywordMap() {
        keywordMap.put("if", State.Keyword_if);
        keywordMap.put("then", State.Keyword_then);
        keywordMap.put("else", State.Keyword_else);
        keywordMap.put("or", State.Keyword_or);
        keywordMap.put("and", State.Keyword_and);
        keywordMap.put("not", State.Keyword_not);
        keywordMap.put("pair", State.Keyword_pair);
        keywordMap.put("first", State.Keyword_first);
        keywordMap.put("second", State.Keyword_second);
        keywordMap.put("nil", State.Keyword_nil);
    }


    public static State keywordCheck (State state , String value){
        //此处对ID进行分析，如果是关键字则调整状态为对应的关键字
        State keywordState = keywordMap.get(value);
        if (keywordState != null)
            return keywordState;
        else
            return state;
    }


    public static void driver(){
        while (IO.hasNext()){
            getState();
            if (sb.length()>0)
                IO.println(sb.toString() + " : " + state);
        }
    }

    /**
     * 获取下一个单词符号
     * @return 获取到一个状态即返回
     */
    public static void getState(){
        state = State.Start;
        sb.delete(0,sb.length());
        int value = 0;
        if (!IO.hasNext()){
            state = State.End;
            return;
        }
        while ((value = IO.getNextChar()) != -1){
            char charTemp = (char)value;
            if (charTemp > 127) {
                state = State.Error;
                return;
            }
            State stateTemp = nextState[state.ordinal()][charTemp];
            //获取下一个状态，如果是错误，则判断上一个状态是否已经可以结束，可以则输出当前的状态
            if (stateTemp == State.Error ||Character.isWhitespace(charTemp)){
                if (state.isEnd()){
                    if (state == State.Id){
                        state = keywordCheck(state,sb.toString());
                    }
                    if (sb.length() > 0 && !Character.isWhitespace(charTemp)) {
                        //如果状态已经结束，则将标志位前移一位
                        IO.forward();
                    }
                    break;
                }else {
                    if (state == State.Start && Character.isWhitespace(charTemp)){
                        continue;
                    }else {
                        state = State.Error;
                        if (!Character.isWhitespace(charTemp))
                            sb.append(charTemp);
                    }
                }
                break;
            }else {
                state = stateTemp;
                sb.append(charTemp);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        IO.setIO(args);
        driver();
        IO.close();
    }

}


