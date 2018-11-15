package name.liuxi.proxy;

import java.lang.reflect.Proxy;

/**
 * Created in 2018/9/10 16:18
 *
 */
public class TestProxy {
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");


//		Target targetImpl = () -> System.out.println("invoke target.test() ...");
		Target targetImpl = new TargetImpl2();

		Target targetProxy = (Target)
		Proxy.newProxyInstance(TestProxy.class.getClassLoader(),
				targetImpl.getClass().getInterfaces(), (target, method, argss) -> {
					System.out.println("proxy before ...");
					Object res = method.invoke(targetImpl, argss);
					System.out.println("proxy end ...");
					return res;
				});

		targetProxy.test();
		targetProxy.testWithResp();

	}
}
