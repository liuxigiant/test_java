package name.liuxi.fastjson.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import name.liuxi.fastjson.vo.SonVo;

import java.lang.reflect.Type;

public class SonVoDeserializer implements ObjectDeserializer {
    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        String value = lexer.stringVal();
        lexer.nextToken(16);
        SonVo son = new SonVo();
        son.setName(value);
        return (T)son;
    }

//    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
//        JSONLexer lexer = parser.getLexer();
//        Object val;
//        if(lexer.token() == 2) {
//            val = Long.valueOf(lexer.longValue());
//            lexer.nextToken(16);
//        } else {
//            String key;
//            if(lexer.token() == 4) {
//                key = lexer.stringVal();
//                val = key;
//                lexer.nextToken(16);
//                if(lexer.isEnabled(Feature.AllowISO8601DateFormat)) {
//                    JSONScanner timeMillis = new JSONScanner(key);
//                    if(timeMillis.scanISO8601DateIfMatch()) {
//                        val = timeMillis.getCalendar().getTime();
//                    }
//
//                    timeMillis.close();
//                }
//            } else if(lexer.token() == 8) {
//                lexer.nextToken();
//                val = null;
//            } else if(lexer.token() == 12) {
//                lexer.nextToken();
//                if(lexer.token() != 4) {
//                    throw new JSONException("syntax error");
//                }
//
//                key = lexer.stringVal();
//                if(JSON.DEFAULT_TYPE_KEY.equals(key)) {
//                    lexer.nextToken();
//                    parser.accept(17);
//                    String timeMillis1 = lexer.stringVal();
//                    Class type = TypeUtils.loadClass(timeMillis1);
//                    if(type != null) {
//                        clazz = type;
//                    }
//
//                    parser.accept(4);
//                    parser.accept(16);
//                }
//
//                lexer.nextTokenWithColon(2);
//                if(lexer.token() != 2) {
//                    throw new JSONException("syntax error : " + lexer.tokenName());
//                }
//
//                long timeMillis2 = lexer.longValue();
//                lexer.nextToken();
//                val = Long.valueOf(timeMillis2);
//                parser.accept(13);
//            } else if(parser.getResolveStatus() == 2) {
//                parser.setResolveStatus(0);
//                parser.accept(16);
//                if(lexer.token() != 4) {
//                    throw new JSONException("syntax error");
//                }
//
//                if(!"val".equals(lexer.stringVal())) {
//                    throw new JSONException("syntax error");
//                }
//
//                lexer.nextToken();
//                parser.accept(17);
//                val = parser.parse();
//                parser.accept(13);
//            } else {
//                val = parser.parse();
//            }
//        }
//
//        return this.cast(parser, (Type)clazz, fieldName, val);
//    }
//
//    private  <T> T cast(DefaultJSONParser parser, Type clazz, Object fieldName, Object val) {
//        SonVo son = new SonVo();
//        son.setName((String)val);
//        return (T)son;
//    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
