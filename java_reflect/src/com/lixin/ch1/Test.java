package com.lixin.ch1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {

	static Map<String, Object> maps = new HashMap<String, Object>();

	static {

		try {

			SAXReader saxReader = new SAXReader();

			Document doc = saxReader.read("src/com/lixin/ch1/beans.xml");

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

	public static void main(String[] args) {

		// 在代码中明确的绑定了子类的类型
		//动物绑定的类型是由谁决定的？代码来绑定的。控制权是由代码绑定的
		Animal an = new Cat();
		//an = new Dog();
		an.eat();

		// 灵活绑定基于配置文件，也叫做解耦合
		//动物绑定的类型是由谁决定的？配置文件来决定，控制权由代码绑定的转移给了配置文件
		//控制反转
		Animal an1=(Animal)maps.get("animal");
        an1.eat();
	}

}
