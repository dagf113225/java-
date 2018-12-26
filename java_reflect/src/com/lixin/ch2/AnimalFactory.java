package com.lixin.ch2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class AnimalFactory {

	static Map<String, Object> maps = new HashMap<String, Object>();

	static {

		try {

			SAXReader saxReader = new SAXReader();

			Document doc = saxReader.read("src/com/lixin/ch2/beans.xml");

			List<Element> lists = doc.selectNodes("/beans/bean");

			for (Element cElement : lists) {
				String id = cElement.attributeValue("id");
				String cpath = cElement.attributeValue("class");
				System.out.println(id + "--->" + cpath);
				try {
					Class c = Class.forName(cpath);

					try {
						Object obj = c.newInstance();
						maps.put(id, obj);

					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// name，用户需要什么样的动物?
	public static Animal getFactory(String name)throws  Exception {
		Animal an = null;

		// 运用面向对象的思想来解决，带来的业务的变化，类也在变化.
		// if(name.equals("狗"))
		// {
		// an = new Dog();
		// }
		// else if(name.equals("猫"))
		// {
		// an = new Cat();
		// }
		if(null==maps.get(name))
		{
			
			throw  new Exception("对不起，我们还没有这个动物"+name);
		}
		else
		{
			an=(Animal)maps.get(name);
		}
	
		return   an;
	}
}
