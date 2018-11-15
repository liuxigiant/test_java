package name.liuxi.annotations;

import java.lang.reflect.Method;

public class TestHandlerAnnotations {
    public static void main(String[] args) {
        Method[] methods = CustAnnotationsService.class.getDeclaredMethods();
        for (Method m : methods){
            Schedule[] scheduleArr = m.getAnnotationsByType(Schedule.class); //兼容注解和重复注解容器的获取
            for (Schedule schedule : scheduleArr){
                System.out.println(String.format("method name = %s; schedule : scheduleName = %s, cron = %s, desc = %s",
                        m.getName(), schedule.scheduleName(), schedule.cron(), schedule.desc()));
            }
        }
    }
}
