package cn.lnu.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import cn.lnu.utils.JdbcUtils;

public class Demo5 {

	/**���ô洢����
	 *���ܣ�������һ��ֵд���������У��ڽ���֤ȯ��ҵʹ�ô洢���̺ܶ�
	 * ����������洢��������mysql�ͻ���ִ��һ�£�
		 delimiter $$
		 CREATE PROCEDURE demoSp(IN inputParam VARCHAR(255),INOUT intOutParam varchar(255))
		 BEGIN
		 		SELECT CONCAT('zyxw---',inputParam) into intOutParam;
		 END $$
		 
		 delimiter;
	 */
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		CallableStatement  st = null;
		ResultSet rs = null;
		
		try{
			conn = JdbcUtils.getConnection();
			st = conn.prepareCall("{call demoSp(?,?)}");
			st.setString(1, "aaaaa");
			st.registerOutParameter(2, Types.VARCHAR);
			st.execute();
			
			System.out.println(st.getString(2));
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
}
