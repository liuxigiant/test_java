import name.liuxi.xml.XmlConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration("classpath:spring-config-util.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestXml {
    @Resource(name = "converter")
    private XmlConverter converter;

    @Test
    public void testConvertXml(){
        {
            String xml = "";

            String json = converter.convert(xml);
            System.out.println("json--------------------->" + json);
        }
    }
}
