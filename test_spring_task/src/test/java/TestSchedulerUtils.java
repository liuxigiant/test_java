import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liuxi6 on 2015/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-scheduler.xml")
public class TestSchedulerUtils
{
    /**
     * Spring自带的调度随容器自启动，只需要加载配置文件就能看出任务调度效果 （ps : 没有找到手动控制的参数或者方法。。。）
     * @throws Exception
     */
    @Test
    public void test() throws Exception
    {
        //由于junit结束之后会结束jvm，此处让主线程等待才能测试任务调度效果
        Thread.sleep(1000000);

        //注意观察日志中的执行时间间隔
        //总结：
//        1、当任务A触发的时候，会检查任务A上次触发的线程是否已经执行完成，若没有执行完成，会丢弃本次的触发任务
//        2、总结1中的结论与线程数无关，即当线程为单线程和多个线程时候，结果一致

    }
}
