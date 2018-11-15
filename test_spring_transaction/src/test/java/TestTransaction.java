import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestTransaction
{
    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void testTransactional() throws Exception
    {
        userService.updateTestTrans();
    }
}
