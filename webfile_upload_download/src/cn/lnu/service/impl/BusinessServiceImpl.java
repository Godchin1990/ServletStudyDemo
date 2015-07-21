package cn.lnu.service.impl;

import java.util.List;

import cn.lnu.dao.UpfileDao;
import cn.lnu.domain.Upfile;
import cn.lnu.factory.DaoFactory;
import cn.lnu.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	
	private UpfileDao dao=DaoFactory.getInstance().createDao(UpfileDao.class);//ʹ�ù���ģʽ����һ��dao
	
	public void addUpfile(Upfile upfile){//���ϴ��ļ���Ϣ���뵽���ݿ���
		dao.add(upfile);
	}
	
	public List getAllUpfile(){
		return dao.getAll();
	}
	//ͨ���ļ�id�����ϴ��ļ�
	public Upfile finUpfile(String id){
		return dao.find(id);
	}
}
