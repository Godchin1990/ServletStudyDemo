package cn.lnu.service;

import java.util.List;

import cn.lnu.domain.Customer;
import cn.lnu.domain.PageBean;
import cn.lnu.domain.QueryInfo;

public interface BusinessService {

	//����web�����Ҫ����µ��û�����web����Ҫ��ӵ��û�
	void addCustomer(Customer c);

	//web��Ҫ����һ���û�
	void updateCustomer(Customer c);

	//web��Ҫɾ��һ���û�
	void deleteCustomer(String id);

	//web��Ҫ����һ���û�
	Customer findCustomer(String id);

	List<Customer> getAllCustomer();

	public PageBean pageQuery(QueryInfo queryinfo);
}