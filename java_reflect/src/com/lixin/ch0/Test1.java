package com.lixin.ch0;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test1 {

	public static void main(String[] args) {

		Class c = Emp.class;

		// ���䴴������ -->Ĭ���޲ι��캯��
		try {
			Object obj = c.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("------------");

		Constructor[] cons = c.getDeclaredConstructors();

		for (Constructor c1 : cons) {

			try
			{
				//��������Ĳ��������ͺͳ���
				Class[] pc = c1.getParameterTypes();
				System.out.println(c1 + "-->" + pc.length);
				
				if(pc.length==0)
				{
					c1.newInstance();
				}
				else  
				{
					for(Class sc:pc)
					{
						System.out.println("-->"+sc.getName());
						if(sc.getName().contains("int"))
						{

							c1.newInstance(20);
						}
						else  if(sc.getName().contains("String"))
						{
							c1.newInstance("������");
						}
					}
					
				}
			}
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }

		}

	}
}
