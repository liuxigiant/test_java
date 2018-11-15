package name.liuxi.spring.aop.service.impl;

import name.liuxi.spring.aop.service.ServiceClass;
import org.springframework.stereotype.Service;

@Service
public class ServiceClassImpl implements ServiceClass {
    public void service(){
        System.out.println("working hard ...");
        drink();
//        throw new RuntimeException("1111111111");
    }

    private void drink(){
        System.out.println("drinking water ...");
    }

}
