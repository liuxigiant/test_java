package com.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ��̬����Դ
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected String determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }
}
