package com.lixin.ch4;

public class User {
	
	private  int  age=20;
	
	public String  s="123aaa";
	
	
	public  User()
	{
		System.out.println("user类的默认无参构造函数");
		
	}
	
	private  User(int a,String b)
	{
		System.out.println("执行构造函数**************"+a+b);
	}
	private  User(String b,int a)
	{
		System.out.println("执行构造函数**************"+a+b);
	}
	
	public  void  check(double  s)
	{
		System.out.println("执行check函数**************"+s);
	}
	

}
