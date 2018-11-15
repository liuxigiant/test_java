package name.liuxi.spring.ext;

public class InitMethodBeanService {
    private static Integer f1;
    private Integer f2;

    static {
        f1 = 1;
        System.out.println("InitMethodBeanService static block execute...");
    }

    public InitMethodBeanService(){
        System.out.println("InitMethodBeanService construct method execute...");
    }

    public void init(){
        System.out.println("InitMethodBeanService init method execute...");
    }

    public Integer getF2() {
        return f2;
    }

    public void setF2(Integer f2) {
        this.f2 = f2;
        System.out.println("InitMethodBeanService setF2 method execute...");
    }
}
