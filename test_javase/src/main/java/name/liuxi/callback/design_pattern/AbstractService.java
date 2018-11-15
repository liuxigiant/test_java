package name.liuxi.callback.design_pattern;

public abstract class AbstractService {
    public void doSomething(){
        System.out.println("father : do some thing...");
        doOtherthings();
    }

    protected abstract void doOtherthings();
}
