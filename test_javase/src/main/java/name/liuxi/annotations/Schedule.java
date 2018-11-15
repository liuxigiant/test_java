package name.liuxi.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Repeatable(Schedules.class)
public @interface Schedule {
    String scheduleName();

    String cron();

    String desc() default "";
}
