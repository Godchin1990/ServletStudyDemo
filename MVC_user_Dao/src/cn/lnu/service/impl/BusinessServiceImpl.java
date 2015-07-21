package cn.lnu.service.impl;

import cn.lnu.dao.UserDao;
import cn.lnu.domain.User;
import cn.lnu.exception.UserExistException;
import cn.lnu.factory.DaoFactory;
import cn.lnu.utils.ServiceUtils;
//serviceʵ�ֲ�
//��web���ṩ���е�ҵ����񣨸���ҵ�����󣩣��������ṩע��͵�½��������(����Ҫ��ѯ���ݿ�)
public class BusinessServiceImpl {
	
	//private UserDao dao=new UserDaoJdbcImpl();//Ҫ��ײ�dao��仯�ˣ��ϲ㲻���޸��������ʹ�ù���ģʽ����spring����(�����)
	private UserDao dao=DaoFactory.getInstance().createDao(UserDao.class);//�����Ļ�����ʹ�ù���ģʽ�ˣ�����������ӿڣ������ײ���˲�����Ӱ��service�㣬service��Ҫ�ĸ�daoֻ��Ҫ��ȡ���ù������ȡ�����ļ����У�ʵ����service��ײ����ȫ����
	
	//��web���ṩע��ҵ��
	public void register(User user) throws UserExistException{
		//���жϵ�ǰҪע����û��Ƿ����
		boolean b=dao.find(user.getUsername());
		if(b){
			throw new UserExistException();//����Ҫע����û��Ѿ����ڣ����web����һ������ʱ�쳣������web����봦������쳣�����û�һ���Ѻ���ʾ
		}else{
			//���û������뾭��md5ת��֮���ٱ��浽���ݿ�
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			//����û������ڣ��ͽ������û���ӵ����ݿ���ȥ
			dao.addUser(user);
		}
	}
	//��web���ṩ��½����
	public User login(String username,String password){
		
		//���ڱ��浽���ݿ��е������Ǿ���md5����ģ����Բ�ѯʱ�����ݽ���������Ҳ��Ҫ�Ⱦ���md5ת��
		password=ServiceUtils.md5(password);
		
		return dao.find(username, password);
	}
}
