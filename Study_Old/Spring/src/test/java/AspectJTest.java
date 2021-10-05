import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.lan_mao.computer_world.spring.service.DoSomethingService;

/**
 * Create Date 2020/09/10 10:29
 * Created by lan-mao.top
 */

public class AspectJTest {

    @Test
    public void do01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-aspectj.xml");
        DoSomethingService service = context.getBean("doSomethingService2", DoSomethingService.class);
        System.out.println(service.doSomething());
        System.out.println(service.doNothing());
        System.out.println(service.doError());
    }
}