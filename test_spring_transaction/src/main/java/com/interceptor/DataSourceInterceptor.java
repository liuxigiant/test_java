package com.interceptor;


import com.dao.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;

/**
 * Created by liuxi6 on 2016/1/11.
 */
//@Order(0)  // execute before @Transactional  ������spring�����ļ�����������ʱ��ָ��order=0   //�����ԣ�order�ڴ˴�ָ�����ܱ�֤������ֱ��֮ǰִ�С���Ҫ��xml������
public class DataSourceInterceptor {

    /**
     * ���ݹ���̬·������Դ
     * @param joinpoint
     */
    public void setDataSource(JoinPoint joinpoint){
//        String targetClassName = joinpoint.getTarget().getClass().getName();
        String targetMethodName = joinpoint.getSignature().getName();
        if (targetMethodName.startsWith("add")){
            DataSourceContextHolder.setDataSourceType("dataSource1");
        }else if (targetMethodName.startsWith("update")){
            DataSourceContextHolder.setDataSourceType("dataSource2");
        }
//        else{
//            DataSourceContextHolder.setDataSourceType("dataSource1");
//        }

    }
}
