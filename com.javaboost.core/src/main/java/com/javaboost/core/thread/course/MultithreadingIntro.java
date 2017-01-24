package com.javaboost.core.thread.course;

class MultithreadingIntro {
	public static void main(String args[]) {
		Thread mt = Thread.currentThread();
		System.out.println("Main thread name = " + mt.getName());
		System.out.println("Main thread state = " + mt.getState());
		System.out.println("Thread class MAX_PRIORITY = " + Thread.MAX_PRIORITY);
		System.out.println("Thread class MIN_PRIORITY = " + Thread.MIN_PRIORITY);
		System.out.println("Thread class NORM_PRIORITY = " + Thread.NORM_PRIORITY);
		System.out.println("Main thread priority = " + mt.getPriority());
		System.out.println("Main thread group = " + mt.getThreadGroup());
		System.out.println("Have the main thread sleep for 1 second eight times...");
		for (int i = 0; i < 8; i++) {
			System.out.println("Sleeping ... " + (i + 1));
			try {
				mt.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("main thread interupted: " + e.getMessage());
			}
		}
		System.out.println("Main thread toString() = " + mt.toString());
	}
}