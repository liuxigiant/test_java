package name.liuxi.callback.method;

public class ServiceBImpl {
    public Object doSomething(Integer type, CallBackInterface callback){
        System.out.println("B : do somr thing...");
        return callback.callBack(type);
    }

    public Object doSomething2(Integer type, CallBackInterface callback, CallBackInterface2 callback2){
        System.out.println("B : do somr thing...");
        return callback2.callBack(type);
    }
}
