package com.lixin.threadpoolone;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;

public class ApplicationStart {
	static Properties p;
	
	//��������ļ���
	static  LinkedList<String>  taskLists= new LinkedList<String>();
	
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
 
		//�̳߳ص����������ã�����ʼ���̳߳أ������߳�
		int count = Integer.parseInt(p.getProperty("poolsize"));
		ThreadPool pool = new ThreadPool(count);
		
		
		//����������Բ������̳߳����߳�
		Scanner  s = new Scanner(System.in);
		
		String  taskName="";
		
		while(true)
		{
		
			//��������
			taskName=s.next();
			
			//�������LinkedList����
			taskLists.add(taskName);
			
			//�������ˣ������̳߳��е��̳߳����ɻ�
			pool.execBindThreadToTask(taskLists.get(0));
		}
		
		
	}

	public static void main(String[] args) {
		ApplicationStart  ap = new ApplicationStart();
		ap.init();
		
	
	}
}
