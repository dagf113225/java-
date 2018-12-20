package com.lixin.threadpool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class ApplicationStart {
	static Properties p;
	static {
		p = new Properties();

		try {
			FileReader fr = new FileReader(
					"./src/com/lixin/threadpool/poolconfig.properties");

			p.load(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() {
 
		//线程池的数量可配置，并初始化线程池，启动线程
		int count = Integer.parseInt(p.getProperty("poolsize"));
		ThreadPool pool = new ThreadPool(count);
		
		
		//构建任务测试并调度线程池中线程
		Scanner  s = new Scanner(System.in);
		
		String  taskName="";
		
		while(true)
		{
		
			taskName=s.next();
			
			//任务来了，调度线程池中的线程出来干活
			pool.execBindThreadToTask(taskName);
		}
		
		
	}

	public static void main(String[] args) {
		ApplicationStart  ap = new ApplicationStart();
		ap.init();
		
	
	}
}
