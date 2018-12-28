package com.lixin.ch2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class CreateSql {

	public static String makeQuerySql(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		

		StringBuffer sb = new StringBuffer();
		if (obj instanceof MClasses) {
			MClasses m = (MClasses) obj;

			// select * from 表名 where
			Class c = m.getClass();

			if (!c.isAnnotationPresent(Table.class)) {

				System.out.println("没有--------------------------注解");

			} else {
				Table t = (Table) c.getAnnotation(Table.class);
				System.out.println(t.tableName());
				sb.append("select   *  from    ").append(t.tableName())
						.append("  where  1=1 ");

				// 获取这个类的所有的属性
				Field[] fs = c.getDeclaredFields();
				for (Field f : fs) {
					boolean flag = f.isAnnotationPresent(Column.class);

					if (!flag) {
						continue;
					}
					Column column = f.getAnnotation(Column.class);

					String cname=column.value();
					System.out.println("表的列名-->"+cname);
					
					//拼接get方法并执行
					String  fname=f.getName();
					System.out.println("属性的名字为:"+fname);
					
					String  getName="get"+fname.substring(0, 1).toUpperCase()+fname.substring(1);
					System.out.println("getName-->"+getName);
					
					Method   gmthodName=c.getDeclaredMethod(getName);
					Object  fmvalue=gmthodName.invoke(m);
					
					System.out.println("fmvalue----="+fmvalue);
					
					if(null==fmvalue)
					{
						continue;
					}
					sb.append("  and ").append(" ");
					//select * from 表名 where  
				  if(fmvalue  instanceof  String)
				  {
					  sb.append(cname).append("='").append(fmvalue).append("'");
				  }
				  else  if(fmvalue  instanceof  Integer)
				  {
					  sb.append(cname).append("=").append(fmvalue).append("");
				  }
					

				}

				System.out.println(sb.toString());

			}
		}

		return null;
	}

}
