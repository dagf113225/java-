package com.lixin.ch1;

import java.lang.reflect.Method;

public class Test {
	
	public static void main(String[] args) {
		
		Class  c=UserAction.class;
		
		if(c.isAnnotationPresent(Classdesc.class))
		{
			Classdesc  cd=(Classdesc)c.getAnnotation(Classdesc.class);
			
			String  cpath=cd.value();
			
			String sex=cd.sex();
			
			if(sex.equals("男"))
			{
				System.out.println("对不起，你不能够去执行服务的方法，你是男的");
			}
			else
			{
				try
				{
					Class  tc=Class.forName(cpath);
					
					Method  m=tc.getDeclaredMethod("exec", null);
					m.invoke(tc.newInstance(), null);
				}
			    catch(Exception  e)
			    {
			    	System.out.println(e);
			    }
			}
			
			
		}
	}

}
