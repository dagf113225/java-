package com.lixin.ch4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

		// �������̣����䣺�������ڼ�����������ԣ�
		// ���캯���������Ļ�ȡ�����ܹ�ִ�����������ԣ����캯��������

		// 1.����.class 2. ������.getClass() 3.Class.forName("���ȫ·��")

		Class c = User.class;

		// ������������Ķ���
		Object obj = c.newInstance();

		Field ageField = c.getDeclaredField("age");

		ageField.setAccessible(true);
		// obj�����Ķ���
		Object objValue = ageField.get(obj);

		System.out.println("age���Ե�ֵΪ:" + objValue);

		System.out.println("----------------------------------------------");
		
		Constructor  con1=	c.getDeclaredConstructor(new Class[]{int.class,String.class});
		con1.setAccessible(true);
		con1.newInstance(new Object[]{10,"������"});
		
		
		Constructor  con2=	c.getDeclaredConstructor(new Class[]{String.class,int.class});
		con2.setAccessible(true);
		con2.newInstance(new Object[]{"������",10});
		System.out.println("----------------------------------------------");
		
		Method  m=c.getDeclaredMethod("check", new Class[]{double.class});
		m.invoke(obj, new Object[]{20.0000});
	}

}
