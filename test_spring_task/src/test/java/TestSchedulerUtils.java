import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liuxi6 on 2015/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-scheduler.xml")
public class TestSchedulerUtils
{
    /**
     * Spring�Դ��ĵ�����������������ֻ��Ҫ���������ļ����ܿ����������Ч�� ��ps : û���ҵ��ֶ����ƵĲ������߷�����������
     * @throws Exception
     */
    @Test
    public void test() throws Exception
    {
        //����junit����֮������jvm���˴������̵߳ȴ����ܲ����������Ч��
        Thread.sleep(1000000);

        //ע��۲���־�е�ִ��ʱ����
        //�ܽ᣺
//        1��������A������ʱ�򣬻�������A�ϴδ������߳��Ƿ��Ѿ�ִ����ɣ���û��ִ����ɣ��ᶪ�����εĴ�������
//        2���ܽ�1�еĽ������߳����޹أ������߳�Ϊ���̺߳Ͷ���߳�ʱ�򣬽��һ��

    }
}
