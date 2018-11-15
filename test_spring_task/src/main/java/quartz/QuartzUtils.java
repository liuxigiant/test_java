package quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzUtils
{
    public void test() throws InterruptedException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        System.out.println(Thread.currentThread().getName() + "--in");
//        Thread.sleep(6000);
//        System.out.println(Thread.currentThread().getName() + "--out");
    }
}
