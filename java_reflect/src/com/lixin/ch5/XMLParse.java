package com.lixin.ch5;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLParse {

	private static XMLParse xp;

	Map<String, String> maps = new HashMap<String, String>();
	Map<String, Object> objmaps = new HashMap<String, Object>();
	
	public Object getBean(String key)
	{
		return objmaps.get(key);
	}

	private XMLParse() {
		String val = "";
		String ref = "";
		Object obj = null;
		Class c = null;
		try {
			System.out.println("--------------------");
			SAXReader sax = new SAXReader();

			Document doc = sax.read("./src/com/lixin/ch5/beans.xml");

			List<Element> lists = doc.selectNodes("./beans/bean");

			for (Element element : lists) {
				String id = element.attributeValue("id");
				String cpath = element.attributeValue("class");
				System.out.println(id + "--->" + cpath);

				maps.put(id, cpath);

				if (null != element.element("property")) {
					c = Class.forName(cpath);
					obj = c.newInstance();
					objmaps.put(id, obj);
					val = element.element("property").attributeValue("value");
					ref = element.element("property").attributeValue("ref");
					System.out.println(val + "-------------****" + ref);

				}
			}

			String mname = "set" + val.substring(0, 1).toUpperCase()
					+ val.substring(1);
			System.out.println("mname-->" + mname);

			String path = maps.get(ref);

			System.out.println("path-->" + path);

			Class refc = Class.forName(path);
			
			System.out.println("refc-->"+refc);
	
			System.out.println("f--**********>"+refc.getInterfaces()[0].getName());

			Method m = c.getDeclaredMethod(mname, refc.getInterfaces());

			m.invoke(obj, refc.newInstance());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static XMLParse getInstace() {
		System.out.println("******************");
		if (null == xp) {
			xp = new XMLParse();
		}
		return xp;
	}

}
