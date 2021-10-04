package top.lan_mao.tacocloud;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Create Date 2021/04/05 8:12:47 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * Lombok的测试类 <br>
 */
@Log
@SpringBootTest
public class LombokTest {
    @Test
    public void newObject() {
        log.info("test");
    }
}