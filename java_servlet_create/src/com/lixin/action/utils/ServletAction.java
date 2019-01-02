package com.lixin.action.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import com.lixin.xml.parse.XMLparse;

public class ServletAction {

	public Map<String, String> servletMaps = null;

	public Map<String, String> servletMappingMaps = null;

	public ServletAction() {
		XMLparse xmlController = XMLparse.getInstance();
		servletMappingMaps = xmlController.servletMappingMaps;
		servletMaps = xmlController.servletMaps;
	}

	public void exec(String actionName, String actiontype) {
		String servletName = servletMappingMaps.get(actionName);
		System.out.println("servletName-->" + servletName);

		String cpath = servletMaps.get(servletName);

		try {
			Class c = Class.forName(cpath);

			String methodName = "do" + actiontype.substring(0, 1).toUpperCase()
					+ actiontype.substring(1);

			Method m = c.getDeclaredMethod(methodName, null);

			m.invoke(c.newInstance(), null);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
