import name.liuxi.domain.Order;
import name.liuxi.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config-es.xml")
public class TestEs {

    @Autowired
    private OrderService orderService;

    /**
     * ��������
     */
    @Test
    public void createOrderIndex(){
        boolean res = orderService.creatIndex();
        Assert.assertTrue(res);
    }

    /**
     * ����
     */
    @Test
    public void save(){
        Long id = 100000000L;
        Order order = new Order();
        order.setId(id);
        order.setUserName("zhangsan");
        order.setSkuName("iphone888s");
        Order res = orderService.save(order);
        Assert.assertNotNull(res);
        Assert.assertEquals(res.getId().longValue(), id.longValue());
        System.out.println(order);
    }

    /**
     * ����������ѯ
     */
    @Test
    public void findOneById(){
        Long id = 100000000L;
        Order res =  orderService.findOneById(id);
        Assert.assertNotNull(res);
        Assert.assertEquals(res.getId().longValue(), id.longValue());
        System.out.println(res);
    }

    /**
     * �����ֶβ�ѯ
     * @return
     */
    @Test
    public void findOneByUserNameAndSkuName(){
        Long id = 100000000L;
        Order order = new Order();
        order.setUserName("zhangsan");
        order.setSkuName("iphone888s");
        Order res =  orderService.findOneByUserNameAndSkuName(order);
        Assert.assertNotNull(res);
        Assert.assertEquals(res.getId().longValue(), id.longValue());
        System.out.println(res);
    }

    /**
     * �����ֶβ�ѯ -- ע��
     * @return
     */
    @Test
    public void findOneByUserNameAndSkuName2(){
        Long id = 100000000L;
        Order order = new Order();
        order.setUserName("zhangsan");
        order.setSkuName("iphone888s");
        Order res =  orderService.findOneByUserNameAndSkuName2(order);
        System.out.println(res);
        Assert.assertNotNull(res);
        Assert.assertEquals(res.getId().longValue(), id.longValue());
    }
}
