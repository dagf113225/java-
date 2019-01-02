package com.lixin.xml.parse;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLparse {

	private static XMLparse xmlParse;

	public static   Map<String, String> servletMaps = new HashMap<String, String>();

	public static Map<String, String> servletMappingMaps = new HashMap<String, String>();

	private XMLparse() {

		SAXReader sax = new SAXReader();

		InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream("web.xml");

		try {
			Document doc = sax.read(in);
			List<Element> lists = doc.selectNodes("web-app/servlet-mapping");

			for (Element element : lists) {
				String key = element.elementTextTrim("url-pattern");
				String value = element.elementTextTrim("servlet-name");

				servletMappingMaps.put(key, value);
			}
			List<Element> slists = doc.selectNodes("web-app/servlet");

			for (Element element : slists) {
				String key = element.elementTextTrim("servlet-name");
				String value = element.elementTextTrim("servlet-class");

				servletMaps.put(key, value);
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static XMLparse getInstance() {
		if (null == xmlParse) {
			xmlParse = new XMLparse();
		}
		return xmlParse;
	}

}
