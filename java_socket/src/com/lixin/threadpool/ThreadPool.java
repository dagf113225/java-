package com.lixin.threadpool;

import java.util.Vector;

public class ThreadPool {

	// 定义可以配置数量的线程的个数
	private int maxNum = 0;

	// 定义线程池的集合
	private Vector<Runnable> vectors;

	public ThreadPool(int maxNum) {
		this.maxNum = maxNum;

		// 初始化线程池的集合
		vectors = new Vector<Runnable>(this.maxNum);

		// 线程池构建的线程的数量
		for (int i = 0; i < vectors.capacity(); i++) {
			WorkThread workThread = new WorkThread();
			vectors.add(workThread);

			workThread.start();
		}

	}

	
	//调度线程池的线程出来干活完成任务
	public  void  execBindThreadToTask(String taskName)
	{
		int i = 0;
		
		//找出线程池中哪些线程是没有活干的线程，出来完成任务
		for (; i < vectors.capacity(); i++) {
			WorkThread  workThread=(WorkThread)vectors.get(i);
			
			System.out.println("没有活干的休闲的线程名称为:" +
					""+workThread.getName()+",状态为:"+workThread.isFlag());
			        
			
		    if(!workThread.isFlag())
		    {
		    
		    	System.out.println(workThread.getName()+",准备出来完成任务，任务的名称为:"+taskName);
		    
		    	workThread.setFlag(true);
		    	
		    	workThread.setTaskName(taskName);
		    	
		    	//一个任务一个线程
		        break;
		    }
			
		}
		if(i==vectors.capacity())
		{
			System.out.println("任务名称为:"+taskName+",不好意思，服务数量已经满，请等待...");
		}
		
	}
	

}
