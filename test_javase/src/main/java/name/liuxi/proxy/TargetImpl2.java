package name.liuxi.proxy;

/**
 * Created in 2018/9/10 16:17
 *
 */
public class TargetImpl2 implements Target{
	@Override
	public void test() {
		System.out.println("test");
	}

	@Override
	public String testWithResp() {
		System.out.println("testWithResp");
		return "resp";
	}

	public void test2() {
		System.out.println("test2");
	}
}
