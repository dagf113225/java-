package com.wqm.test;

public class Test {
	private String name="呆子";
	
	public  int age=40;
	
	private  boolean  flag;
	
	public  double  ss=20.009;
	
	private void check1() {
		System.out.println("这是check1私有方法");
	}
	
	public void check2() {
		System.out.println("这是check2公有方法");
	}
	
	
	
	public Test(){
		System.out.println("这是构造函数");
	}
	
	public Test(int a) {
		System.out.println("这是共有的构造函数");
	}
	
}
