import name.liuxi.spring.ext.UserBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestInitMethod {

    @Autowired
    private UserBean userBean;

    @Test
    public void test(){
        System.out.println("test method execute...");
        System.out.println("user.userName = " + userBean.getUserName());
    }
}
