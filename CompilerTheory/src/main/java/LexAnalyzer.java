import java.io.*;
import java.util.Scanner;

/**
 * Create Date 2020/02/24 9:11
 * Created by lan-mao.top
 * 初级版本的词法分析器
 */

public class LexAnalyzer {

    public static void main(String[] args) throws IOException {
        Scanner reader = null;
        BufferedWriter writer = null;
        if (args.length!= 0) {
            String inPath = args[0];
            String outPath = args[1];
            try {
                reader = new Scanner(new FileInputStream(inPath));
                writer = new BufferedWriter(new FileWriter(outPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            reader = new Scanner(System.in);
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        String str = null;
        StringBuilder sb = new StringBuilder();
        while (reader.hasNext()) {
            //接下来对每一行进行分析
            str = reader.nextLine();
            char[] chars = str.toCharArray();
            //记录上一个是否是字母或数字
            boolean isDigitOrLetter = false;
            for (char temp : chars) {
                //如果字符是字母继续输入，如果不是字母，是字符需要先把原有的字符串分析，再连续输入，那就需要判断当前的字符串是否是字母或数字
                if (Character.isDigit(temp) || Character.isLetter(temp)){
                    //如果上一个是字母或数字，则继续输入，否则分析已经输入的字符串,并清空字符串
                    if (isDigitOrLetter || sb.length()==0) {
                        sb.append(temp);
                    }else {
                        if (sb.length()>0) {
                            writer.write(sb + " : " + analyze(sb.toString().toCharArray()) +'\n');
                            sb.delete(0, sb.length());
                            sb.append(temp);
                        }
                    }
                    isDigitOrLetter = true;
                } else {
                    if (!Character.isWhitespace(temp)) {
                        //如果当前字符不是字母或数字，那么先分析原有字符串，然后判断上一个字符是否也不是字母或数字
                        //如果上一个不是字母或数字，则继续输入,否则分析原有字符串
                        if (!isDigitOrLetter || sb.length()==0) {
                            sb.append(temp);
                        }else {
                            if (sb.length()>0) {
                                writer.write(sb + " : " + analyze(sb.toString().toCharArray()) +'\n');
                                sb.delete(0, sb.length());
                                sb.append(temp);
                            }
                        }
                    }
                    isDigitOrLetter = false;
                }
            }
            if (sb.length()>0){
                writer.write(sb + " : " + analyze(sb.toString().toCharArray()) +'\n');
                sb.delete(0, sb.length());
            }
            writer.flush();
        }
        writer.close();
        reader.close();
    }

    /**
     * 词法分析器
     * @param chars 字符串
     * @return 返回最后分析的结果集
     */
    public static String analyze(char[] chars){
        State state = State.Start;
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            State temp = analyzeChar(c);
            if (temp == State.Id){
                sb.append(c);
            }
            //此处的状态表示上一个字符分析后的状态,所有需要分析的状态都是有发出的箭头
            switch (state) {
                case Start: {
                    state = temp;
                    break;
                }
                case It: {
                    switch (temp) {
                        case Eq:
                            state = State.Le;
                            break;
                        default:
                            state = State.Error;
                    }
                    break;
                }
                case Gt: {
                    switch (temp) {
                        case Eq:
                            state = State.Ge;
                            break;
                        default:
                            state = State.Error;
                    }
                    break;
                }
                case Id:
                case Keyword_if:
                case Keyword_or:
                case Keyword_and:
                case Keyword_nil:
                case Keyword_not:
                case Keyword_else:
                case Keyword_then:
                case Keyword_first:
                case Keyword_second: {
                    switch (temp) {
                        case Id: {
                            switch (sb.toString()) {
                                case "if":
                                    state = State.Keyword_if;
                                    break;
                                case "or":
                                    state = State.Keyword_or;
                                    break;
                                case "and":
                                    state = State.Keyword_and;
                                    break;
                                case "nil":
                                    state = State.Keyword_nil;
                                    break;
                                case "not":
                                    state = State.Keyword_not;
                                    break;
                                case "else":
                                    state = State.Keyword_else;
                                    break;
                                case "then":
                                    state = State.Keyword_then;
                                    break;
                                case "first":
                                    state = State.Keyword_first;
                                    break;
                                case "second":
                                    state = State.Keyword_second;
                                    break;
                                default:
                                    state = State.Id;
                            }
                            break;
                        }
                        case Int:
                            state = State.Id;
                            break;
                        default:
                            state = State.Error;
                    }
                    break;
                }
                case Int: {
                    switch (temp) {
                        case Int:
                            state = State.Int;
                            break;
                        case Id: {
                            switch (c) {
                                case 'e':
                                case 'E':
                                    state = State.E;
                                    break;
                                case 'f':
                                case 'F':
                                    state = State.FloatF;
                                    break;
                                default:
                                    state = State.Error;
                            }
                            break;
                        }
                        case Dot:
                            state = State.Float;
                            break;
                        default:
                            state = State.Error;
                    }
                    break;
                }
                case Add:
                case Sub: {
                    switch (temp) {
                        case Int:
                            state = State.Int;
                            break;
                        case Dot:
                            state = State.Dot;
                            break;
                        default:
                            state = State.Error;
                    }
                    break;
                }
                case Dot: {
                    switch (temp) {
                        case Int:
                            state = State.Float;
                            break;
                        default:
                            state = State.Error;
                    }
                    break;
                }
                case Float: {
                    switch (temp) {
                        case Int:
                            state = State.Float;
                            break;
                        case Id: {
                            switch (c) {
                                case 'f':
                                case 'F':
                                    state = State.FloatF;
                                    break;
                                case 'e':
                                case 'E':
                                    state = State.E;
                                    break;
                                default:
                                    state = State.Error;
                            }
                            break;
                        }
                        default:
                            state = State.Error;
                    }
                    break;
                }
                case E: {
                    switch (temp) {
                        case Int:
                            state = State.FloatE;
                            break;
                        case Add: {
                            switch (c) {
                                case '+':
                                case '-':
                                    state = State.EPlusMinus;
                                    break;
                                default:
                                    state = State.Error;
                            }
                            break;
                        }
                        default:
                            state = State.Error;
                    }
                    break;
                }
                case EPlusMinus: {
                    switch (temp) {
                        case Int:
                            state = State.FloatE;
                            break;
                        default:
                            state = State.Error;
                    }
                    break;
                }
                case FloatE: {
                    switch (temp) {
                        case Int:
                            state = State.FloatE;
                            break;
                        case Id:
                            switch (c) {
                                case 'f':
                                case 'F':
                                    state = State.FloatF;
                                    break;
                                default:
                                    state = State.Error;
                            }
                            break;
                        default:
                            state = State.Error;
                    }
                    break;
                }
                default:
                    //此处对所有应该结束的状态分析，比如mul，div等。对这些状态，本应在上一个字符就是最后一个字符，但运行到此，说明还没有结束，因此为Error
                    state = State.Error;
            }
        }
        switch (state){
            //此处对运行结束的状态判断，如果状态为最终状态，则返回值，否则说明字符串不符合规则
            case Dot:case E:case EPlusMinus:case Error:case Start:
                return "Lexical Error, invalid token";
            default:
                return state.toString();
        }
    }

    /**
     * 普通的字符分析，并不会判断与上下文的关系。对于"e,E,f,F"字符需要单独分析
     * @param c
     * @return
     */
    public static State analyzeChar(char c){
        if (Character.isLetter(c)) {
            return State.Id;
        } else if (Character.isDigit(c)) {
            return State.Int;
        }else {
            switch (c) {
                case '*':
                    return State.Mul;
                case '/':
                    return State.Div;
                case '(':
                    return State.LParen;
                case ')':
                    return State.RParen;
                case '{':
                    return State.LBrace;
                case '}':
                    return State.RBrace;
                case '<':
                    return State.It;
                case '>':
                    return State.Gt;
                case '=':
                    return State.Eq;
                case '+':
                    return State.Add;
                case '-':
                    return State.Sub;
                case '.':
                    return State.Dot;
                default:
                    return State.Error;
            }
        }
    }
    enum State{
        Start,
        Error,

        Id,
        Int,
        Float,
        FloatE,
        FloatF,
        Add,
        Sub,
        Mul,
        Div,
        It,
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
        Keyword_nil;

        boolean isStart(){
            return  this.compareTo(State.Start) >= 0 ;
        }
    }
}
