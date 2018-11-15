package name.liuxi.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AOPUtil {

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("----" + pjp.getSignature().getName());
        System.out.println("before ...");
        ThreadLocal<String> tl = new ThreadLocal<String>();
        tl.set("1111");
        try{
          Object o = pjp.proceed();
            return o;
        }finally {
            System.out.println("after ...");
            System.out.println("threadLocal -- " + tl.get());
        }
    }
}
