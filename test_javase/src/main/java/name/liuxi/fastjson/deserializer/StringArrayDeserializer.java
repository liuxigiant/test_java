package name.liuxi.fastjson.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

public class StringArrayDeserializer implements ObjectDeserializer {

    @Override
    public int getFastMatchToken() {
        return 0;
    }

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
        System.out.println("-----------------");
        return null;
    }
}
