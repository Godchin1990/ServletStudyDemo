package cn.lnu.service;

import java.util.ArrayList;
import java.util.List;

import cn.lnu.domain.User;


//service����Ӧ����ȥ��dao������Ϊ�˲��Է��㣬ʹ��User��ģ�����ݿ�
public class BusinessService {
	//service��ά��һ������
	private static List<User> list=new ArrayList();
	//Ϊ��ģ�����ݿ⣬��������ʹ�þ�̬�������List��������Ӽ����û�
	static{
		list.add(new User("mushroom","123"));
		list.add(new User("jhon","123"));
		list.add(new User("tom","123"));
	}
	
	//������list����������ָ���û�����������û�
	public User login(String username,String password){
		for(User user:list){
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	//�����û��������û�
	public User findUser(String username){
		for(User user:list){
			if(user.getUsername().equals(username)){
				return user;
			}
		}
		return null;
	}
}
