
package name.liuxi.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * Created in 2018/8/21 20:34
 *
 */
public class TestForkJoin {
	public static void main(String[] args) throws Exception{
		ForkJoinPool pool = ForkJoinPool.commonPool();
		ForkJoinTask<Integer> task = pool.submit(new CountTask(1, 10));
		while (true){
			if (task.isDone()){
				System.out.println(task.get());
				break;
			}
		}
	}
}


class CountTask extends RecursiveTask<Integer> {

	private int start;
	private int end;

	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		System.out.println(Thread.currentThread().getName());
		if (end - start < 3){
			return IntStream.range(start, end).sum() + end;
		}

		int middle = (start + end) / 2;

		CountTask leftTask = new CountTask(start, middle);
		CountTask rightTask = new CountTask(middle + 1, end);

		//执行
		leftTask.fork();
		rightTask.fork();

		//获取结果
		int leftRes = leftTask.join();
		int rightRes = rightTask.join();

		//合并结果
		return leftRes + rightRes;
	}
}