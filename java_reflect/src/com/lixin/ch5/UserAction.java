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
		// ��������д��
		// dao = new UserMysqlDao();
		// dao.checkLogin();

		// ����ṹ���䣬����ͨ���������ȥnew �������Ľ�����ʵ������
		dao.checkLogin();

	}

	public void execone() {

		System.out.println("--------execone-------");
		// ��������д��
		// dao = new UserMysqlDao();
		// dao.checkLogin();

		// ����ṹ���䣬����ͨ���������ȥnew �������Ľ�����ʵ������
		dao.query();

	}

	public static void main(String[] args) {
		// UserAction ua = new UserAction();
		// ua.exec();

		System.out.println("�����û��Ķ���������ʲô?");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		XMLParse xp = XMLParse.getInstace();
		UserAction ua = (UserAction) xp.getBean(name);
		ua.exec();
		ua.execone();

	}
}
