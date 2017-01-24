package com.javaboost.core.thread.course.p5;

public class JoinApp {
	public static void main(String[] args) {
		Thread lThread = new Thread(new RunnableMain());
		lThread.start();

		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");

	}
}

class RunnableMain implements Runnable {

	@Override
	public void run() {

		Thread lThread1 = null;
		Thread lThread2 = null;
		lThread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int lI = 0; lI < 10000; lI++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ": " + lI);
					System.out.println(Thread.currentThread().getName() + ": " + lI);
				}

			}
		});
		lThread1.setName("Child");
		lThread1.start();

		

		lThread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int lI = 50000; lI < 100000; lI++) {
					try {
						//System.out.println(lThread1.getName() + ": " + lThread1.getState());
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ": " + lI);
				}

			}
		});
		lThread2.setName("Child");
		lThread2.start();
		
		try {
			lThread1.join(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
