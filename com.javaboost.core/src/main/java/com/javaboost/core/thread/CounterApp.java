package com.javaboost.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CounterApp {
	public static void main(String[] args) {
		Counter lCounter = new Counter();
		Runnable lRunnable1 = new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {
					lCounter.increment();
				}
			}
		};

		Runnable lRunnable2 = new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {
					lCounter.increment();
				}
			}
		};

		Runnable lRunnable3 = new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 1000000; i++) {
					
					
					lCounter.increment();
				}
			}
		};

		ExecutorService lNewFixedThreadPool = Executors.newFixedThreadPool(5);
		lNewFixedThreadPool.submit(lRunnable1);
		lNewFixedThreadPool.submit(lRunnable2);
		lNewFixedThreadPool.submit(lRunnable3);

		lNewFixedThreadPool.shutdown();
		
		try {
			lNewFixedThreadPool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(lCounter.COUNT);
	}

}

class Counter {
	public static int COUNT;

	public static void increment() {
		COUNT++;
		COUNT++;
		COUNT++;
		COUNT++;
		COUNT++;
	}
}
