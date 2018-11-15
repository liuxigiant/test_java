package name.liuxi.concurrent;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created in 2018/7/11 18:45
 *
 */
public class TestLock {

	private static final ReentrantLock lock = new ReentrantLock();
	private static final Condition cond = lock.newCondition();

	public static void main(String[] args) throws Exception{

		new Thread(() -> {
			lock.lock();

			try{

				cond.await();

				TimeUnit.SECONDS.sleep(50);
			}catch (Exception e){

			}
			System.out.println("t1 unlock *********");
//			lock.unlock();
		}, "t1").start();

		TimeUnit.SECONDS.sleep(2);


		System.out.println("t2 start --------");
		new Thread(() -> {
			lock.lock();

			try{


				cond.await();

				System.in.read();
			}catch (Exception e){

			}
		}, "t2").start();

		TimeUnit.SECONDS.sleep(2);

		System.out.println("t3 start +++++++++");
		new Thread(() -> {
			lock.lock();

			try{

				cond.await();

				System.in.read();
			}catch (Exception e){

			}
		}, "t3").start();

		TimeUnit.SECONDS.sleep(2);

		lock.lock();
		cond.signal();

		System.in.read();
	}
}
