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
            //�ȴ�3�룬������ʾ�첽ִ�е�Ч��
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
     * ���з���ֵ���첽����
     * @return
     */
    @Async("myExecutor")
    public Future<String> asyncWithReturn() throws Exception
    {
        //�ȴ�3�룬������ʾ�첽ִ�е�Ч��
        Thread.sleep(3000);
        System.out.println("Method: asyncWithReturn");
        System.out.println("Method: asyncWithReturn thread name--------" + Thread.currentThread().getName());

        //�з���ֵFuture���첽�������ã��׳��쳣���ɱ����������߲�����
//        throw new Exception("asyncWithReturn_Error");

        //���ؽ�� Future�Ǹ��ӿڣ����������ΪAsyncResult
        return new AsyncResult<String>("asyncWithReturn invoke success");
    }

    @Async("exceptionExecutor")
    public void asyncException() throws Exception
    {
        //�ȴ�3�룬������ʾ�첽ִ�е�Ч��
        Thread.sleep(3000);
        System.out.println("Method: async");
        System.out.println("Method: async thread name--------" + Thread.currentThread().getName());
        throw new Exception("Error : I am so sad !");
    }

    /**
     * �첽����async()���ڲ������ǲ�����Ч�ģ����Բ�����test�е��ã�Ҳ���ܱ�����ʹ��main��������
     */
    public void test()
    {
        System.out.println("Method: main begin--------");
        System.out.println("Method: main thread name--------" + Thread.currentThread().getName());
        async();
        System.out.println("Method: main end--------");
    }
}
