package cn.lnu.utils;

import java.sql.ResultSet;
//�������߲�֪����δ������������û�֪������������������߶��Ⱪ¶һ���ӿڣ����û�����ʵ�֣������û�����֮��Ľ����
public interface ResultSetHandler{
	public Object handler(ResultSet rs);
}
