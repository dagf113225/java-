package com.lixin.ch3;

public class Test {
	public static void main(String[] args) {
		
//		Classes  c = new Classes();
//		
//		c.setCname("flutter��");
//		c.setCddress("�Ϻ�");
//		c.setCqq("512444862@qq.com");
//		
//		DBUtils.insertObject(c);
//
//		
//		Role  r =  new Role();
//		r.setRname("�鳤");
//		DBUtils.insertObject(r);
		
		
		Menu  menu = new Menu();
//		menu.setTname("dart����");
//		menu.setTurl("a10.html");
//		menu.setTstats(1);
//		menu.setImgpath("a1.png");
//		DBUtils.insertObject(menu);
		
		DBUtils.queryAll(Menu.class);
	}

}
