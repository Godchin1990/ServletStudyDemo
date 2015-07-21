package cn.lnu.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
//�������ÿһ����¼�����ȴ���һ��bean�У�Ȼ���ڽ����bean�ӵ�һ��List�����У���ʵ�ֿ������߱�¶��handler�ӿڴ�����
public class BeanListHandler implements ResultSetHandler{
	private Class clazz;
	public BeanListHandler(Class clazz){//����Ҫ�������ÿһ�м�¼��װ���ĸ���Ķ����е�������������û�ʹ�������������ʱ�򣬾Ͳ���Ҫ����ǰ������new��һ�������ڴ��ݹ���������ֱ�Ӵ��ݹ���һ����
		this.clazz=clazz;
	}
	public Object handler(ResultSet rs) {
		List list=new ArrayList();
		try {
			while(rs.next()){
				Object bean=clazz.newInstance();//ÿȡ��һ����¼��new��һ�������bean����
				ResultSetMetaData meta=rs.getMetaData();
				int count=meta.getColumnCount();
				for(int i=0;i<count;i++){
					String name=meta.getColumnName(i+1);//ÿ��ȡ�������ÿһ�е�����
					Object value=rs.getObject(name);
					
					//���䣬ͨ��ÿ��ȡ�������������bean�����϶�Ӧ������
					Field f=bean.getClass().getDeclaredField(name);
					f.setAccessible(true);//ǿ�����ø�����Ϊ���з������ԣ��򿪸����Եķ���Ȩ�ޣ�����������Ͽ��Ա���ֵ
					f.set(bean, value);//�������ÿ�е�ֵ��ֵ��bean�����Ӧ������	
				}
				list.add(bean);//��ÿ�η������bean��ӵ�һ��list������
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}