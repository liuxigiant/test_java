import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuxi6 on 2015/12/15.
 */
@ContextConfiguration("classpath:spring-quartz.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestQuartzUtils
{
    @Autowired
    private Scheduler testQuartzScheduler;

    /**
     * 若autoStartup配置为true，随容器自启动，只需要加载配置文件就能看出任务调度效果
     * @throws Exception
     */
    @Test
    public void testQuartzAutoStart() throws Exception
    {
        //由于junit结束之后会结束jvm，此处让主线程等待才能测试任务调度效果
        Thread.sleep(1000000);
    }

    /**
     * 若autoStartup配置为false，不随容器自启动，那么可以手动启动任务调度
     * @throws Exception
     */
    @Test
    public void testQuartz() throws Exception
    {
        //启动
        testQuartzScheduler.start();

        //暂停20秒再停止scheduler
        Thread.sleep(20000);

        System.out.println("scheduler standby at " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        testQuartzScheduler.standby(); //scheduler没有被销毁，可以调用start重新启动
//        testQuartzScheduler.shutdown(); //停止scheduler触发的任务，清理所有资源，不能重新启动，等价于shutdown(false)
//        testQuartzScheduler.shutdown(true); //参数未true表示会等待当前正在执行的任务执行完成，该方法才会正常返回


        //由于junit结束之后会结束jvm，此处让主线程等待才能测试任务调度效果
        Thread.sleep(1000000);
    }
}
