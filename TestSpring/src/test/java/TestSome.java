import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.SomeService;
import service.impl.SomeServiceImpl;

/**
 * Create Date 2020/03/07 17:47
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class TestSome {

    //缺点：当前类的对象与service实现类耦合在一起
    @Test
    public void someTest(){
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    @Test
    public void testSpring1(){
        Logger logger = LogManager.getLogger();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        logger.info("aaa");
        SomeService service = applicationContext.getBean("someServiceImpl", SomeService.class);
        service.doSome();
    }
}
