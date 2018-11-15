package name.liuxi.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorService implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessorService postProcessBeanFactory method execut...");
        BeanDefinition bd = beanFactory.getBeanDefinition("user");
        MutablePropertyValues pv =  bd.getPropertyValues();
        if(pv.contains("userName"))
        {
            pv.addPropertyValue("userName", "heihei");
        }
    }
}
