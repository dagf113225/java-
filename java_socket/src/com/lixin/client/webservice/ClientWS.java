package com.lixin.client.webservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.lixin.user.service.interfaces.IUserService;

public class ClientWS {

	public static void main(String[] args) {

		try {
			// 1.�������ʵ�url
			URL url = new URL("http://127.0.0.1:8100/userdataservice/user");

			// 2. �������ʵ�����
			QName qname = new QName("http://thzm.com/wsdl", "UserServiceImpl");

			// 3.��������Ķ��� url
			Service service = Service.create(url, qname);

			// 4.�õ��������Ľӿڶ���
			IUserService user = (IUserService) service
					.getPort(IUserService.class);

			String result = user.queryRoleData();

			System.out.println("-->java�ͻ��˷���queryRoleData�Ľ��Ϊ:" + result);

			String result1 = user.queryGroupByRoleCount();

			System.out.println("java�ͻ��˷���queryGroupByRoleCount�Ľ��Ϊ:" + result1);

			String result2 = user.queryStuAndkmCount("����Т");

			System.out.println("java�ͻ��˷���queryStuAndkmCount�Ľ��Ϊ:" + result2);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
