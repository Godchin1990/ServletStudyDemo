ʹ��jdbc��dbutils��Դ��ܲ������ݿ�
1�����ｨ��һ��java Project���̣���Ϊjdbc_dbutils
2,���������
	2.1����������Ҽ���Ŀ��jdbc_dbutils��New-->Folder,����һ��lib�ļ���
	2.2 ,������jar����ӵ�libĿ¼��
		mysql����
		commons-dbcp.jar  Ϊ��������ݿ������������ʹ��dbcp���ݿ����ӳ�
		commons-pool.jar		Ϊ��������ݿ������������ʹ��dbcp���ݿ����ӳ�
		��dbcp�ڹ�����������Ҫ�������ļ�dbcpconfig.properties�����Ի�Ҫ����������ļ�������srcĿ¼�£�
		commons-dbutils.jar  Ϊ�˼�jdbc��crud�ĸ������ϵ�jdbc���룬����Ҫ����dbutils��Դ��ܵ�jar��
	2.3 ��lib����ӵ�jar��build��������Ŀpath�У������ǣ�ѡ���ĸ�jar��������Ҽ���ѡ��Build Path-->Add to Build Path.
			����ʹ��jdbc������Դjdbc dbutils��ܵĿ����������������
			
	3.Ҫʹ�ÿ�Դ��ܲ������ݿ⣬��Ҫ�����ݿ�ı�������
	create database jdbc_dbutils;
	 use jdbc_dbutils;
	 create table users(
			id int primary key,
			name varchar(40),
			password varchar(40),
			email varchar(100),
			birthday date
			);
insert into users(id,name,password,email,birthday) values(1,'zs','123456','zx@sina.com','1980-10-15');
insert into users(id,name,password,email,birthday) values(2,'lisi','123456','lisi@sina.com','1980-10-15');
insert into users(id,name,password,email,birthday) values(3,'wangwu','123456','wangwu@sina.com','1980-10-15');
4,�ڲ���dbutilsʱ����Ҫ���䴫�����ݿ����ӳأ����Ի���Ҫд�����࣬�������ݿ����ӳ�
5,ʹ��dbutils������ݿ��crud����