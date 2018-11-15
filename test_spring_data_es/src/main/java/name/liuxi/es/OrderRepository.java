package name.liuxi.es;


import name.liuxi.domain.Order;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ������repository�ӿ�
 *
 * spring data�Զ�����ʵ���࣬�˴������Զ���Ľӿ���Ϊ�����Զ����ɵ�ʵ����������Զ����ʵ�֣�ע�⣺ʵ���������������repository�ӿڼ���Impl��׺���������ܱ�spring�Զ�ɨ�赽��
 *
 *  ElasticsearchRepository �̳� PagingAndSortingRepository, PagingAndSortingRepository�ṩ�˷�ҳ�������֧��
 */
public interface OrderRepository extends ElasticsearchRepository<Order, Long>, OrderEsCommonRepository {

    /**
     * spring data�ṩ�ĸ��ݷ������ƵĲ�ѯ��ʽ
     * @param userName
     * @param skuName
     * @return
     */
    public Order findByUserNameAndSkuName(String userName, String skuName);

    /**
     * ʹ��Queryע��ָ����ѯ���
     * @param userName
     * @param skuName
     * @return
     */
    //˫���źͲ������Ŷ��ɣ������ǵ�����
//    @Query("{bool : {must : [ {field : {userName : ?}}, {field : {skuName : ?}} ]}}")   . //---   field��ѯ�Ѿ��������ɲο���ǰ��ѯ�﷨���ѻ���term��ѯ
    @Query("{\"bool\" : {\"must\" : [ {\"term\" : {\"skuName\" : \"?1\"}}, {\"term\" : {\"userName\" : \"?0\"}} ]}}")
    //ע�⣺��Ҫ�滻�Ĳ�������Ҫ��˫���ţ���Ҫָ�������±꣬��0��ʼ
    public Order findByUserNameAndSkuName2(String userName, String skuName);

    //���з�ҳ�������API
}
