package com.lixin.user.service.impl;

import java.util.List;

import javax.jws.WebService;

import com.lixin.model.Role;
import com.lixin.user.dao.DB;
import com.lixin.user.service.interfaces.IUserService;

@WebService(portName="userservice",
serviceName="UserServiceImpl",
targetNamespace="http://thzm.com/wsdl",
endpointInterface="com.lixin.user.service.interfaces.IUserService")
public class UserServiceImpl   implements IUserService{

	@Override
	public String queryRoleData() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryRoleData  start...  ");
		
		
		DB  db  = new DB();
		
		List<Role>   lists=db.queryRoleData();
		
		System.out.println("--->"+lists.size());
		
		
		return "南京科技职业学院";
	}
	

}
