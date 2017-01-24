package com.javaboost.core.thread;

class TestInterruptingThread2 extends Thread {
	public void run() {
		while (!Thread.interrupted()) {
			try {
				// Thread.sleep(1000);
				System.out.println("task");
			} catch (Exception e) {
				System.out.println("Exception handled " + e);
			}
		}
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		TestInterruptingThread2 t1 = new TestInterruptingThread2();
		t1.start();
		 try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();

	}
}