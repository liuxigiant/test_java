package name.liuxi.spring.ext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestContainer {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring-config.xml");


        System.out.println("https" + "http://aaaa".substring(4));
    }
}
