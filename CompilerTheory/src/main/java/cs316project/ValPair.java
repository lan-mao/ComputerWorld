package cs316project;
/**
 * Create Date 2020/04/26 20:08
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class ValPair extends Val {
    Val first;
    Val second;

    public String toString()
    {
        return "pair("+first+", "+second+")";
    }

    public ValPair(Val first, Val second) {
        this.first = first;
        this.second = second;
    }

    public Val getFirst() {
        return first;
    }

    public void setFirst(Val first) {
        this.first = first;
    }

    public Val getSecond() {
        return second;
    }

    public void setSecond(Val second) {
        this.second = second;
    }

    public boolean compareEqual(ValPair valPair){
        return first.compareEqual(valPair.getFirst()) && second.compareEqual(valPair.getSecond());
    }

    @Override
    public boolean compareEqual(Val val) {
        if (val instanceof ValPair){
            return compareEqual((ValPair) val);
        } else {
            return false;
        }
    }
}
