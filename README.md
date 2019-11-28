# microservicecloud
SpringCloud Study Demo

该项目为学习SpringCloud时的Demo，该项目父工程microservicecloud为maven项目，其内部有众多模块。

该项目的创建环境为Eclipse，数据库为MYSQL。数据库有三个，分别是cloudDB01、cloudDB02、cloudDB03。

创建数据库的SQL语句如下：

```sql
DROP DATABASE IF EXISTS cloudDB01;
CREATE DATABASE cloudDB01 CHARACTER SET UTF8;
USE cloudDB01;
CREATE TABLE dept
(
	deptno BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	dname VARCHAR(60),
	db_source VARCHAR(60)
);

INSERT INTO dept(dname,db_source) VALUES('开发部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('人事部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('财务部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('市场部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('运维部',DATABASE());
```

