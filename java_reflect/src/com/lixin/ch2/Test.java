package com.lixin.ch2;

import java.util.Scanner;

public class Test {

	
	public static void main(String[] args) {
		
		while(true)
		{
			System.out.println("请问用户你需要什么?");
			
			Scanner  s = new Scanner(System.in);
			String name=s.next();
			
			Animal an =null;
			try {
				an = AnimalFactory.getFactory(name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			an.eat();
		}
	
		
		
	}
}
