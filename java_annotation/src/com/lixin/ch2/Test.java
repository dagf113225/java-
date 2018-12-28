package com.lixin.ch2;

import java.lang.reflect.InvocationTargetException;

public class Test {
	
	public static void main(String[] args) {
		
		MClasses   m = new MClasses();
		m.setId(1);
		m.setName("java°à");
		
		try {
			String sql=CreateSql.makeQuerySql(m);
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
		}
	}

}
