package junit.test;
	
import org.junit.Test;

import cn.lnu.dao.BlsDao;
import cn.lnu.dao.MainfaceDao;
import cn.lnu.domain.Bls;
import cn.lnu.domain.Mainface;
import cn.lnu.factory.DaoFactory;
	
public class testDao {
		
	private MainfaceDao dao=DaoFactory.getInstance().createDao(MainfaceDao.class);
	private BlsDao dao1=DaoFactory.getInstance().createDao(BlsDao.class);
	
	
	@Test
	public void findbls(){
		try{
			Bls bean=dao1.find("011");
			System.out.print(bean);
			System.out.print("���ҳɹ���");
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("����ʧ�ܣ�");
		}
	}
	
	@Test
	public void find(){
		try{
			Mainface bean=dao.find("02");
			System.out.print(bean);
			System.out.print("���ҳɹ���");
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("����ʧ�ܣ�");
		}
	}
	@Test
	public void add(){
		try{
			Mainface m=new Mainface("8","�°�ť","IDB_new");
			dao.add(m);
			System.out.print("����ɹ���");
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("����ʧ�ܣ�");
	}
  }
	@Test
	public void delete(){
		try{
			String btnid="IDB_new";
			dao.delete(btnid);
			System.out.print("ɾ���ɹ���");
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("ɾ��ʧ�ܣ�");
		}
	}
	
	@Test
	public void update(){
		try{
			Mainface m=new Mainface("8","�°�ť","IDB_Old");
			dao.update(m);
			System.out.print("���³ɹ���");
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("����ʧ�ܣ�");
		}
	}
}