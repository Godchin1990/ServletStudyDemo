.1.�����
	1.1��������
		mysql����
		beanUtils
		log4j������
		jstl������
		
	1.2 ������֯����İ�
		cn.lnu.domain
		cn.lnu.dao
		cn.lnu.dao.impl
		cn.lnu.service
		cn.lnu.service.impl
		cn.lnu.web.controller
		cn.lnu.web.UI
		cn,lnu.utils
		cn.lnu.exception
		junit.test
		
		/WEB-INF/jsp
		
	1.3 ΪӦ�ô�����Ӧ�Ŀ�ͱ�
		create database jdbc_customer character set utf8 collate utf8_general_ci;
		use jdbc_customer;
		
		create table customer(
			id varchar(40) primary key,
			name varchar(40) not null,
			gender varchar(4) not null,
			birthday date,
			cellphone varchar(20),
			email varchar(40),
			preference varchar(255),
			type varchar(100) not null,
			description varchar(255)
			
		);
		
	2. ��ʵ�壬����ָ������cn.lnu.domain����Customer�࣬�������ݿ���ͬ���ֶ�
	
	3��дdao��,����cn.lnu.dao.impl������CustomerDaoImpl�࣬����������Ʒ������������еĹ������룬д��һ���������У�������ƺ�֮�󣬳���ӿڵ�dao�Ľӿڰ�
	
	4.дservice�㣬����cn.lnu.service.impl���Ͻ���BusinessServiceImpl�࣬����service��web���ṩʲô��������Ʒ���,�������еĹ������룬д��һ���������У�������ƺ�֮�󣬳���ӿڵ�service�Ľӿڰ�
	
	5,дweb��
			ͨ������վ��ҳ���û��ṩ���ܣ�����ɾ�Ĳ��û�