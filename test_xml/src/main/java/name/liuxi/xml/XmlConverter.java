package name.liuxi.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlConverter {
    private static final Logger log = LoggerFactory.getLogger(XmlConverter.class);
    private static XmlConverter xmlConverter;
    private String path;
    private GroovyEngine engine;

    protected XmlConverter(String path) {
        this.path = path;
        this.load();
    }

    private void load() {
        try {
            this.engine = new GroovyEngine(Thread.currentThread().getContextClassLoader().getResourceAsStream(this.path));
        } catch (Exception var2) {
            log.error("XmlConverter load error", var2);
            throw new RuntimeException(var2);
        }
    }

    public String convert(String mqText) {
        String result = null;
        if(!"".equals(mqText)) {
            Object[] args = new Object[]{mqText};
            result = (String)this.engine.invokeMethod("convert", args);
        }

        return result;
    }

    public static synchronized XmlConverter getInstance(String path) {
        return xmlConverter == null?new XmlConverter(path):xmlConverter;
    }
}
