package com.lixin.ch3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBUtils {

	public static void insertObject(Object obj) {

		try {
			// 形成插入的sql,自动生成sql
			// insert into 表名() values()
			Class c = obj.getClass();

			System.out.println(c.getName());
			String cname = c.getName();
			String name = cname.substring(cname.lastIndexOf(".") + 1);

			System.out.println("name-->" + name);

			String tableName = "t_" + name.substring(0, 1).toLowerCase()
					+ name.substring(1);
			System.out.println("tableName-->" + tableName);

			// 介绍一下动态字符串StringBuffer

			StringBuffer sb = new StringBuffer();
			sb.append("insert  into  ");
			sb.append(tableName).append("(");

			// 列名的集合
			List<String> lists = new ArrayList<String>();

			Field[] fields = c.getDeclaredFields();

			for (Field f : fields) {
				System.out.println(f.getName());
				lists.add(f.getName());
			}

			for (int i = 0; i < lists.size(); i++) {
				if (lists.get(i).contains("id")) {
					continue;
				}
				if (i == lists.size() - 1) {
					sb.append(lists.get(i) + ")");
				} else {
					sb.append(lists.get(i) + ",");
				}

			}
			sb.append("  ").append("values(");
			// 列值的集合
			List<Object> listValues = new ArrayList<Object>();

			Method[] methods = c.getDeclaredMethods();
			for (Method m : methods) {
				System.out.println(m.getName());
				String mname = m.getName();

				if (mname.startsWith("get")) {
					if (mname.contains("id")) {
						continue;
					}
					Object value = m.invoke(obj, null);
					System.out.println("value-->" + value);

					listValues.add(value);
				}
			}
			for (int i = 0; i < listValues.size(); i++) {

				Object objValue = listValues.get(i);
				if (i == listValues.size() - 1) {
					if (objValue instanceof String) {
						sb.append("'" + objValue + "'"  + ")");
					}
					else if(objValue instanceof Integer)
					{
						sb.append( objValue + ")");
					}
				} else {
					if (objValue instanceof String) {
						sb.append("'" + objValue + "'" + ",");
					}
					else if(objValue instanceof Integer)
					{
						sb.append( objValue + ",");
					}

				}

			}

			System.out.println(sb.toString());
			
			//下面插入你们自己写
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//select  * from  
	//select  * from  where 
	public  static  List<Map<String,Object>>   queryAll(Class  c)
	{
		StringBuffer  sb = new StringBuffer();
		sb.append("select  *  from  ");
		String cname = c.getName();
		String name = cname.substring(cname.lastIndexOf(".") + 1);

		System.out.println("name-->" + name);

		String tableName = "t_" + name.substring(0, 1).toLowerCase()
				+ name.substring(1);
		System.out.println("tableName-->" + tableName);
		
		sb.append(tableName);
		
		System.out.println(sb.toString());
		
		
		
		return null;

	}
	public  static  List<Map<String,Object>>   queryWhereAll(Class  c,Object[]  objs)
	{
		
		return null;
	}
	
	public  static  List<Map<String,Object>>   queryGroupAll(Class  c,Object[]  objs)
	{
		
		return null;
	}
}
