//���ݿ�ͱ���ƣ�
create database dbXFFS character set utf8 collate utf8_general_ci;
use dbXFFS;

//�û������
create table users
(
	id varchar(40) primary key,
	username varchar(40) not null,
	password varchar(20) not null
);

insert into users(id,username,password) values('1','admin','admin');
insert into users(id,username,password) values('2','mushroom','123456');

//����������
create table mainface
(
	id varchar(40) primary key,
	btnname varchar(500) not null,
	btnid varchar(40) not null
);
ALTER TABLE mainface ADD unique('btnid');
insert into mainface(id,btnname,btnid) values ('01','��������֧��','1000');
insert into mainface(id,btnname,btnid) values ('02','��������֧��ѵ��','1004');
insert into mainface(id,btnname,btnid) values ('03','��������֧��ģ�⿼��ѵ��','1005');
insert into mainface(id,btnname,btnid) values ('04','��������֧�ֿ���','1006');
insert into mainface(id,btnname,btnid) values ('05','�ķθ��վ���','1007');

//��������֧��(01)
create table bls
(
	id varchar(40) primary key,
	btnname varchar(255) not null,
	btnid varchar(40) not null unique
);

insert into bls(id,btnname,btnid) values ('011','����','5');
insert into bls(id,btnname,btnid) values ('012','��ǰ','8');
insert into bls(id,btnname,btnid) values ('013','���','9');
insert into bls(id,btnname,btnid) values ('014','�ϼ��˵�','7');
insert into bls(id,btnname,btnid) values ('015','���˵�','6');
insert into bls(id,btnname,btnid) values ('016','����̨','10');
insert into bls(id,btnname,btnid) values ('017','�ر�','3');

//��������֧��ѵ����02��
create table blse
(
	id varchar(40) primary key,
	btnname varchar(255) not null,
	btnid varchar(40) not null unique
);

insert into blse(id,btnname,btnid) values ('021','��ʼѵ��','204');
insert into blse(id,btnname,btnid) values ('022','��λ','205');
insert into blse(id,btnname,btnid) values ('023','����ط�','206');
insert into blse(id,btnname,btnid) values ('024','ֹͣ�ط�','209');
insert into blse(id,btnname,btnid) values ('025','�ر�','203');

//��������֧��ģ�⿼��ѵ��(03)
create table blsmnkhe
(
	id varchar(40) primary key,
	btnname varchar(255) not null,
	btnid varchar(40) not null unique
);

insert into blsmnkhe(id,btnname,btnid) values ('031','��ʼ����','204');
insert into blsmnkhe(id,btnname,btnid) values ('032','����','205');
insert into blsmnkhe(id,btnname,btnid) values ('033','�����±�׼','206');
insert into blsmnkhe(id,btnname,btnid) values ('034','�Զ����׼','207');
insert into blsmnkhe(id,btnname,btnid) values ('035','����ط�','208');
insert into blsmnkhe(id,btnname,btnid) values ('036','ֹͣ�ط�','209');
insert into blsmnkhe(id,btnname,btnid) values ('037','�ر�','210');

//��������֧�ֿ���(04)
create table blskh
(
	id varchar(40) primary key,
	btnname varchar(255) not null,
	btnid varchar(40) not null unique
);

insert into blskh(id,btnname,btnid) values ('041','��ʼ����','404');
insert into blskh(id,btnname,btnid) values ('042','����','405');
insert into blskh(id,btnname,btnid) values ('043','�����±�׼','407');
insert into blskh(id,btnname,btnid) values ('044','�Զ����׼,'408');
insert into blskh(id,btnname,btnid) values ('045','����ط�','409');
insert into blskh(id,btnname,btnid) values ('046','ֹͣ�ط�','410');
insert into blskh(id,btnname,btnid) values ('047','�ر�','403');

//����042��
create table blskh042
(
	id varchar(40) primary key,
	btnname varchar(255) not null,
	btnid varchar(40) not null unique
);

insert into blskh042(id,btnname,btnid) values ('0421','����','323');
insert into blskh042(id,btnname,btnid) values ('0422','�ر�','324');


//�����±�׼��043��
create table blskh043
(
	id varchar(40) primary key,
	btnname varchar(255) not null,
	btnid varchar(40) not null unique
);

insert into blskh043(id,btnname,btnid) values ('0431','ȷ��','313');

//�Զ����׼(044)
create table blskh044
(
	id varchar(40) primary key,
	btnname varchar(255) not null,
	btnid varchar(40) not null unique
);

insert into blskh044(id,btnname,btnid) values ('0441','����','318');
insert into blskh044(id,btnname,btnid) values ('0442','ȡ��','319');

//�ķθ��վ���(05)

//�ķθ���ҳ��1�����
create table xffsface1
(
	id varchar(40) primary key,
	btnname varchar(255) not null,
	btnid varchar(40) not null unique
);

insert into xffsface1(id,btnname,btnid) values ('11','��ʼ','506');
insert into xffsface1(id,btnname,btnid) values ('12','����','504');

//�ķθ���ҳ��2�����
create table xffsface2
(
	id varchar(40) primary key,
	btnname varchar(255) not null,
	btnid varchar(40) not null unique
);

insert into xffsface2(id,btnname,btnid) values ('21','����','405');
insert into xffsface2(id,btnname,btnid) values ('22','����','424');
insert into xffsface2(id,btnname,btnid) values ('23','�����±�׼','407');
insert into xffsface2(id,btnname,btnid) values ('24','����ط�','409');
insert into xffsface2(id,btnname,btnid) values ('25','ֹͣ�ط�','410');

//�ķθ���ҳ��3�����
create table xffsface3
(
	id varchar(40) primary key,
	btnname varchar(255) not null,
	btnid varchar(40) not null unique
);

insert into xffsface3(id,btnname,btnid) values ('31','ȷ��','313');
