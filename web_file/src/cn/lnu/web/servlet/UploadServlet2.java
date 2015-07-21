package cn.lnu.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//ʹ��apache��Դ��֯�ṩ��fileupload�������ǰ̨�������ϴ��ļ�����
public class UploadServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List types=Arrays.asList("jpg","bmp","avi","rmvb","exe","txt","doc","docx");//�����ļ��ϴ�����ֻ�����⼸������
		try{
			DiskFileItemFactory factory=new DiskFileItemFactory();//���ȴ���һ��FileItem��������
			factory.setSizeThreshold(1024*1024);//���ý����������СΪ1MB������ϴ��ļ�С��1M�������ϴ��ļ��Ǵӻ����ж�ȡ���������1M,���ϴ��ļ��ȱ��浽�����ļ��У�֮���ȡ�ϴ��ļ�������������Զ��ӻ����ļ��ж�ȡ�ϴ��ļ������ݣ������Ǵӻ����ж�ȡ
			factory.setRepository(new File(this.getServletContext().getRealPath("/temp")));//���������1Mʱ���ϴ��ļ����浽�����ļ������ﻹ�������û����ļ���Ŀ¼
			ServletFileUpload upload=new ServletFileUpload(factory);//��fileitem�������ݸ�һ��������
			
			//��������μ����ϴ����ȣ�Ϊǰ̨�ṩ��������ý��������ݣ������ڽ���������֮ǰ�������������
			upload.setProgressListener(new ProgressListener(){
				public void update(long pBytesRead, long pContentLength, int pItems) {
							System.out.println("��ǰ�ѽ�����"+pBytesRead+"�ֽ�");
							System.out.println("�����ļ��ܳ��ȣ�"+pContentLength+"�ֽ�");
							System.out.println("���ڽ������ڣ�"+pItems+"��");
				}	
			});
			
			upload.setFileSizeMax(1024*1024*5);//ͨ�������������ϴ��ļ����ܳ���5M,������׳��쳣
			if(!upload.isMultipartContent(request)){//���ǰ̨��װ��request�е����ݲ����ϴ�������
				//����ͳ��ʽ��ȡ������
				String username=request.getParameter("username");
				//....
				return;
			}
			upload.setHeaderEncoding("UTF-8");//Ϊ�˷�ֹ�ϴ��ļ������������⣬��Ҫ����һ�½������ı���
			List<FileItem> list=upload.parseRequest(request);//ʹ�ý���������ǰ̨��������request���õ������������ϴ����ݵ�list���ϣ�������ÿ��Ԫ�ض���һ��FileItem�������Ǵ������ͨ�����Ҳ���ܴ�������ϴ��ļ�������
			for(FileItem item:list){//�������list���ϻ�÷�װ��ÿ���������FileItem���ж����item����ͨ���������ֶΣ������ļ��ϴ��ֶ�
				if(item.isFormField()){//��ʾ��ǰ������item��һ����ͨ������
					String inputName=item.getFieldName();//���ǰ̨�����������
					String inputValue=item.getString("UTF-8");//�����ͨ�������ֵ,��ָ����ȡһ��������ֵʹ�õ����
					/*String inputValue=item.getString();//�����ͨ�������ֵ
					inputValue=new String(inputValue.getBytes("iso8859-1"),"UTF-8");//�ֶ����һ��������ֵ��������������*/
					System.out.println(inputName+"="+inputValue);
				}else{//����ǰ�����item���װ�����ϴ��ļ�������������������ݣ�д������Ӳ�̻��߷�������ĳ��Ŀ¼
					String filename=item.getName().substring(item.getName().lastIndexOf("\\")+1);//��ȡ�ϴ��ļ����������ie6�������������ȫ·�����ļ���C:\Users\MoGu\Desktop\1.txt����IE7���ϻ��ֻ�ǵ������ļ���1.txt
					if(filename==null || filename.trim().equals("")){//�����ϴ��ļ����Ƿ�Ϊ�գ���û��ѡ���ļ��ϴ������Σ���������ѭ���������´�ѭ�����������������ļ��ϴ�
						continue;
					}
					
					String ext=filename.substring(filename.lastIndexOf(".")+1);//��ȡ�ļ���չ��
					if(!types.contains(ext)){//����ϴ��ļ���չ������list�����У���ʾ�û��ϴ��ļ����Ͳ�֧��
						request.setAttribute("message", "����վ��֧����չ��Ϊ"+ext+"���ļ��ϴ�������");
						request.getRequestDispatcher("/message.jsp").forward(request, response);
						return;
					}
					
					InputStream in=item.getInputStream();//���һ�������ϴ��ļ�������������ܴ���������ϴ��ļ�û���������С����Ͱ����淽���ӻ����ж�ȡ�ϴ��ļ����ݣ�����ϴ��ļ������˻����С(1M),���Զ�ȥ����Ŀ¼�µĻ����ļ��ж�ȡ�ϴ��ļ����ݣ����浽���أ�������ȥ�����ж�ȡ�ˣ�������Ҳû������
					int len=0;
					byte buffer[]=new byte[1024];
					//FileOutputStream out=new FileOutputStream("c:\\"+filename);//ʹ����������������ļ������ݱ��浽c���µ�����Ϊfilename���ļ���
					String saveFileName=generateFileName(filename);
					String savepath=generateSavePath(this.getServletContext().getRealPath("/WEB-INF/upload"),saveFileName);
					//ʹ���������������Ψһ�ļ����ͷ�ɢĿ¼������ʵ���ϴ��ļ��������������ͬĿ¼�±���
					FileOutputStream out=new FileOutputStream(savepath+File.separator+saveFileName);//ʵ�ʿ������ǽ��ϴ��ļ��ϴ����������У���������ϴ�Ŀ¼����ֱ�ӱ������ʵ�
					while((len=in.read(buffer))>0){
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();//ɾ�������ϴ��ļ����浽����Ŀ¼�µ���ʱ�ļ�����������������ر�֮��
				}
			}
		}catch(FileUploadBase.FileSizeLimitExceededException e){//�ϴ��ļ���С�����쳣
			e.printStackTrace();
			request.setAttribute("message", "�ϴ��ļ���С���ܳ���5M!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		request.setAttribute("message", "�ϴ��ɹ���");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public String generateSavePath(String path,String filename){//�����ļ���ʹ��hash�㷨������Ŀ¼��Ȼ����Щ��Ŀ¼�����ڴ��ݽ�����savepathĿ¼��
		int hashcode=filename.hashCode();//�õ��ļ�������ַ����������ڴ��еĵ�ַ32λϵͳ����һ���ĸ��ֽڵ�����
		int dir1=hashcode&0xf;//�û��ļ�����ϣֵ�ĺ���λ��һ���ļ�Ŀ¼
		int dir2=(hashcode>>4)&0xf;//�û��ļ�����ϣֵ������λ��ȥ����λ�������ļ�����Ŀ¼
		
		//���ձ���Ŀ¼Ϊ��
		String savepath=path+File.separator+dir1+File.separator+dir2;
		File file=new File(savepath);//���ڵ�һ���ϴ�ʱ�����Ŀ¼��û�д����ڴ��̣����Ա������ж�һ�£�û�д����Ļ����յ�����
		if(!file.exists()){
			file.mkdirs();//�����Ƕ༶Ŀ¼������ʹ��mkdirs()�������
		}
		return savepath;
	}
	
	//Ϊ�ϴ��ļ�����һ��Ψһ���ļ���
	public String generateFileName(String filename){
		return UUID.randomUUID().toString()+"_"+filename;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
