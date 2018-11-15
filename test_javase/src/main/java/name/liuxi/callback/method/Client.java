package name.liuxi.callback.method;

public class Client {
    public static void main(String[] args) {
        ServiceBImpl b = new ServiceBImpl();
        ServiceAImpl a = new ServiceAImpl(b);
//        a.doSomething(1); //同步回调
//        a.doSomething2(1); //同步回调 -- 直接传接口
//        a.doSomething3(1); //同步回调 -- lambda表达式
//        a.doSomething4(1); //异步回调
        a.doSomething5(1); //同步回调 -- 两个回调方法
    }
}
