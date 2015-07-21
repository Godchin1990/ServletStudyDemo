package cn.lnu.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.lnu.dao.UserDao;
import cn.lnu.domain.User;
import cn.lnu.utils.XmlUtils;
//ʵ���õ�ע��͵�½
public class UserDaoXmlImpl implements UserDao {
	//����һ�����û�
	public void addUser(User user){
		try {
			Document document=XmlUtils.getDocument();
			Element root=document.getRootElement();
			Element user_tag=root.addElement("user");
			user_tag.setAttributeValue("id", user.getId());
			user_tag.setAttributeValue("username", user.getUsername());
			user_tag.setAttributeValue("password", user.getPassword());
			user_tag.setAttributeValue("email", user.getEmail());
			user_tag.setAttributeValue("birthday",user.getBirthday()==null?"" : user.getBirthday().toLocaleString());
			user_tag.setAttributeValue("nickname", user.getNickname());
			
			XmlUtils.writeToXml(document);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//�����û�������������û�
	public User find(String username,String password){
		try {
			Document document=XmlUtils.getDocument();
			//xpath���ʽ����
			Element e=(Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			
			if(e==null){
				return null;
			}
			
			User user=new User();
			user.setId(e.attributeValue("id"));
			user.setUsername(e.attributeValue("username"));
			user.setPassword(e.attributeValue("password"));
			user.setEmail(e.attributeValue("email"));
			
			String birthday=e.attributeValue("birthday");
			if(birthday.equals("")||birthday==null){
				user.setBirthday(null);
			}else{
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(df.parse(birthday));
			}
			
			user.setNickname(e.attributeValue("nickname"));
			return user;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//����ע����û��Ƿ������ݿ����Ѿ�����
	public boolean find(String username){
		try {
			Document document=XmlUtils.getDocument();
			//xpath���ʽ����
			Element e=(Element) document.selectSingleNode("//user[@username='"+username+"']");
			
			if(e==null){
				return false;
			}
			
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
}
