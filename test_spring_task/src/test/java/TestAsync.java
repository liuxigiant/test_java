import async.AsyncUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * Created by liuxi6 on 2015/12/15.
 */
@ContextConfiguration("classpath:spring-async.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAsync
{
    @Autowired
    private AsyncUtils asyncUtils;

    /**
     * �첽����
     * @throws Exception
     */
    @Test
    public void testAsyncInvoke() throws Exception
    {
        System.out.println("Method: main begin--------");
        System.out.println("Method: main thread name--------" + Thread.currentThread().getName());
        asyncUtils.async();
        System.out.println("Method: main end--------");

        //����junit����֮������jvm���˴������̵߳ȴ����ܲ����������Ч��
        Thread.sleep(10000);
    }

    /**
     * �з���ֵ���첽����
     * @throws Exception
     */
    @Test
    public void testAsyncWithReturnInvoke() throws Exception
    {
        System.out.println("Method: main begin--------");
        System.out.println("Method: main thread name--------" + Thread.currentThread().getName());
        Future<String> result = asyncUtils.asyncWithReturn();
        System.out.println("Method: main end--------");
        //ѭ���ȴ��첽����
        while (true)
        {
            //����첽�����Ƿ񷵻ؽ��
            if (result.isDone())
            {
                System.out.println("Welcome back ! ");
                System.out.println(result.get());
                break;
            }
            else
            {
                System.out.println("I am waiting for you !");
            }
            Thread.sleep(500);
        }

        //����junit����֮������jvm���˴������̵߳ȴ����ܲ����������Ч��
        Thread.sleep(10000);
    }

    /**
     * �����쳣�첽����
     * @throws Exception
     */
    @Test
    public void testAsyncExceptionInvoke() throws Exception
    {
        System.out.println("Method: main begin--------");
        System.out.println("Method: main thread name--------" + Thread.currentThread().getName());
        asyncUtils.asyncException();
        System.out.println("Method: main end--------");

        //����junit����֮������jvm���˴������̵߳ȴ����ܲ����������Ч��
        Thread.sleep(10000);
    }
}
