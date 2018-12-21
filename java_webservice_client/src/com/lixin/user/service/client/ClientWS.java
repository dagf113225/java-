package com.lixin.user.service.client;



import com.lixin.user.service.interfaces.IUserService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientWS {

    public  static   void  main(String[]  args)  {


        try {
            //1.构建访问的url
            URL  url  = new URL("http://127.0.0.1:8100/userdataservice/user");


            //2. 构建访问的名称
            QName  qname = new QName("http://thzm.com/wsdl","UserServiceImpl");


            //3.创建服务的对象  url
            Service  service  = Service.create(url,qname);

            //4.得到服务对象的接口对象
            IUserService   user=(IUserService) service.getPort(IUserService.class);

            String   result=user.queryRoleData();

            System.out.println("java客户端访问的结果为:"+result);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

