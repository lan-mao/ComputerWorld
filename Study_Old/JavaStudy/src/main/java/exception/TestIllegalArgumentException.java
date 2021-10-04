package exception;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create Date 2021/07/23 11:36:08 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 测试参数异常 <br>
 */
public class TestIllegalArgumentException {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat dateFormat1 = new SimpleDateFormat("YYYY-MM-dd");
        String a = dateFormat1.format(date);

        DateFormat dateFormat2 = new SimpleDateFormat("YYYY MM");
        String b = dateFormat2.format(a);

    }
}