package cs316project;
/**
 * Create Date 2020/04/26 20:04
 * Created by lan-mao.top
 */

public class ValError extends Val{
    String errorInfo;

    public ValError(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    @Override
    public String toString() {
        return "Error :" + errorInfo;
    }

    @Override
    public boolean compareEqual(Val val) {
        return false;
    }
}