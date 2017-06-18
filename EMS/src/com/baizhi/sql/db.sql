##创建数据库
drop database if exists mydb;
create database mydb;
use mydb;

##创建用户表
create table user(
 id int primary key auto_increment,
 account varchar(20),
 password varchar(20)
);

##用户表插入数据
insert into user(account,password) values ('admin','admin');
insert into user(account,password) values ('admin1','admin1');
insert into user(account,password) values ('admin2','admin2');
insert into user(account,password) values ('admin3','admin3');
insert into user(account,password) values ('admin4','admin4');
insert into user(account,password) values ('admin5','admin5');
insert into user(account,password) values ('admin6','admin6');
insert into user(account,password) values ('admin7','admin7');
insert into user(account,password) values ('admin8','admin8');
insert into user(account,password) values ('admin9','admin9');

##创建通讯录
create table emp(
 id int primary key auto_increment,
 name varchar(20),
 salary int,
 birthday date
);

##通讯录插入数据
insert into emp(name,salary,birthday) values ('daijin','10000','1997-6-1');
insert into emp(name,salary,birthday) values ('代槿','20000','1998-6-1');
insert into emp(name,salary,birthday) values ('待如故','30000','1999-6-1');
insert into emp(name,salary,birthday) values ('如故','40000','2000-6-1');
insert into emp(name,salary,birthday) values ('故','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('12','50000','2002-6-1');
insert into emp(name,salary,birthday) values ('代价那','50000','2003-6-1');
insert into emp(name,salary,birthday) values ('阿瓦达我留','50000','2004-6-1');
insert into emp(name,salary,birthday) values ('阿萨德按时的留','50000','2005-6-1');
insert into emp(name,salary,birthday) values ('啊实打实留','50000','2007-6-1');
insert into emp(name,salary,birthday) values ('打算打留','50000','2008-6-1');
insert into emp(name,salary,birthday) values ('阿萨德留','50000','2009-6-1');
insert into emp(name,salary,birthday) values ('阿萨德留','50000','2010-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2011-6-1');
insert into emp(name,salary,birthday) values ('按时的留','50000','2012-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2013-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2014-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2015-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2016-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2017-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2018-6-1');
insert into emp(name,salary,birthday) values ('按时的留','50000','2019-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('撒的留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');
insert into emp(name,salary,birthday) values ('逗留','50000','2001-6-1');