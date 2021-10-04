import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;


/**
 * Create Date 2020/02/27 10:38
 * Created by lan-mao.top
 * TODO 测试log4j
 */

public class TestLog4j {
    @Test
    void testLog4jNO1(){
        Logger logger = LogManager.getLogger();
        logger.fatal("系统错误！！！");
        logger.error("错误！！！");
        logger.warn("警告！！！");
        logger.info("信息~~");
        logger.debug("DEBUG--");
    }
}
