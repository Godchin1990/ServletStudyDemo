package cn.lnu.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//response������ͼƬ
public class ResponseDemo4 extends HttpServlet {
	public static final int width=120;
	public static final int height=35;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�������ڴ��й���һ��ͼ��
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//�����ͼ����д���ݣ����Ȼ�����ͼ�����
		Graphics g=image.getGraphics();
		//1�����ñ���ɫ
		setBackGround(g);
		//2,���ñ߿�
		setBorder(g);
		//3����������
		drawRandomLine(g);
		//4,��ͼ����д�����
		drawRandomNum((Graphics2D )g);
		//5��ͼ��д�������
		response.setContentType("image/jpeg");
		//���Ϳ����������Ҫ����
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma", "no-cache");
		ImageIO.write(image,"jpg",response.getOutputStream());
		
	}

	private void setBackGround(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
	}
	private void setBorder(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, width-2, height-2);
	}
	
	private void drawRandomLine(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		//������������
		for(int i=0;i<5;i++){
			//�����ø�������ֹ����
			int x1=new Random().nextInt(width);//����0-120֮��������
			int y1=new Random().nextInt(height);//����0-25֮��������
			
			int x2=new Random().nextInt(width);//����0-120֮��������
			int y2=new Random().nextInt(height);//����0-25֮��������
			
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	private void drawRandomNum(Graphics2D g) {//Ϊ�˸����������ת���ܣ�����ʹ��Graphics2D ��
		// TODO Auto-generated method stub
		//����������ɫ������
		g.setColor(Color.RED);
		g.setFont(new Font("����",Font.BOLD,20));
		
		//���ú���
		String base="\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709";
		int x=5;//��ʾ������ͼ����д�Ŀ�ʼλ��
		//�����ĸ�������֣���Ҫ֪���������� [\u4e00-\u9fa5]
		for(int i=0;i<5;i++){
			//�ڳ��ú��ֳ��ȷ�Χ�����ѡ��һ��0-base.length()-1��λ�ã�Ȼ�󷵻ظ�λ�õĺ����ַ�
			String ch=base.charAt(new Random().nextInt(base.length()))+"";
			int degree=new Random().nextInt()%30;//����һ��-30-30֮��������
			g.rotate(degree*Math.PI/180, x, 20);//����������ת�Ļ���
			g.drawString(ch, x, 20);
			g.rotate(-degree*Math.PI/180, x, 20);//��ת��֮��Ϊ���´���ת����������Ҫ���û�֮ǰ����ת����
			x+=30;
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
