package com.javaboost.core.thread.course.int_lock;

public class IntrLockApp {
	public static void main(String[] args) {
		Counter lCounter = new Counter();
		Thread lThreadInc = new Thread(new CouterIncRunnable(lCounter));
		Thread lThreadDec = new Thread(new CouterDecRunnable(lCounter));

		lThreadInc.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lThreadDec.start();

		try {
			System.out.println("Waiting ...................");
			lThreadInc.join();
			lThreadDec.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Completed...................");

	}
}

class CouterDecRunnable implements Runnable {
	private Counter counter;

	public CouterDecRunnable(Counter pCounter) {
		super();
		counter = pCounter;
	}

	@Override
	public void run() {
		System.out.println("Trying to Decrement counter value..........");

		counter.decrement();
		System.out.println("Decrement counter value:" + counter.num);

	}
}

class CouterIncRunnable implements Runnable {
	private Counter counter;

	public CouterIncRunnable(Counter pCounter) {
		super();
		counter = pCounter;
	}

	@Override
	public void run() {
		System.out.println("Trying to increment counter value..........");
		counter.increment();

		System.out.println("Increment counter value:" + counter.num);

	}
}

class Counter {
	int num;

	Object mutexInc = "I" ;
	Object mutexDec = "D";

	public void increment() {

		synchronized (mutexInc) {
			System.out.println("Aquired INCREMENT lock..........");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num++;
		}

		System.out.println("Release INCREMENT lock..........");
	}

	public synchronized void decrement() {
		//synchronized (mutexInc) {
			System.out.println("Aquired DECREMENT lock..........");
			num--;
		//}
		System.out.println("Release DECREMENT lock..........");
	}
}
