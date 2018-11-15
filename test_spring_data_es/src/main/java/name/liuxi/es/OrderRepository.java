package name.liuxi.es;


import name.liuxi.domain.Order;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 基础的repository接口
 *
 * spring data自动生成实现类，此处集成自定义的接口是为了在自动生成的实现类中添加自定义的实现（注意：实现类是这个基础的repository接口加上Impl后缀，这样才能被spring自动扫描到）
 *
 *  ElasticsearchRepository 继承 PagingAndSortingRepository, PagingAndSortingRepository提供了分页和排序的支持
 */
public interface OrderRepository extends ElasticsearchRepository<Order, Long>, OrderEsCommonRepository {

    /**
     * spring data提供的根据方法名称的查询方式
     * @param userName
     * @param skuName
     * @return
     */
    public Order findByUserNameAndSkuName(String userName, String skuName);

    /**
     * 使用Query注解指定查询语句
     * @param userName
     * @param skuName
     * @return
     */
    //双引号和不加引号都可，不能是单引号
//    @Query("{bool : {must : [ {field : {userName : ?}}, {field : {skuName : ?}} ]}}")   . //---   field查询已经废弃，可参考当前查询语法，已换成term查询
    @Query("{\"bool\" : {\"must\" : [ {\"term\" : {\"skuName\" : \"?1\"}}, {\"term\" : {\"userName\" : \"?0\"}} ]}}")
    //注意：需要替换的参数？需要加双引号；需要指定参数下标，从0开始
    public Order findByUserNameAndSkuName2(String userName, String skuName);

    //还有分页、排序等API
}
