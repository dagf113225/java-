package com.lixin.ch0;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		// 1.对象名.getClass()
		// 2.类名.class
		// 3.Class.forName("类的全路径")

		// 得到这个类的具体的class类型

		Class c = null;
		try {
			// 1.获取这个类的Class类型
			// 1.1对象名.getClass()
			// 1.2类名.class
			// 1.3Class.forName("类的全路径")
			c = Class.forName("com.wqm.test.Test");
			System.out.println(c);

			// 得到这个类的所有的属性
			Field[] fs = c.getDeclaredFields();

			for (Field f : fs) {
				System.out.println("属性名称为:" + f.getName());

				Field tf = c.getDeclaredField(f.getName());
				tf.setAccessible(true);
				Object obj = tf.get(c.newInstance());
				System.out.println(f.getName() + "-->" + obj);

			}

			System.out.println("------**************--------------");

			// 访问单个属性的值
			Field f1 = c.getDeclaredField("name");
			// 暴力访问
			f1.setAccessible(true);
			Object obj = f1.get(c.newInstance());
			System.out.println(obj);

			System.out.println("--------------------");

			Field f2 = c.getDeclaredField("age");
			// 暴力访问
			f2.setAccessible(true);
			Object obj1 = f2.get(c.newInstance());
			System.out.println(obj1);

			System.out.println("--------------------");
			// 得到这个类的所有的方法
			Method[] ms = c.getDeclaredMethods();

			for (Method m : ms) {
				System.out.println("所有的方法名称为:" + m.getName());
				m.setAccessible(true);
				// 反射执行方法
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
