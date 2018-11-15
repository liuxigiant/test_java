package name.liuxi.xml;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class GroovyEngine {
    private static final Logger log = LoggerFactory.getLogger(XmlConverter.class);
    private GroovyObject instance = null;

    public GroovyEngine(InputStream script) {
        this.createInstance(script);
    }

    private void createInstance(InputStream script) {
        try {
            ClassLoader e = GroovyEngine.class.getClassLoader();
            GroovyClassLoader loader = new GroovyClassLoader(e);
            Class groovyClass = loader.parseClass(script);
            this.instance = (GroovyObject)groovyClass.newInstance();
            script.close();
            script = null;
        } catch (Exception var5) {
            log.error("Groovy script is error", var5);
            throw new RuntimeException(var5);
        }
    }

    public Object invokeMethod(String methodName, Object[] args) {
        return this.instance.invokeMethod(methodName, args);
    }

    public Object getInstance() {
        return this.instance;
    }
}
