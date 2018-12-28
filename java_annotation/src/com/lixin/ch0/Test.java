package com.lixin.ch0;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//解析注解
public class Test {

	public static void main(String[] args) {

		// 用注解，必须首先会反射

		// 得到User的Class
		Class<User> c = User.class;
		
		//检查User类中有没有UserDesc的注解
		boolean  flag=c.isAnnotationPresent(UserDesc.class);
		
		System.out.println("flag-->"+flag);
		
		if(flag)
		{ 
			//获取UserDesc这个注解类
			UserDesc  ud=c.getAnnotation(UserDesc.class);
			System.out.println(ud.name());
			System.out.println(ud.age());
			
		}
		
		System.out.println("--------------------------");
		
		Field[]  fs=c.getDeclaredFields();
		
		for(Field  f:fs)
		{
			if(f.isAnnotationPresent(UserDesc.class))
			{
				//获取UserDesc这个注解类
				UserDesc  ud1=f.getAnnotation(UserDesc.class);
				System.out.println(ud1.name());
				System.out.println(ud1.age());
			}
		}
		
		System.out.println("--------------------------");
		
		Method[]  ms=c.getDeclaredMethods();
		
		for(Method  m:ms)
		{
			if(m.isAnnotationPresent(UserDesc.class))
			{
				//获取UserDesc这个注解类
				UserDesc  ud2=m.getAnnotation(UserDesc.class);
				System.out.println(ud2.name());
				System.out.println(ud2.age());
			}
		}
	}
}
