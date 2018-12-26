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

	// name���û���Ҫʲô���Ķ���?
	public static Animal getFactory(String name)throws  Exception {
		Animal an = null;

		// ������������˼���������������ҵ��ı仯����Ҳ�ڱ仯.
		// if(name.equals("��"))
		// {
		// an = new Dog();
		// }
		// else if(name.equals("è"))
		// {
		// an = new Cat();
		// }
		if(null==maps.get(name))
		{
			
			throw  new Exception("�Բ������ǻ�û���������"+name);
		}
		else
		{
			an=(Animal)maps.get(name);
		}
	
		return   an;
	}
}
