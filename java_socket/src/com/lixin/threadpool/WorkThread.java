package com.lixin.threadpool;

public class WorkThread extends Thread {

	// 线程有无活干的状态标识位
	private boolean isFlag;

	// 任务名称
	private String taskName;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public boolean isFlag() {
		return isFlag;
	}

	public synchronized void setFlag(boolean isFlag) {

		this.isFlag = isFlag;

		if (this.isFlag) {
			this.notify();
		}

	}

	public synchronized void run() {

		// System.out.println(Thread.currentThread().getName()+",线程都开始启动...........");
		// 保证线程不死
		while (true) {

			// 怎么来区分线程没有活干，和有活干的状态呢?
			if (isFlag())// 真为:这个线程有活干
			{

				System.out.println(Thread.currentThread().getName()
						+ ",线程开始准备完成任务-->start任务名称为:" + this.taskName);

				// 模拟任务的完成时间为20秒
				try {
					Thread.sleep(20 * 1000);
					System.out.println(Thread.currentThread().getName()
							+ ",已经完成任务-->end任务名称为:" + this.taskName);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 回归线程池
				this.setFlag(false);

			} else {
				System.out.println(Thread.currentThread().getName() + ","
						+ "线程都在没有活干的休闲的状态中，等待任务的调度....");

				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}
}
