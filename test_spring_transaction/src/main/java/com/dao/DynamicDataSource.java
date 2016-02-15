package com.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected String determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }
}
