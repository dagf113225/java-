package com.lixin.view;

import java.util.Scanner;

import com.lixin.action.utils.ServletAction;

public class Userstart {
	
	public static void main(String[] args) {
		
		System.out.println("请问你的请求的动作是什么?");
		
		Scanner  s  = new Scanner(System.in);
		
		String  actionName=s.next();
		
	System.out.println("请问你的请求的动作类型?");
		
		Scanner  s1  = new Scanner(System.in);
		
		String  actionType=s1.next();
		
		// /users
		ServletAction   sa = new ServletAction();
		sa.exec(actionName,actionType);
		
	}

}
