package com.lixin.user.service.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(targetNamespace="http://thzm.com/wsdl")
public interface IUserService {


    @WebMethod
    public String  queryRoleData();

    @WebMethod
    public String  queryGroupByRoleCount();


    @WebMethod
    public String  queryStuAndkmCount(String name);

}
