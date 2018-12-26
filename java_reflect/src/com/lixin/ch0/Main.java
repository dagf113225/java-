package com.lixin.ch0;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		// 1.������.getClass()
		// 2.����.class
		// 3.Class.forName("���ȫ·��")

		// �õ������ľ����class����

		Class c = null;
		try {
			// 1.��ȡ������Class����
			// 1.1������.getClass()
			// 1.2����.class
			// 1.3Class.forName("���ȫ·��")
			c = Class.forName("com.wqm.test.Test");
			System.out.println(c);

			// �õ����������е�����
			Field[] fs = c.getDeclaredFields();

			for (Field f : fs) {
				System.out.println("��������Ϊ:" + f.getName());

				Field tf = c.getDeclaredField(f.getName());
				tf.setAccessible(true);
				Object obj = tf.get(c.newInstance());
				System.out.println(f.getName() + "-->" + obj);

			}

			System.out.println("------**************--------------");

			// ���ʵ������Ե�ֵ
			Field f1 = c.getDeclaredField("name");
			// ��������
			f1.setAccessible(true);
			Object obj = f1.get(c.newInstance());
			System.out.println(obj);

			System.out.println("--------------------");

			Field f2 = c.getDeclaredField("age");
			// ��������
			f2.setAccessible(true);
			Object obj1 = f2.get(c.newInstance());
			System.out.println(obj1);

			System.out.println("--------------------");
			// �õ����������еķ���
			Method[] ms = c.getDeclaredMethods();

			for (Method m : ms) {
				System.out.println("���еķ�������Ϊ:" + m.getName());
				m.setAccessible(true);
				// ����ִ�з���
				m.invoke(c.newInstance(), null);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
