package async;

import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by liuxi6 on 2015/12/17.
 */
public class ExceptionHandlerTaskExecutor implements AsyncTaskExecutor
{
    private AsyncTaskExecutor asyncTaskExecutor;

    @Override
    public void execute(Runnable runnable) {
        asyncTaskExecutor.execute(createWrappedRunnable(runnable));
    }

    @Override
    public void execute(Runnable runnable, long l) {
        asyncTaskExecutor.execute(createWrappedRunnable(runnable), l);
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        return asyncTaskExecutor.submit(createWrappedRunnable(runnable));
    }

    @Override
    public <T> Future<T> submit(Callable<T> callable) {
        return asyncTaskExecutor.submit(createWrappedCallable(callable));
    }

    /**
     * 封装异常处理
     * @return
     */
    private Callable createWrappedCallable(final Callable callable)
    {
        return new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    return callable.call();
                }catch (Exception e) {
                    handleException(e);
                    throw e;
                }
            }
        };
    }

    /**
     * 封装异常处理
     * @param runnable
     * @return
     */
    private Runnable createWrappedRunnable(final Runnable runnable)
    {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                }catch (Exception e) {
                    handleException(e);
                }
            }
        };
    }

    /**
     * 处理异常
     * @param e
     */
    private void handleException(Exception e)
    {
        System.out.println("@Async method invoke error! Crazy... Crazy... Crazy...");
        System.out.println(e.getMessage());
    }

    public AsyncTaskExecutor getAsyncTaskExecutor() {
        return asyncTaskExecutor;
    }

    public void setAsyncTaskExecutor(AsyncTaskExecutor asyncTaskExecutor) {
        this.asyncTaskExecutor = asyncTaskExecutor;
    }
}
