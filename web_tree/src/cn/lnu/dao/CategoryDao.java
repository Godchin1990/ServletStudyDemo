package cn.lnu.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.lnu.domain.Category;
import cn.lnu.utils.JdbcUtils;

//�������ݿ������Ϣ��dao
public class CategoryDao {
	
	public List<Category> getAll(){//�����нڵ��װ��һ��list������
		try{
			QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ʹ��dbutils��ܣ�����һ�����ݿ����ӳ�(����Դ)
			String sql="select child.id,child.name,child.lft,child.rgt,count(child.name) depth from category parent,category child where child.lft>=parent.lft and child.rgt<=parent.rgt group by(child.name) order by child.lft;";
			List list=(List) runner.query(sql, new BeanListHandler(Category.class));
			return list;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
