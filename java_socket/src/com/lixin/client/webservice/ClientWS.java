package com.lixin.client.webservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.lixin.user.service.interfaces.IUserService;

public class ClientWS {

	public static void main(String[] args) {

		try {
			// 1.构建访问的url
			URL url = new URL("http://127.0.0.1:8100/userdataservice/user");

			// 2. 构建访问的名称
			QName qname = new QName("http://thzm.com/wsdl", "UserServiceImpl");

			// 3.创建服务的对象 url
			Service service = Service.create(url, qname);

			// 4.得到服务对象的接口对象
			IUserService user = (IUserService) service
					.getPort(IUserService.class);

			String result = user.queryRoleData();

			System.out.println("-->java客户端访问queryRoleData的结果为:" + result);

			String result1 = user.queryGroupByRoleCount();

			System.out.println("java客户端访问queryGroupByRoleCount的结果为:" + result1);

			String result2 = user.queryStuAndkmCount("刘冬孝");

			System.out.println("java客户端访问queryStuAndkmCount的结果为:" + result2);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
