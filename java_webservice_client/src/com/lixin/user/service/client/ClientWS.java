package com.lixin.user.service.client;



import com.lixin.user.service.interfaces.IUserService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientWS {

    public  static   void  main(String[]  args)  {


        try {
            //1.�������ʵ�url
            URL  url  = new URL("http://127.0.0.1:8100/userdataservice/user");


            //2. �������ʵ�����
            QName  qname = new QName("http://thzm.com/wsdl","UserServiceImpl");


            //3.��������Ķ���  url
            Service  service  = Service.create(url,qname);

            //4.�õ��������Ľӿڶ���
            IUserService   user=(IUserService) service.getPort(IUserService.class);

            String   result=user.queryRoleData();

            System.out.println("java�ͻ��˷��ʵĽ��Ϊ:"+result);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

