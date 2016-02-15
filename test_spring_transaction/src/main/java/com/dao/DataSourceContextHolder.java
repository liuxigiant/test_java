package com.dao;

/**
 * DataSource上下文句柄，通过此类设置需要访问的对应数据源
 */
public class DataSourceContextHolder {
    /**
     * DataSource上下文，每个线程对应相应的数据源key
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSourceType(String dataSourceType){
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType(){
        return contextHolder.get();
    }

    public static void clearDataSourceType(){
        contextHolder.remove();
    }
}
