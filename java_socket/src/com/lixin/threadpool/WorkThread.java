package com.lixin.threadpool;

public class WorkThread extends Thread {

	// �߳����޻�ɵ�״̬��ʶλ
	private boolean isFlag;

	// ��������
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

		// System.out.println(Thread.currentThread().getName()+",�̶߳���ʼ����...........");
		// ��֤�̲߳���
		while (true) {

			// ��ô�������߳�û�л�ɣ����л�ɵ�״̬��?
			if (isFlag())// ��Ϊ:����߳��л��
			{

				System.out.println(Thread.currentThread().getName()
						+ ",�߳̿�ʼ׼���������-->start��������Ϊ:" + this.taskName);

				// ģ����������ʱ��Ϊ20��
				try {
					Thread.sleep(20 * 1000);
					System.out.println(Thread.currentThread().getName()
							+ ",�Ѿ��������-->end��������Ϊ:" + this.taskName);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// �ع��̳߳�
				this.setFlag(false);

			} else {
				System.out.println(Thread.currentThread().getName() + ","
						+ "�̶߳���û�л�ɵ����е�״̬�У��ȴ�����ĵ���....");

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
