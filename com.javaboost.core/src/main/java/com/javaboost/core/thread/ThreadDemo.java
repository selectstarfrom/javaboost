package com.javaboost.core.thread;

public class ThreadDemo implements Runnable {

	public void run() {

		int i= 0;
		while (i<10) {
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread t = Thread.currentThread();
			System.out.print(t.getName());
			// checks if this thread is alive
			System.out.println(", status = " + t.isAlive());
		}
	}

	public static void main(String args[]) throws Exception {

		Thread t = new Thread(new ThreadDemo());
		// this will call run() function
		t.start();
		// waits for this thread to die
		t.join();
		System.out.print(t.getName());
		// checks if this thread is alive
		System.out.println(", status = " + t.isAlive());
		System.out.println("------------------------------------------");
	}
}