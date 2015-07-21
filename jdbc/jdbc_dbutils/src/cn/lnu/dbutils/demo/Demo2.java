package cn.lnu.dbutils.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.lnu.utils.JdbcUtils;

//����dbutils�ĸ��������������
public class Demo2 {
	@Test
	public void test1() throws SQLException{//���Խ������ÿһ�м�¼����һ�������У�ע���������Ƕ��У�ֻ���ص�һ�м�¼
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ͨ������һ�����ݿ����ӳأ�����һ��dbutils�������Ӳ��������ֶ��ͷţ�dbutils��ܻ�������ͷ�
		String sql="select * from users where id=?";
		Object res[]=(Object[]) runner.query(sql, 1, new ArrayHandler());
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}
	
	@Test
	public void test2() throws SQLException{//���Խ������ÿһ�м�¼����һ�������У�Ȼ��������ӵ�һ��list���ϵķ�ʽ��������
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ͨ������һ�����ݿ����ӳأ�����һ��dbutils�������Ӳ��������ֶ��ͷţ�dbutils��ܻ�������ͷ�
		String sql="select * from users";
		List list=(List) runner.query(sql,new ArrayListHandler());
		System.out.println(list);
	}
	
	@Test
	public void test3() throws SQLException{//�������ָ�����ϵ����ݴ���һ��ArrayList������
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ͨ������һ�����ݿ����ӳأ�����һ��dbutils�������Ӳ��������ֶ��ͷţ�dbutils��ܻ�������ͷ�
		String sql="select * from users";
		List list=(List) runner.query(sql,new ColumnListHandler("name"));
		System.out.println(list);
	}
	
	@Test
	public void test4() throws SQLException{//���Խ������ÿһ�м�¼����װ��һ��Map���ؼ���Ϊ��������ֵΪ����ֵ��ٰ���Щmap�ٴ浽һ��map���keyΪָ����key
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ͨ������һ�����ݿ����ӳأ�����һ��dbutils�������Ӳ��������ֶ��ͷţ�dbutils��ܻ�������ͷ�
		String sql="select * from users";
		Map<Integer,Map<String,Object>> map=(Map<Integer, Map<String, Object>>) runner.query(sql,new KeyedHandler("id"));
		for(Map.Entry<Integer,Map<String,Object>> me:map.entrySet()){
			int id=me.getKey();
			for(Map.Entry<String, Object> entry:me.getValue().entrySet()){
				String name=entry.getKey();
				Object value=entry.getValue();
				System.out.println(name+"="+value);
			}
			System.out.println("----------------------");
		}
	}
	
	@Test
	public void test5() throws SQLException{//ʹ��ArrayHandler()������������࣬����ʹ�����淽�����ؽ����������
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ͨ������һ�����ݿ����ӳأ�����һ��dbutils�������Ӳ��������ֶ��ͷţ�dbutils��ܻ�������ͷ�
		String sql="select count(*) from users";
		/*Object res[]=(Object[]) runner.query(sql,new ArrayHandler());
		long totalrecord=(Long) res[0];
		int count=(int)totalrecord;
		System.out.println(count);
		
		int totalrecord=((Long)res[0]).intValue;
		System.out.println(totalrecord);
		*/
		
		int totalrecord=((Long)runner.query(sql, new ScalarHandler(1))).intValue();
		System.out.println(totalrecord);
	}
}
