package com.javaboost.core.thread.course.safety;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class CreatingAThreadone {

	private static CopyOnWriteArrayList<String> primeList = new CopyOnWriteArrayList<>();

	static void addToList(String message) {
		primeList.add(message);
	}

	static CopyOnWriteArrayList<String> getListReference() {
		return primeList;
	}

	public static void main(String args[]) {

		for (long x = 6223372036854775899L; x <= 6223372036854775999L; x += 2) {
			new Thread(new MyCalcRunnable(x)).start();
		}
		for (long x = 9223372036854775703L; x <= 9223372036854775789L; x += 2) {
			new MyCalcThread(x, "myChildThread" + x);
		}

		Thread mainThread = Thread.currentThread(); // main thread
		int spinner = 0;
		char animation = ' ';
		System.out.println("Total number of active threads: " + Thread.activeCount());
		System.out.print("Calculating primes: ");
		while (Thread.activeCount() > 1) {
			spinner++;
			switch (spinner) {
			case 1:
				animation = '|';
				break;
			case 2:
				animation = '/';
				break;
			case 3:
				animation = '-';
				break;
			case 4:
				animation = '\\';
				spinner = 0;
				break;
			}
			//System.out.print("\b" + animation);

			try {
				mainThread.sleep(00);
			} catch (InterruptedException e) {
				System.out.println("Main thread interrupted");
			}
		}
		System.out.println();
		CopyOnWriteArrayList<String> filledList = CreatingAThreadone.getListReference();
		int i=1;
		for (String s : filledList) {
			System.out.println(i++ + "-"+s);
		}
	}

}

class MyCalcThread extends Thread {
	private long numberToFactor = 0;

	MyCalcThread(long numberToFactor, String threadName) {
		super(threadName);
		this.numberToFactor = numberToFactor;
		start();
	}

	@Override
	public void run() { // this is where the new thread starts
		CreatingAThreadone.addToList(new PrimeStuff().isItPrime(numberToFactor));
	}

}

class MyCalcRunnable implements Runnable {
	private long numberToFactor = 0;

	MyCalcRunnable(long numberToFactor) {
		this.numberToFactor = numberToFactor;
	}

	@Override
	public void run() { // this is where the new thread starts
		CreatingAThreadone.addToList(new PrimeStuff().isItPrime(numberToFactor));
	}

}

class PrimeStuff {
	String isItPrime(long numberToFactor) {
		if (numberToFactor % 2 == 0)
			return (numberToFactor + " is NOT Prime ... divisible by 2");

		long squareRoot = (long) Math.sqrt(numberToFactor);
		for (long i = 3; i <= squareRoot; i += 2) {
			if (numberToFactor % i == 0) { // when the remainder is 0 the number
											// is evenly divisible - hence not
											// prime
				return (numberToFactor + " is NOT Prime ... first divisible by " + i);
			}
		}
		return (numberToFactor + " is Prime!!!");
	}
}