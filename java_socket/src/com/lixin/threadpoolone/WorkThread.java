package com.lixin.threadpoolone;

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

				// ģ����������ʱ��Ϊ30��
				try {
					Thread.sleep(30 * 1000);
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

				// ���񼯺��л���û����ɵ�����
				if (ApplicationStart.taskLists.size() > 0) {
					String taskName = ApplicationStart.taskLists.get(0);
					System.out.println("����û����ɵ����������Ϊ:" + taskName);

					ThreadPool.execBindThreadToTask(taskName);

					System.out.println(Thread.currentThread().getName()
							+ "�����������񼯺��л���û����ɵ�����" + "��ʼִ���������:" + taskName);

				} else {
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
}
