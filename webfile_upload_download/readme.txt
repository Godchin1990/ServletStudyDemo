1��׼������
	1.1���뿪����
		(dao���)
		mysql����
		c3p0���ӳ� (�Ż�jdbc����)��c3p0�ڹ�����ʱ����Ҫһ�������ļ�c3p0-config.xml֧�֣����䵼�뵽src��Ŀ¼��
		dbutils��ܰ� (��jdbc����)
		
		��web�㿪������
		fileupload���(��Ҫio����֧��)
		io��
		
		beanUtils�������������������ݷ�װ��bean��
		log4j֧��beanUtils��
		
		jstl������
	1.2 ������֯����İ�
	
	1.3 ��֯��ͱ�	
		create database webfile_upload_download character set utf8 collate utf8_general_ci;
		use webfile_upload_download;
		create table upfile
		(
			id varchar(40) primary key,
			uuidname varchar(100) not null unique,
			realname varchar(100) not null,
			savepath varchar(255) not null,
			uptime datetime not null,
			description varchar(255),
			username varchar(40) not null
		);
		
2.��ʵ��

3.��dao

4.��service

5.��web�㣨����ҳ��ʼд��
