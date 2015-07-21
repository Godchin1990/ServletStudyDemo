package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.lnu.domain.User;
import cn.lnu.exception.UserExistException;
import cn.lnu.service.impl.BusinessServiceImpl;

public class ServiceTest {
	@Test
	public void testRegister(){
		User user=new User();
		
		user.setId("233");
		user.setUsername("Tom");
		user.setPassword("123456");
		user.setEmail("a123@163.com");
		user.setBirthday(new Date());
		user.setNickname("dss");
		
		BusinessServiceImpl service=new BusinessServiceImpl();
		try {
			service.register(user);
			System.out.println("ע��ɹ���");
		} catch (UserExistException e) {
			// TODO Auto-generated catch block
			System.out.println("�û��Ѵ��ڣ���");
		}
	}
	
	@Test
	public void testLogin(){
		BusinessServiceImpl service=new BusinessServiceImpl();
		User user=service.login("Jhon", "123456");
		if(user!=null){
			System.out.println("��½�ɹ���");
		}else{
			System.out.println("��½ʧ�ܣ�����");
		}
	}
}
