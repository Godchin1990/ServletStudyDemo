package cn.lnu.service;

import java.util.List;

import cn.lnu.domain.Upfile;

public interface BusinessService {

	void addUpfile(Upfile upfile);

	List getAllUpfile();

	//ͨ���ļ�id�����ϴ��ļ�
	Upfile finUpfile(String id);

}