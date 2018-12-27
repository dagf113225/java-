package com.lixin.ch4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

		// 面向反射编程，反射：在运行期间对这个类的属性，
		// 构造函数，方法的获取，并能够执行这个类的属性，构造函数，方法

		// 1.类名.class 2. 对象名.getClass() 3.Class.forName("类的全路径")

		Class c = User.class;

		// 反射产生这个类的对象
		Object obj = c.newInstance();

		Field ageField = c.getDeclaredField("age");

		ageField.setAccessible(true);
		// obj这个类的对象
		Object objValue = ageField.get(obj);

		System.out.println("age属性的值为:" + objValue);

		System.out.println("----------------------------------------------");
		
		Constructor  con1=	c.getDeclaredConstructor(new Class[]{int.class,String.class});
		con1.setAccessible(true);
		con1.newInstance(new Object[]{10,"王安乐"});
		
		
		Constructor  con2=	c.getDeclaredConstructor(new Class[]{String.class,int.class});
		con2.setAccessible(true);
		con2.newInstance(new Object[]{"王安乐",10});
		System.out.println("----------------------------------------------");
		
		Method  m=c.getDeclaredMethod("check", new Class[]{double.class});
		m.invoke(obj, new Object[]{20.0000});
	}

}
