package cn.lnu.service.impl;
//�ǵ����ʵ����д��֮�󣬽�ʵ����ķ����ع���һ���ӿڰ��У����巽������BusinessServiceImpl.java��������Ҽ���ѡ��Refactor-->Extract Interface,��ѡ�⼸������������ӿ������������ΪBusinessService��Ȼ����BusinessService���Ҽ�,Refactor-->Move,������ӿ��ƶ����ӿڰ�cn.lnu.service��
import java.util.List;

import cn.lnu.dao.CustomerDao;
import cn.lnu.dao.impl.CustomerDaoImpl;
import cn.lnu.domain.Customer;
import cn.lnu.domain.PageBean;
import cn.lnu.domain.QueryInfo;
import cn.lnu.domain.QueryResult;
import cn.lnu.service.BusinessService;

//ҵ���߼������service��web���ṩʲô��������Ʒ���,��������ӿͻ��ķ���ȵȣ���Ҫ�ǵ���dao��ķ�������web�������
public class BusinessServiceImpl implements BusinessService {
	
	private CustomerDao dao=new CustomerDaoImpl();//����Ϊ�˽����Ҫʹ�ù���ģʽ������Ͳ���ô���ˣ�ֱ��new��һ���ӿ�
	
	//����web�����Ҫ����µ��û�����web����Ҫ��ӵ��û�
	public void addCustomer(Customer c){
		dao.add(c);
	}
	//web��Ҫ����һ���û�
	public void updateCustomer(Customer c){
		dao.update(c);
	}
	//web��Ҫɾ��һ���û�
	public void deleteCustomer(String id){
		dao.delete(id);
	}
	//web��Ҫ����һ���û�
	public Customer findCustomer(String id){
		return dao.find(id);
	}
	
	public List<Customer> getAllCustomer(){
		return dao.getAll();
	}
	
	
	//���ܲ�ѯ�������󣬵��ò�ѯ������󣬷���ҳ��Ҫ��ʾ��pageBean
	public PageBean pageQuery(QueryInfo queryinfo){
		//����dao��ȡ��ҳ���ѯ���
		QueryResult qr=dao.pageQuery(queryinfo.getStartindex(), queryinfo.getPagesize());
		//����dao��ѯ���������ҳ����ʾ��Ҫ��pagebean
		PageBean bean=new PageBean();
		bean.setCurrentpage(queryinfo.getCurrentpage());
		bean.setList(qr.getList());
		bean.setPagesize(queryinfo.getPagesize());
		bean.setTotalrecord(qr.getTotalrecord());
		return bean;
	}
	
}
