package cn.lnu.dao;

import cn.lnu.domain.User;

public interface UserDao {

	//����һ�����û�
	void addUser(User user);

	//�����û�������������û�
	User find(String username, String password);

	//����ע����û��Ƿ������ݿ����Ѿ�����
	boolean find(String username);

}