package com.lixin.view;

import java.util.Scanner;

import com.lixin.action.utils.ServletAction;

public class Userstart {
	
	public static void main(String[] args) {
		
		System.out.println("�����������Ķ�����ʲô?");
		
		Scanner  s  = new Scanner(System.in);
		
		String  actionName=s.next();
		
	System.out.println("�����������Ķ�������?");
		
		Scanner  s1  = new Scanner(System.in);
		
		String  actionType=s1.next();
		
		// /users
		ServletAction   sa = new ServletAction();
		sa.exec(actionName,actionType);
		
	}

}
