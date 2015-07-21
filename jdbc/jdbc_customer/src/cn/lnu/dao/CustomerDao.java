package cn.lnu.dao;

import java.util.List;

import cn.lnu.domain.Customer;
import cn.lnu.domain.QueryResult;

public interface CustomerDao {

	void add(Customer c);

	void update(Customer c);

	void delete(String id);

	Customer find(String id);

	//ȡ�����ݿ��������û�����󱣴浽һ��list������
	List<Customer> getAll();

	public QueryResult pageQuery(int startindex,int pagesize);
}