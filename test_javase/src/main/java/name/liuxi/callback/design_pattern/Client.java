package name.liuxi.callback.design_pattern;

public class Client {
    public static void main(String[] args) {
        ServiceAImpl a = new ServiceAImpl();
        ServiceBImpl b = new ServiceBImpl();
        a.doSomething();
        b.doSomething();
    }
}
