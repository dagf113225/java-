package com.lixin.ch0;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//����ע��
public class Test {

	public static void main(String[] args) {

		// ��ע�⣬�������Ȼᷴ��

		// �õ�User��Class
		Class<User> c = User.class;
		
		//���User������û��UserDesc��ע��
		boolean  flag=c.isAnnotationPresent(UserDesc.class);
		
		System.out.println("flag-->"+flag);
		
		if(flag)
		{ 
			//��ȡUserDesc���ע����
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
				//��ȡUserDesc���ע����
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
				//��ȡUserDesc���ע����
				UserDesc  ud2=m.getAnnotation(UserDesc.class);
				System.out.println(ud2.name());
				System.out.println(ud2.age());
			}
		}
	}
}
