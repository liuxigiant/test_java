package scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by liuxi6 on 2015/12/15.
 */
@Component("schedulerUtils")
public class SchedulerUtils
{
    /**
     * 不使用@Scheduled注解
     * @throws InterruptedException
     */
    public void test() throws InterruptedException
    {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(Thread.currentThread().getName() + "--in");
        Thread.sleep(6000);
        System.out.println(Thread.currentThread().getName() + "--out");
    }

    //经测试   每隔11秒执行一次
    @Scheduled(fixedDelay = 5000)
    public void testFixedDelay() throws Exception{
        System.out.println(String.format("testFixedDelay exe-->%s, thread-->%s",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                Thread.currentThread().getName()));
        long sleepTime = new Random().nextInt(10) * 1000;
        System.out.println("time-->" + sleepTime);
        Thread.sleep(sleepTime);
    }

    @Scheduled(fixedRate = 5000)
    public void testFixedRate()throws Exception{
        System.out.println(String.format("testFixedRate exe-->%s, thread-->%s",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                Thread.currentThread().getName()));
        long sleepTime = new Random().nextInt(10) * 1000;
        System.out.println("time-->" + sleepTime);
        Thread.sleep(sleepTime);
    }
}
