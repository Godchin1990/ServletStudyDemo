package cn.lnu.form;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Encoder;
//���ó��������������Ϊ������һ�������
public class FormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����һ�������(����)
		TokenProcessor tp=TokenProcessor.getInstance();
		String token=tp.generateToken();
		
		//��ת��jsp�и��û����һ����
		//��ν����Ŵ���jsp��ʹ��session����ȥ
		HttpSession session=request.getSession();
		session.setAttribute("token", token);
		
		request.getRequestDispatcher("/form.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

class TokenProcessor{//�������������Token���ƣ�Ϊ�˱�֤����������Ϊ��һ�ģ����Խ�������Ʒ�������Ƴɵ�����
	/*
	 * 	1,�ѹ��캯��˽��
	 * 2���Լ�����һ��
	 * 3�����Ⱪ¶һ�������������ȡ���洴���Ķ���
	 * */
	private TokenProcessor(){
		
	}
	
	private static final TokenProcessor instance=new TokenProcessor();
	public static TokenProcessor getInstance(){
		return instance;
	}
	
	public String generateToken(){//���ݵ�ǰʱ�����ֵ�Լ�һ����������õ�һ��Ψһ�������
		String token=System.currentTimeMillis()+new Random().nextInt()+"";
		//�������������һ�£���Ҫ��������ָ��/ժҪ���̶�128λ
		try {//�������128λ����ժҪ��һ�㲽��
			MessageDigest md=MessageDigest.getInstance("md5");
			byte[] md5=md.digest(token.getBytes());
			//Ϊ�˷�ֱֹ�ӹ���string���ص��������������봮����Ҫ����base64���룬����md5�����е�ÿ�����ֽ�ת�����ĸ��ֽڣ������������ֽڱ��浽�ĸ��ֽ���
			//��ô�ĸ��ֽڵ�ÿ���ֽڱ���ԭ�������ֽڵ�6λ����ÿ�����ֽ�תΪ�ĸ��ֽ�֮�����ĸ��ֽڵ����ݵ��ص��ǣ�ÿ���ֽڵ���Чλֻ�Ǻ���λ��ǰ��λ���㣬��ôÿ���ֽڵ�
			//��Χ��00000000--00111111��0~63��,��ôһת�룬��ô�ĸ��ֽڵ�ÿ���ֽڶ�Ӧ���ַ�����������Ϥ�Ŀɼ����ַ�
			BASE64Encoder encoder=new BASE64Encoder();
			
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
