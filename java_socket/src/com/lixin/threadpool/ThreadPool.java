package com.lixin.threadpool;

import java.util.Vector;

public class ThreadPool {

	// ������������������̵߳ĸ���
	private int maxNum = 0;

	// �����̳߳صļ���
	private Vector<Runnable> vectors;

	public ThreadPool(int maxNum) {
		this.maxNum = maxNum;

		// ��ʼ���̳߳صļ���
		vectors = new Vector<Runnable>(this.maxNum);

		// �̳߳ع������̵߳�����
		for (int i = 0; i < vectors.capacity(); i++) {
			WorkThread workThread = new WorkThread();
			vectors.add(workThread);

			workThread.start();
		}

	}

	
	//�����̳߳ص��̳߳����ɻ��������
	public  void  execBindThreadToTask(String taskName)
	{
		int i = 0;
		
		//�ҳ��̳߳�����Щ�߳���û�л�ɵ��̣߳������������
		for (; i < vectors.capacity(); i++) {
			WorkThread  workThread=(WorkThread)vectors.get(i);
			
			System.out.println("û�л�ɵ����е��߳�����Ϊ:" +
					""+workThread.getName()+",״̬Ϊ:"+workThread.isFlag());
			        
			
		    if(!workThread.isFlag())
		    {
		    
		    	System.out.println(workThread.getName()+",׼����������������������Ϊ:"+taskName);
		    
		    	workThread.setFlag(true);
		    	
		    	workThread.setTaskName(taskName);
		    	
		    	//һ������һ���߳�
		        break;
		    }
			
		}
		if(i==vectors.capacity())
		{
			System.out.println("��������Ϊ:"+taskName+",������˼�����������Ѿ�������ȴ�...");
		}
		
	}
	

}
