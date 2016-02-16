package com.interceptor;


import com.dao.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;

/**
 * Created by liuxi6 on 2016/1/11.
 */
//@Order(0)  // execute before @Transactional  或者在spring配置文件中配置切面时候指定order=0   //经测试：order在此处指定不能保证在事物直接之前执行。需要在xml中配置
public class DataSourceInterceptor {

    /**
     * 根据规则动态路由数据源
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
