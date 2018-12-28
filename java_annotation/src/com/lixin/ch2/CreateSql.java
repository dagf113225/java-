package com.lixin.ch2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class CreateSql {

	public static String makeQuerySql(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		

		StringBuffer sb = new StringBuffer();
		if (obj instanceof MClasses) {
			MClasses m = (MClasses) obj;

			// select * from ���� where
			Class c = m.getClass();

			if (!c.isAnnotationPresent(Table.class)) {

				System.out.println("û��--------------------------ע��");

			} else {
				Table t = (Table) c.getAnnotation(Table.class);
				System.out.println(t.tableName());
				sb.append("select   *  from    ").append(t.tableName())
						.append("  where  1=1 ");

				// ��ȡ���������е�����
				Field[] fs = c.getDeclaredFields();
				for (Field f : fs) {
					boolean flag = f.isAnnotationPresent(Column.class);

					if (!flag) {
						continue;
					}
					Column column = f.getAnnotation(Column.class);

					String cname=column.value();
					System.out.println("�������-->"+cname);
					
					//ƴ��get������ִ��
					String  fname=f.getName();
					System.out.println("���Ե�����Ϊ:"+fname);
					
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
					//select * from ���� where  
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
