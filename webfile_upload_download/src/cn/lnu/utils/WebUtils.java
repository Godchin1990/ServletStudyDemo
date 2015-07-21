package cn.lnu.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.lnu.domain.Upfile;

public class WebUtils {//��������࣬ʵ�ִ����ļ��ϴ����󣬲����ϴ��ļ����浽pathĿ¼�£�Ȼ���ϴ����ļ����ظ�һ��Upfile����
	
	public static Upfile doUpload(HttpServletRequest request,String uppath) throws FileSizeLimitExceededException{
		Upfile bean=new Upfile();//�������ڷ�װ�ϴ��ļ���Ϣ��bean
		try{
			DiskFileItemFactory factory=new DiskFileItemFactory();//����һ�����������������
			factory.setRepository(new File(request.getSession().getServletContext().getRealPath("/WEB-INF/temp")));//����ϴ��ļ����������ϴ��ļ��Ļ���Ŀ¼
			ServletFileUpload upload=new ServletFileUpload(factory);//ʹ�ù�������һ���ļ��ϴ�������
			upload.setHeaderEncoding("UTF-8");//���һ���ϴ��ļ���������������
			upload.setFileSizeMax(1024*1024*500);//�����ϴ��ļ������Ϊ500M���ļ�������׳�FileUploadBase.FileSizeLimitExceededException�쳣������쳣��Ҫ����ץȡ
			List<FileItem> list=upload.parseRequest(request);
			
			for( FileItem item:list){
				if(item.isFormField()){//�������ͨ�ֶ�
					String name=item.getFieldName();//username=mushroom         description=fhfhafahfahfa
					String value=item.getString("UTF-8");
					System.out.println(name+"="+value);
					BeanUtils.copyProperty(bean, name, value);//ʹ��Beanutils����ͨ�ֶε����ֺ�ֵ��װ��bean��
				}else{//�ϴ��������ֶ�
					//�õ��ϴ��ļ�������Ӧ���ݿ�realname�ֶ�
					String filename=item.getName().substring(item.getName().lastIndexOf("\\")+1);
					//�����ϴ��ļ�����1.txt������һ��Ψһ��uuid�ļ�������ֹ�ϴ����������е��ļ������ֳ�ͻ
					String uuidname=generateUidFileName(filename);
					//�õ��ļ��ı���·��
					String savepath=generateSavePath(uppath,uuidname);//uppath���ϴ�Ŀ¼����󷵻صĲ��������ı���Ŀ¼
					
					//Ȼ��ʼ���ϴ��ļ��������ɵı����ڷ������ϵı���Ŀ¼��
					InputStream in=item.getInputStream();
					int len=0;
					byte buffer[]=new byte[1024];
					FileOutputStream out=new FileOutputStream(savepath+"\\"+uuidname);
					while((len=in.read(buffer))>0){
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();//ɾ����ǰ�ϴ��ļ����ϴ��������ڻ���Ŀ¼�еĻ����ļ�
					
					bean.setRealname(filename);
					bean.setId(UUID.randomUUID().toString());
					bean.setSavepath(savepath);
					bean.setUuidname(uuidname);
					bean.setUptime(new Date());
				
				}
			}
			return bean;
		}catch(FileUploadBase.FileSizeLimitExceededException e){
			throw e;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	private static String generateUidFileName(String filename){
		String ext=filename.substring(filename.lastIndexOf(".")+1);//�õ��ϴ��ļ�����չ��
		return UUID.randomUUID().toString()+"."+ext;
	}
	
	private static String generateSavePath(String path,String filename){//�����ļ���ʹ��hash�㷨������Ŀ¼��Ȼ����Щ��Ŀ¼�����ڴ��ݽ�����savepathĿ¼��
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
}
