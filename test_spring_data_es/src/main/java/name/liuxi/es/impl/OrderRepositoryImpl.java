package name.liuxi.es.impl;

import name.liuxi.domain.Order;
import name.liuxi.es.OrderEsCommonRepository;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * �Զ���Repositoryʵ����
 *
 * �ӿڵ�ʵ�������ֺ�׺����Ϊimpl������ɨ���ʱ���ҵ����ɲο�spring data elasticsearch�Զ���repository�½ڣ�
 *
 */
public class OrderRepositoryImpl implements OrderEsCommonRepository {

    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * ��������
     * @return
     */
    public boolean createOrderIndex() {
        return elasticsearchTemplate.createIndex(Order.class);
    }


    //�Զ���ʵ�ֿ���ʹ��ElasticsearchTemplate�����ӵĲ�ѯ�����磺���顢�ۺϵȣ�
    //������spring data elasticsearch�����ȣ�ʹ�÷����������Queryע��ʵ�����ѵĲ�ѯ�������ɽ���ElasticsearchTemplateʵ���Զ���Ĳ�ѯ


    public void setElasticsearchTemplate(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }
}
