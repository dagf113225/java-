package com.lixin.ch4;

public class User {
	
	private  int  age=20;
	
	public String  s="123aaa";
	
	
	public  User()
	{
		System.out.println("user���Ĭ���޲ι��캯��");
		
	}
	
	private  User(int a,String b)
	{
		System.out.println("ִ�й��캯��**************"+a+b);
	}
	private  User(String b,int a)
	{
		System.out.println("ִ�й��캯��**************"+a+b);
	}
	
	public  void  check(double  s)
	{
		System.out.println("ִ��check����**************"+s);
	}
	

}
