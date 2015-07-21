package cn.lnu.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.lnu.dao.UpfileDao;
import cn.lnu.domain.Upfile;
import cn.lnu.utils.JdbcUtils;

public class UpfileDaoImpl implements UpfileDao {
	
	public void add(Upfile upfile){
		try{
			QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//��Ҫ����һ�����ݿ����ӳأ������ڹ������д������ݿ����ӳأ����ṩ��ȡ���ݿ����ӳصĽӿ�
			String sql = "insert into upfile(id,uuidname,realname,savepath,uptime,description,username) values(?,?,?,?,?,?,?)";
			Object params[] = {upfile.getId(),upfile.getUuidname(),upfile.getRealname(),upfile.getSavepath(),upfile.getUptime(),upfile.getDescription(),upfile.getUsername()};
			runner.update(sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Upfile> getAll(){
		try{
			QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//��Ҫ����һ�����ݿ����ӳأ������ڹ������д������ݿ����ӳأ����ṩ��ȡ���ݿ����ӳصĽӿ�
			String sql="select * from upfile order by uptime desc";
			return (List<Upfile>) runner.query(sql, new BeanListHandler(Upfile.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public Upfile find(String id){
		try{
			QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//��Ҫ����һ�����ݿ����ӳأ������ڹ������д������ݿ����ӳأ����ṩ��ȡ���ݿ����ӳصĽӿ�
			String sql="select * from upfile where id=?";
			return (Upfile) runner.query(sql, id,new BeanHandler(Upfile.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String id){
		
	}
	
	public void update(Upfile upfile){
		
	}
}
