package com.javaboost.core.thread;

class TestInterruptingThread1 extends Thread {
	public void run() {
		try {
			while (true) {
				//Thread.wait(1000);
				wait(1000);
				System.out.println("task");
			}
		} catch (Exception e) {
			System.out.println("Thread interrupted...");
		}

	}

	public static void main(String args[]) {
		TestInterruptingThread1 t1 = new TestInterruptingThread1();
		t1.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			System.out.println("Interrupted");
		}
		t1.interrupt();

	}
}