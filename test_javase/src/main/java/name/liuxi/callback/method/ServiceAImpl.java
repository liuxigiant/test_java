package name.liuxi.callback.method;

public class ServiceAImpl implements CallBackInterface{
    ServiceBImpl b;

    public ServiceAImpl(ServiceBImpl b){
        this.b = b;
    }

    public void doSomething(Integer type){
        System.out.println("A : do somr thing...");
        String callBackMsg = (String)b.doSomething(type, this);
        System.out.println(callBackMsg);
    }

    public void doSomething2(Integer type){
        System.out.println("A : do somr thing...");
        String callBackMsg = (String)b.doSomething(type, new CallBackInterface() {
            @Override
            public Object callBack(Integer type) {
                System.out.println("A : do call back internal method...");
                return "call back success internal method";
            }
        });
        System.out.println(callBackMsg);
    }

    public void doSomething3(Integer type){
        System.out.println("A : do somr thing...");
        String callBackMsg = (String)b.doSomething(type, e -> {
            System.out.println("A : do call back internal method with lambda...");
            return "call back success internal method with lambda";
        });
        System.out.println(callBackMsg);
    }

    public void doSomething4(Integer type){
        System.out.println("A : do somr thing...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String callBackMsg = (String)b.doSomething(type, ServiceAImpl.this);
                System.out.println(callBackMsg);
            }
        }).start();
        System.out.println("A : do somr thing continue...");
    }

    public void doSomething5(Integer type){
        System.out.println("A : do somr thing...");
        String callBackMsg = (String)b.doSomething2(type, e1 -> {
            return doCallBack1(e1);
        }, e2 -> {
            return doCallBack2(e2);
        });
        System.out.println(callBackMsg);
    }

    private String doCallBack1(Integer type){
        System.out.println("A : do call back1 internal method with lambda...");
        return "call back1 success internal method with lambda";
    }

    private String doCallBack2(Integer type){
        System.out.println("A : do call back2 internal method with lambda...");
        return "call back2 success internal method with lambda";
    }

    @Override
    public Object callBack(Integer type) {
        System.out.println("A : do call back...");
        return "call back success";
    }
}
