import org.junit.jupiter.api.Test;

/**
 * Create Date 2021/01/07 12:51:36 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class Test01 {
    @Test
    public void testDate() {
        System.out.println(System.currentTimeMillis() + ";" +
                (System.currentTimeMillis() + 24 * 3600 * 1000));
    }
}