//package async;
//
//import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
//
//import java.lang.reflect.Method;
//
///**
// * Created by liuxi6 on 2015/12/17.
// */
//public class AsyncExceptionHandler extends SimpleAsyncUncaughtExceptionHandler
//{
//    @Override
//    public void handleUncaughtException(Throwable throwable, Method method, Object... objects)
//    {
//        System.out.println("@Async method invoke error! new feature... new feature... new feature...");
//        System.out.println(throwable.getMessage());
//    }
//}
