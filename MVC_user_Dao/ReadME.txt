1.���������
	1.1 ���뿪����
			dom4j(����xml)+xpath��jaxen��������
			jstl��������JSP el+jstl��
			beanUtils������(JavaBean)
			log4j������(���beanUtils����)
			commons_logging������(���beanUtils����)
	1.2 ������֯����İ�
		cn.lnu.domain
		cn.lnu.dao
		cn.lnu.dao.impl
		cn.lnu.service
		cn.lnu.service.impl
		cn.lnu.web.controller�����������servlet��
		cn.lnu.web.UI ��Ϊ�û��ṩ�û����� ��servlet��
		cn.lnu.utils	��������������ڱ�д��Ҫ�������ʵĴ��룬����˵��ɾ�Ĳ鷽������Ҫ�������ݿ���Ƕδ�����߶���Ҫ����xml�ĵ����Ƕδ��룩
		junit.test	(���Գ����)
		
		WEB-INF/jsp	(������վ����jsp)
	1.3	�����������ݿ��xml�ļ�(ʵ�ʿ������������ݿ�)
		����Ŀ¼�´���һ���������ݿ��users.xml���ļ�
		
		--------------------------------------------------------------------------------
		��������ݿ�Ӧ�ã�
		1.�������ݿ�����
		2��ΪӦ�ô�����Ӧ�Ŀ�ͱ�
		3������dao ��cn.lnu.dao.impl��
		
		<user id="1" username="mushroom" password="123" email="862998@qq.com" birthday="1990-09-10" nickname="mogu" />
		
		create database MVC_user_Dao;
		use MVC_user_Dao;
		create table users(
			id varchar(40) primary key,
			username varchar(40) not null unique,
			password varchar(40) not null unique,
			email varchar(100) not null unique,
			birthday date,
			nickname varchar(40) not null
			);
			
			