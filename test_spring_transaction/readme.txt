ע������ʵ��ǰ��׼����
1��ȷ�����mysql�洢������InnoDB��MyISAM��֧������

2������
    DROP TABLE IF EXISTS test_user ;
    CREATE TABLE test_user(
        user_id INT AUTO_INCREMENT PRIMARY KEY,
        user_name VARCHAR(20)
    )ENGINE=INNODB DEFAULT CHARSET=utf8;

    �������ݣ�
    INSERT INTO test_user (user_name) VALUES ('zhangsan'),('lisi');

3������mysql������뼶�𣬷���۲�����ִ�С��ع�
     ����session�ĸ��뼶��ΪREAD-UNCOMMITTED���ɣ�mysqlĬ�ϵĸ��뼶��ΪREPEATABLE-READ

     ȫ�֣�
     SHOW GLOBAL VARIABLES LIKE '%iso%';
     SELECT @@global.tx_isolation;
     SET GLOBAL tx_isolation='REPEATABLE-READ';

     session����
     SHOW  VARIABLES LIKE '%iso%';
     SELECT @@session.tx_isolation;
     SET tx_isolation='READ-UNCOMMITTED';

