package name.liuxi;

/**
 * Created in 2018/8/20 14:18
 *
 */
public class Test {
	public static void main(String[] args) throws Exception {
		ThreadLocal<String> local = new ThreadLocal<>();
		local.set("AAA");
		System.out.println(local.get());
	}
}
