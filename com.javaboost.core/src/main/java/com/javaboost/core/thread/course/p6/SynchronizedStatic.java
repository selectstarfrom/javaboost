package com.javaboost.core.thread.course.p6;

import java.util.ArrayList;

class SynchronizedStatic {
	public static void main(String args[]) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			new NumberThread(i);
		}
		System.out.println("Active threads: " + Thread.activeCount());
		Thread.currentThread().getName();
		//Thread.currentThread().join();
		while(Thread.activeCount()>1){
			
		}
		StaticList.displayList();
	}
}

class StaticList {
	private static ArrayList<Integer> numberList = new ArrayList<>();

	static synchronized void addToList(Integer number) {
		numberList.add(number); // ArrayList add() method in addToList is not
								// thread-safe - problems
	}

	static void displayList() {
		System.out.println(numberList);
	}
}

class NumberThread implements Runnable {
	private int number = 0;

	NumberThread(int number) {
		this.number = number;
		Thread lThread = new Thread(this);
		lThread.start();
	}

	@Override
	public void run() { // this is where the new thread starts
		StaticList.addToList(number);
	}
}