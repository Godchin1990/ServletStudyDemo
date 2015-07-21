package cn.lnu.service;

import cn.lnu.domain.Bls;
import cn.lnu.domain.Blse;
import cn.lnu.domain.Blskh;
import cn.lnu.domain.Blskh042;
import cn.lnu.domain.Blskh043;
import cn.lnu.domain.Blskh044;
import cn.lnu.domain.Mainface;
import cn.lnu.domain.Xffsface1;

public interface BusinessService {

	Mainface find(String id);

	Xffsface1 find1(String id);

	//��������֧��(01)
	Bls find2(String id);
	//��������֧��ѵ����02��
	Blse find3(String id);
	//��������֧�ֿ���(04)
	Blskh find4(String id);
	
	//����042��
	Blskh042 find5(String id);
	//�����±�׼��043��
	Blskh043 find6(String id);
	//�Զ����׼(044)
	Blskh044 find7(String id);
}