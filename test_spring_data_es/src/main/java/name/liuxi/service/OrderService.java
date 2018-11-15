package name.liuxi.service;

import name.liuxi.domain.Order;


public interface OrderService {

    /**
     * 创建索引
     */
    public boolean creatIndex();

    /**
     * 保存
     */
    public Order save(Order order);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public Order findOneById(Long id);

    /**
     * 根据字段查询
     * @return
     */
    public Order findOneByUserNameAndSkuName(Order order);

    /**
     * 根据字段查询 -- 注解
     * @return
     */
    public Order findOneByUserNameAndSkuName2(Order order);
}
