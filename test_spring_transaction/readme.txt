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

