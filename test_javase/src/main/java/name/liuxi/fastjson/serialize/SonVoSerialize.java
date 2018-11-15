package name.liuxi.fastjson.serialize;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import name.liuxi.fastjson.vo.SonVo;

import java.io.IOException;
import java.lang.reflect.Type;

public class SonVoSerialize implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        if(object == null) {
            if(out.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                out.write("[]");
            } else {
                out.writeNull();
            }

        } else {
            SonVo son = (SonVo)object;
            out.writeString(son.getName());
        }
    }
}
