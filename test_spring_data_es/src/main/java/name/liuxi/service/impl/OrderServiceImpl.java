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
     * ��������
     */
    public boolean creatIndex(){
        return orderRepository.createOrderIndex();
    }

    /**
     * ����
     */
    public Order save(Order order){
        return orderRepository.save(order);
    }

    /**
     * ����������ѯ
     * @param id
     * @return
     */
    public Order findOneById(Long id){
        return orderRepository.findOne(id);
    }

    /**
     * �����ֶβ�ѯ -- ������
     * @return
     */
    public Order findOneByUserNameAndSkuName(Order order){
        return orderRepository.findByUserNameAndSkuName(order.getUserName(), order.getSkuName());
    }

    /**
     * �����ֶβ�ѯ -- ע��
     * @return
     */
    public Order findOneByUserNameAndSkuName2(Order order){
        return orderRepository.findByUserNameAndSkuName2(order.getUserName(), order.getSkuName());
    }
}
