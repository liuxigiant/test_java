package name.liuxi.es.impl;

import name.liuxi.domain.Order;
import name.liuxi.es.OrderEsCommonRepository;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * 自定义Repository实现类
 *
 * 接口的实现类名字后缀必须为impl才能在扫描包时被找到（可参考spring data elasticsearch自定义repository章节）
 *
 */
public class OrderRepositoryImpl implements OrderEsCommonRepository {

    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 创建索引
     * @return
     */
    public boolean createOrderIndex() {
        return elasticsearchTemplate.createIndex(Order.class);
    }


    //自定义实现可以使用ElasticsearchTemplate做复杂的查询，例如：分组、聚合等，
    //增加了spring data elasticsearch的灵活度，使用方法名定义和Query注解实现困难的查询操作，可借助ElasticsearchTemplate实现自定义的查询


    public void setElasticsearchTemplate(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }
}
