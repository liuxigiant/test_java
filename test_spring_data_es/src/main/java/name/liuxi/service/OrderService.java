package name.liuxi.service;

import name.liuxi.domain.Order;


public interface OrderService {

    /**
     * ��������
     */
    public boolean creatIndex();

    /**
     * ����
     */
    public Order save(Order order);

    /**
     * ����������ѯ
     * @param id
     * @return
     */
    public Order findOneById(Long id);

    /**
     * �����ֶβ�ѯ
     * @return
     */
    public Order findOneByUserNameAndSkuName(Order order);

    /**
     * �����ֶβ�ѯ -- ע��
     * @return
     */
    public Order findOneByUserNameAndSkuName2(Order order);
}
