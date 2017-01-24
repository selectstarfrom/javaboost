package com.javaboost.core.thread.course.p4;

class CreatingAThreadFour {

	public static void main(String args[]) {

		Thread mainThread = Thread.currentThread(); // main thread
		System.out.println("Calculating primes: ");
		for (long x = 6223372036854775799L; x <= 6223372036854775999L; x += 2) {
			new MyCalculations(x);
		}
		System.out.println("Total number of active threads: " + Thread.activeCount());
		int spinner = 0;
		String animation = "Calculating ";
		while (Thread.activeCount() > 1) {
			spinner++;
			switch (spinner) {
			case 1:
				animation = "Calculating ";
				break;
			case 2:
				animation = "            ";
				spinner = 0;
				break;
			}
			System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b" + animation);

			try {
				mainThread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println("Main thread interrupted");
			}
		}
	}

}

class MyCalculations implements Runnable {
	private long numberToFactor = 0;

	MyCalculations(long numberToFactor) {
		this.numberToFactor = numberToFactor;
		new Thread(this).start();
	}

	@Override
	public void run() { // this is where the new thread starts
		isItPrime(numberToFactor);
	}

	void isItPrime(long numberToFactor) {
		if (numberToFactor % 2 == 0) {
			System.out.println(numberToFactor + " is NOT Prime ... divisible by 2");
			return;
		}
		long squareRoot = (long) Math.sqrt(numberToFactor);
		for (long i = 3; i <= squareRoot; i += 2) {
			if (numberToFactor % i == 0) { // when the remainder is 0 the number
											// is evenly divisible - hence not
											// prime
				System.out.println(numberToFactor + " is NOT Prime ... first divisible by " + i);
				return;
			}
		}
		System.out.println(numberToFactor + " is Prime!!!");
	}
}
