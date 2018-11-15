package name.liuxi.feature8.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * Created in 2018/6/6 16:27
 *
 */
public class CompletableFutureTest {

	public static void main(String[] args) throws Exception {
//		testWhen();

//		testHandle();

		testThen();

		//whenComplete/whenCompleteAsync  --  处理结果，但不改变结果，返回原来的Future（可处理异常）
		//handle/handleAsync  --  处理结果，且改变结果，返回新的Future（可处理异常）
		//thenApply/thenApplyAsync  --  处理结果，且改变结果，返回新的Future（不可处理异常）
		//thenAccept/thenAcceptAsync  --  处理结果，且改变结果，不返回结果（不可处理异常）
		//thenAcceptBoth/thenAcceptBothAsync  --  两个都处理完成，则执行后续处理action（action可获取两个处理的结果）
		//runAfterBoth  --  两个都处理完成，则执行后续处理action（action不关心前面的处理结果）
		//thenRun/thenRunAsync  --  处理完成后，则执行后续处理action（action不关心前面的处理结果）

		//thenCombine/thenCombineAsync  -- 联合处理两个Future
		//acceptEither/applyToEither  --任何一个Future完成后，处理后续

		//allOf  -- 多个Future都执行完成
		//anyOf  -- 多个Future，任意一个执行完成
	}

	/**
	 * whenComplete  --  不改变supplyAsync异步执行的结果(包括抛出的异常)，相当于拦截器的后处理
	 */
	public static void testWhen()  throws Exception {
		CompletableFuture<Integer> future = getFuture();

		CompletableFuture<Integer> future1 = future.whenComplete((integer, throwable) -> {
			System.out.println("whenComplete -- " + Thread.currentThread().getName());  //当前线程
			System.out.println(String.format("whenComplete return [%s] and exception [%s]", integer, throwable == null ? "" : throwable.getMessage()));
		});


		CompletableFuture<Integer> future2 = future.whenCompleteAsync(((integer, throwable) -> {
			System.out.println("whenCompleteAsync -- " + Thread.currentThread().getName());  // -- 与异步执行线程一致
			System.out.println(String.format("whenCompleteAsync return [%s] and exception [%s]", integer, throwable == null ? "" : throwable.getMessage()));
		}));


		//依然需要get方法hang住当前线程
		System.out.println("future --> " + future.get());
		System.out.println("future1 --> " + future1.get());
		System.out.println("future2 --> " + future2.get());
//		System.in.read();
	}

	/**
	 * handle -- 改变supplyAsync异步执行的结果(包括抛出的异常),相当于对执行结果的后续处理
	 */
	public static void testHandle()  throws Exception {
		CompletableFuture<Integer> future = getFuture();

		CompletableFuture<Integer> future1 = future.handle((integer, throwable) -> {
			System.out.println("handle -- " + Thread.currentThread().getName());  //当前线程
			System.out.println(String.format("handle return [%s] and exception [%s]", integer, throwable == null ? "" : throwable.getMessage()));
			return 200;
		});


		CompletableFuture<Integer> future2 = future.handleAsync(((integer, throwable) -> {
			System.out.println("handleAsync -- " + Thread.currentThread().getName());  // -- 与异步执行线程一致
			System.out.println(String.format("handleAsync return [%s] and exception [%s]", integer, throwable == null ? "" : throwable.getMessage()));
			return 300;
		}));

		//依然需要get方法hang住当前线程
//		System.out.println("future --> " + future.get());
		System.out.println("future1 --> " + future1.get());
		System.out.println("future2 --> " + future2.get());
	}

	/**
	 * then -- 改变supplyAsync异步执行的结果(包括抛出的异常),相当于对执行结果的后续处理
	 * 它的功能相当于将CompletableFuture<T>转换成CompletableFuture<U>
	 *
	 * 它们与handle方法的区别在于handle方法会处理正常计算值和异常，因此它可以屏蔽异常，避免异常继续抛出。而thenApply方法只是用来处理正常值，因此一旦有异常就会抛出。
	 */
	public static void testThen()  throws Exception {
		CompletableFuture<Integer> future = getFuture();

		CompletableFuture<Integer> future1 = future.thenApplyAsync((integer) -> {
			System.out.println("thenApplyAsync -- " + Thread.currentThread().getName());  //与异步执行线程一致
			System.out.println(String.format("thenApplyAsync return [%s] ", integer));
			return integer + 100;
		});


		CompletableFuture<String> future2 = future.thenApply(((integer) -> {
			System.out.println("thenApply -- " + Thread.currentThread().getName());  // -- 与异步执行线程一致
			System.out.println(String.format("thenApply return [%s]", integer));
			return integer + "aaaa";
		}));

		//依然需要get方法hang住当前线程
		System.out.println("future --> " + future.get());
		System.out.println("future1 --> " + future1.get());
		System.out.println("future2 --> " + future2.get());
	}

	private static CompletableFuture<Integer> getFuture() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("supplyAsync -- " + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (Exception e){

			}
			if (1 == 1){
//				int  i = 1/0;
			}
			return 100;
		});
	}


}
