package async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by liuxi6 on 2015/12/15.
 */
@Component
public class AsyncUtils
{
    @Async("myExecutor")
    public void async()
    {
        try
        {
            //等待3秒，便于显示异步执行的效果
            Thread.sleep(3000);
            System.out.println("Method: async");
            System.out.println("Method: async thread name--------" + Thread.currentThread().getName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 带有返回值的异步调用
     * @return
     */
    @Async("myExecutor")
    public Future<String> asyncWithReturn() throws Exception
    {
        //等待3秒，便于显示异步执行的效果
        Thread.sleep(3000);
        System.out.println("Method: asyncWithReturn");
        System.out.println("Method: asyncWithReturn thread name--------" + Thread.currentThread().getName());

        //有返回值Future的异步方法调用，抛出异常，可被方法调用者捕获处理
//        throw new Exception("asyncWithReturn_Error");

        //返回结果 Future是个接口，具体的类型为AsyncResult
        return new AsyncResult<String>("asyncWithReturn invoke success");
    }

    @Async("exceptionExecutor")
    public void asyncException() throws Exception
    {
        //等待3秒，便于显示异步执行的效果
        Thread.sleep(3000);
        System.out.println("Method: async");
        System.out.println("Method: async thread name--------" + Thread.currentThread().getName());
        throw new Exception("Error : I am so sad !");
    }

    /**
     * 异步方法async()在内部调用是不能生效的，所以不能在test中调用，也不能本类中使用main方法测试
     */
    public void test()
    {
        System.out.println("Method: main begin--------");
        System.out.println("Method: main thread name--------" + Thread.currentThread().getName());
        async();
        System.out.println("Method: main end--------");
    }
}
