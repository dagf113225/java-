package com.lixin.user.service.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(targetNamespace="http://thzm.com/wsdl")
public interface IUserService {
	
	//��ѯ��ɫ������
	@WebMethod
	public String  queryRoleData();
	
	// �ҳ�ѧ�������ְ���ѧ��������ְ������
	@WebMethod
	public String  queryGroupByRoleCount();
	
	//-- **ѧ����ѧ�γ̵�����
	@WebMethod
	public String  queryStuAndkmCount(String name);

}
