package com.lixin.ch6;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
	static Map<String, String> maps = new HashMap<String, String>();
	static {
		try {
			System.out.println("--------------------");
			SAXReader sax = new SAXReader();

			Document doc = sax.read("./src/com/lixin/ch6/beans.xml");

			List<Element> lists = doc.selectNodes("./beans/bean");

			for (Element element : lists) {
				String id = element.attributeValue("id");
				String cpath = element.attributeValue("class");
				System.out.println(id + "--->" + cpath);

				maps.put(id, cpath);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("请问用户的动作名称是什么?");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		// user_login--->com.lixin.ch6.UserAction类-->login
		// user_add--->com.lixin.ch6.UserAction类-->add
		
		Set<String>  setsKey=maps.keySet();
		for(String  sval:setsKey)
		{
			System.out.println(sval);
			if(!name.startsWith(sval.substring(0,sval.lastIndexOf("_")-1)))
			{
				continue;
			}
			else
			{
				System.out.println("有业务类处理请求");
				String  mname=name.substring(name.indexOf("_")+1, name.length());
				System.out.println("mname-->"+mname);
				String  pname=name.substring(0, name.indexOf("_")+1)+"*";
				System.out.println("pname-->"+pname);
				
				try
				{
					String cpath=maps.get(pname);
					
					Class c=Class.forName(cpath);
					
					Object obj = c.newInstance();
					
					Method  m=c.getDeclaredMethod(mname, null);
					
					m.invoke(obj, null);
					
				}
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
				
				
			}
		}
	
		

	
	}
}
