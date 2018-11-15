package name.liuxi.service.impl;

import name.liuxi.domain.Order;
import name.liuxi.es.OrderRepository;
import name.liuxi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 创建索引
     */
    public boolean creatIndex(){
        return orderRepository.createOrderIndex();
    }

    /**
     * 保存
     */
    public Order save(Order order){
        return orderRepository.save(order);
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public Order findOneById(Long id){
        return orderRepository.findOne(id);
    }

    /**
     * 根据字段查询 -- 方法名
     * @return
     */
    public Order findOneByUserNameAndSkuName(Order order){
        return orderRepository.findByUserNameAndSkuName(order.getUserName(), order.getSkuName());
    }

    /**
     * 根据字段查询 -- 注解
     * @return
     */
    public Order findOneByUserNameAndSkuName2(Order order){
        return orderRepository.findByUserNameAndSkuName2(order.getUserName(), order.getSkuName());
    }
}
