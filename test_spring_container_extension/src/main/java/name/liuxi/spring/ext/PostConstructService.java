package name.liuxi.spring.ext;

import javax.annotation.PostConstruct;

public class PostConstructService {
    private static Integer f1;
    private Integer f2;

    static {
        f1 = 1;
        System.out.println("PostConstructService static block execute...");
    }

    public PostConstructService(){
        System.out.println("PostConstructService construct method execute...");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstructService postConstruct method execute...");
    }

    public void init(){
        System.out.println("PostConstructService init method execute...");
    }

    public Integer getF2() {
        return f2;
    }

    public void setF2(Integer f2) {
        this.f2 = f2;
        System.out.println("PostConstructService setF2 method execute...");
    }
}
