package name.liuxi.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import name.liuxi.fastjson.deserializer.SonVoDeserializer;
import name.liuxi.fastjson.serialize.SonVoSerialize;
import name.liuxi.fastjson.vo.FatherVo;
import name.liuxi.fastjson.vo.SonVo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestJson {
    public static void main(String[] args) {
//        FatherVo father = new FatherVo();
//        father.setName("FF");
//        father.setAge("30");
//        father.setGender("1");
//
//        SonVo son = new SonVo();
//        son.setName("SS");
//        son.setAge("5");
//        son.setGender("1");
//        father.setSon(son);
//        SerializeConfig config = new SerializeConfig();
//        config.put(SonVo.class, new SonVoSerialize());
//        String json = JSON.toJSONString(father, config);
//        System.out.println("json-->" + json);
//
//        ParserConfig.getGlobalInstance().putDeserializer(SonVo.class, new SonVoDeserializer());
//        FatherVo fatherVo = JSON.parseObject(json, FatherVo.class);
//        System.out.println("object-->" + fatherVo);


//        String jsonArr = "[[\"a1\",\"\"],[\"b1\",\"b2\"]]";
//        ParserConfig config = ParserConfig.getGlobalInstance();
//
//        String[][] arr = JSON.parseObject(jsonArr, String[][].class);
////        String[][] arr = JSON.parseObject(jsonArr, String[][].class, Feature.config(JSON.DEFAULT_PARSER_FEATURE, Feature.AllowArbitraryCommas, false));
//        System.out.println("------------------------------");

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
//        for (String s : list){
//            if ("1".equals(s)){
//                list.remove(s);
//                System.out.println("+++++++++++++++++++++++" + list);
//            }
//            System.out.println("===============" + list);
//        }
//        System.out.println("-----------------" + list);

        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println("------------------------");
            String s = it.next();
            if ("2".equals(s)){
                list.remove(s);
//                System.out.println("+++++++++++++++++++++++" + list);
            }
//            System.out.println("===============" + list);
        }
//        System.out.println("-----------------" + list);
    }
}
