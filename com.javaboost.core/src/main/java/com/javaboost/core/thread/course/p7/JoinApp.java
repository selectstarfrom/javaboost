package com.javaboost.core.thread.course.p7;

public class JoinApp {
	public static Integer num = 1;

	public static void main(String[] args) {

		for (int lI = 0; lI < 100000; lI++) {
			Sum lTarget = new Sum();
			Thread lThread = new Thread(lTarget);
			lThread.start();
			try {
				lThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(num);
	}
}

class Sum implements Runnable {

	// Integer num;

	// public Sum(Integer pNum) {
	// super();
	// num = pNum;
	// }

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JoinApp.num++;
	}

}
