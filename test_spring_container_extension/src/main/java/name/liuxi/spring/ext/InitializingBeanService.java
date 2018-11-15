package name.liuxi.spring.ext;

import org.springframework.beans.factory.InitializingBean;

public class InitializingBeanService implements InitializingBean {
    private static Integer f1;
    private Integer f2;

    static {
        f1 = 1;
        System.out.println("InitializingBeanService static block execute...");
    }

    public InitializingBeanService(){
        System.out.println("InitializingBeanService construct method execute...");
    }

    public void init(){
        System.out.println("InitializingBeanService init method execute...");
    }

    public Integer getF2() {
        return f2;
    }

    public void setF2(Integer f2) {
        this.f2 = f2;
        System.out.println("InitializingBeanService setF2 method execute...");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBeanService afterPropertiesSet method execute...");
    }
}
