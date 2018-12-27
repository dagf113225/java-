package com.lixin.ch5;

import java.util.Scanner;

public class UserAction {


	private Dao dao=null;

	public void setDao(Dao dao) {
		this.dao = dao;
	}
//	public void setDao(UserOracleDao dao) {
//		this.dao = dao;
//	}

	public void exec() {

		System.out.println("--------exec-------");
		// 面向对象的写法
		// dao = new UserMysqlDao();
		// dao.checkLogin();

		// 代码结构不变，不能通过面向对象去new 对象，最后的结果完成实例化。
		dao.checkLogin();

	}

	public void execone() {

		System.out.println("--------execone-------");
		// 面向对象的写法
		// dao = new UserMysqlDao();
		// dao.checkLogin();

		// 代码结构不变，不能通过面向对象去new 对象，最后的结果完成实例化。
		dao.query();

	}

	public static void main(String[] args) {
		// UserAction ua = new UserAction();
		// ua.exec();

		System.out.println("请问用户的动作名称是什么?");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		XMLParse xp = XMLParse.getInstace();
		UserAction ua = (UserAction) xp.getBean(name);
		ua.exec();
		ua.execone();

	}
}
