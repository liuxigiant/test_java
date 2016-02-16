package quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuxi6 on 2015/11/20.
 */
public class QuartzUtils
{
    public void test() throws InterruptedException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(Thread.currentThread().getName() + "--in");
        Thread.sleep(6000);
        System.out.println(Thread.currentThread().getName() + "--out");
    }
}
