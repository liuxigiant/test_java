import name.liuxi.spring.aop.service.ServiceClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:spring-config-aop.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAop {

    @Autowired
    private ServiceClass serviceClass;

    @Test
    public void testAop(){
        serviceClass.service();
    }
}
