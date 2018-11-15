package name.liuxi.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created in 2018/6/17 22:39
 *
 */
public class ReentrantLockTest {

	private ReentrantLock lock = new ReentrantLock(true);


	public static void main(String[] args) throws Exception{
		ReentrantLockTest lockTest = new ReentrantLockTest();
		lockTest.justLock();
		lockTest.both();

		System.in.read();
	}

	public void both(){
		lock.lock();

		try{
			Thread.sleep(1000);
		}catch (Exception e){

		} finally {
			lock.unlock();
		}
	}

	public void justLock(){
		lock.lock();
	}
}
