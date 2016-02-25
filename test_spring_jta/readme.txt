参照：http://blog.csdn.net/taxuexunmei414923794/article/details/7673246

注解事物实践前期准备：
1、确保表的mysql存储引擎是InnoDB，MyISAM不支持事物

2、建表
    DROP TABLE IF EXISTS test_user ;
    CREATE TABLE test_user(
        user_id INT AUTO_INCREMENT PRIMARY KEY,
        user_name VARCHAR(20)
    )ENGINE=INNODB DEFAULT CHARSET=utf8;

    测试数据：
    INSERT INTO test_user (user_name) VALUES ('zhangsan'),('lisi');

3、配置mysql事物隔离级别，方便观察事物执行、回滚
     配置session的隔离级别为READ-UNCOMMITTED即可，mysql默认的隔离级别为REPEATABLE-READ

     全局：
     SHOW GLOBAL VARIABLES LIKE '%iso%';
     SELECT @@global.tx_isolation;
     SET GLOBAL tx_isolation='REPEATABLE-READ';

     session级别：
     SHOW  VARIABLES LIKE '%iso%';
     SELECT @@session.tx_isolation;
     SET tx_isolation='READ-UNCOMMITTED';




日志：

信息: AtomikosDataSoureBean 'mysql/test_transaction': getConnection ( null )...
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: AtomikosDataSoureBean 'mysql/test_transaction': init...
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: atomikos connection proxy for com.mysql.jdbc.jdbc2.optional.JDBC4ConnectionWrapper@13fe2493: calling getAutoCommit...
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: addParticipant ( XAResourceTransaction: 31302E302E35372E38342E746D30303030313030303032:31302E302E35372E38342E746D31 ) for transaction 10.0.57.84.tm0000100002
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: XAResource.start ( 31302E302E35372E38342E746D30303030313030303032:31302E302E35372E38342E746D31 , XAResource.TMNOFLAGS ) on resource mysql/test_transaction represented by XAResource instance com.mysql.jdbc.jdbc2.optional.JDBC4MysqlXAConnection@639d0e0b
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: registerSynchronization ( com.atomikos.jdbc.AtomikosConnectionProxy$JdbcRequeueSynchronization@3eb7f32d ) for transaction 10.0.57.84.tm0000100002
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: atomikos connection proxy for com.mysql.jdbc.jdbc2.optional.JDBC4ConnectionWrapper@13fe2493: calling prepareStatement(insert into test_user (user_name) VALUES (?))...
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: AtomikosDataSoureBean 'mysql/test_transaction2': getConnection ( null )...
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: AtomikosDataSoureBean 'mysql/test_transaction2': init...
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: atomikos connection proxy for com.mysql.jdbc.jdbc2.optional.JDBC4ConnectionWrapper@2c013ada: calling getAutoCommit...
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: addParticipant ( XAResourceTransaction: 31302E302E35372E38342E746D30303030313030303032:31302E302E35372E38342E746D32 ) for transaction 10.0.57.84.tm0000100002
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: XAResource.start ( 31302E302E35372E38342E746D30303030313030303032:31302E302E35372E38342E746D32 , XAResource.TMNOFLAGS ) on resource mysql/test_transaction2 represented by XAResource instance com.mysql.jdbc.jdbc2.optional.JDBC4MysqlXAConnection@4bed4c8
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: registerSynchronization ( com.atomikos.jdbc.AtomikosConnectionProxy$JdbcRequeueSynchronization@3eb7f32d ) for transaction 10.0.57.84.tm0000100002
2016-2-25 21:08:30 com.atomikos.logging.JULLogger logInfo
信息: atomikos connection proxy for com.mysql.jdbc.jdbc2.optional.JDBC4ConnectionWrapper@2c013ada: calling prepareStatement(insert into test_user (user_name) VALUES (?))...
2016-2-25 21:08:41 com.atomikos.logging.JULLogger logInfo
信息: atomikos connection proxy for com.mysql.jdbc.jdbc2.optional.JDBC4ConnectionWrapper@13fe2493: close()...
2016-2-25 21:08:41 com.atomikos.logging.JULLogger logInfo
信息: XAResource.end ( 31302E302E35372E38342E746D30303030313030303032:31302E302E35372E38342E746D31 , XAResource.TMSUCCESS ) on resource mysql/test_transaction represented by XAResource instance com.mysql.jdbc.jdbc2.optional.JDBC4MysqlXAConnection@639d0e0b
2016-2-25 21:08:41 com.atomikos.logging.JULLogger logInfo
信息: atomikos connection proxy for com.mysql.jdbc.jdbc2.optional.JDBC4ConnectionWrapper@2c013ada: close()...
2016-2-25 21:08:41 com.atomikos.logging.JULLogger logInfo
信息: XAResource.end ( 31302E302E35372E38342E746D30303030313030303032:31302E302E35372E38342E746D32 , XAResource.TMSUCCESS ) on resource mysql/test_transaction2 represented by XAResource instance com.mysql.jdbc.jdbc2.optional.JDBC4MysqlXAConnection@4bed4c8
2016-2-25 21:08:41 com.atomikos.logging.JULLogger logInfo
信息: XAResource.rollback ( 31302E302E35372E38342E746D30303030313030303032:31302E302E35372E38342E746D31 ) on resource mysql/test_transaction represented by XAResource instance com.mysql.jdbc.jdbc2.optional.JDBC4MysqlXAConnection@639d0e0b
2016-2-25 21:08:41 com.atomikos.logging.JULLogger logInfo
信息: XAResource.rollback ( 31302E302E35372E38342E746D30303030313030303032:31302E302E35372E38342E746D32 ) on resource mysql/test_transaction2 represented by XAResource instance com.mysql.jdbc.jdbc2.optional.JDBC4MysqlXAConnection@4bed4c8
2016-2-25 21:08:41 com.atomikos.logging.JULLogger logInfo
信息: rollback() done of transaction 10.0.57.84.tm0000100002
2016-2-25 21:08:41 org.springframework.context.support.GenericApplicationContext doClose