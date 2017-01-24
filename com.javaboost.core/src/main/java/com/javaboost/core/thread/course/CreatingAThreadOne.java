package com.javaboost.core.thread.course;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CreatingAThreadOne {
	public static void main(String args[]) {
		
		long myNum = 9223372036854775783L;

		System.out.println("Number to factor: " + myNum);

		MyCalculations mc = new MyCalculations(myNum);
		Thread t = new Thread(mc);
		t.start();

		Thread mainThread = Thread.currentThread(); // main thread
		int spinner = 0;
		String animation = "|";
		System.out.println("Active threads for this thread group: " + Thread.activeCount());
		System.out.print("Calculating  ");
		
		JFrame lFrame = new JFrame();
		JPanel lComp = new JPanel();
		lComp.setMinimumSize(new Dimension(100, 100));
		JLabel lLable = new JLabel("|");
		lLable.setFont(new Font(Font.MONOSPACED, Font.BOLD, 205));
		lComp.add(lLable);
		lFrame.add(lComp);
		lFrame.setVisible(true);
		lFrame.setSize(450, 400);
		while (t.isAlive()) {
			spinner++;
			switch (spinner) {
			case 1:
				animation = "|";
				break;
			case 2:
				animation = "/";
				break;
			case 3:
				animation = "--";
				break;
			case 4:
				animation = "\\";
				spinner = 0;
				break;
			}
			lLable.setText(animation+"");
			System.out.print(animation);

			try {
				mainThread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Main thread interrupted");
			}
		}
		System.out.println("Active threads for this thread group: " + Thread.activeCount());
		lFrame.dispose();
	}
}

class MyCalculations implements Runnable {
	private long numberToFactor = 0;

	MyCalculations(long numberToFactor) {
		this.numberToFactor = numberToFactor;
	}

	@Override
	public void run() { // this is where the new thread starts
		isItPrime();
	}

	private void isItPrime() { // only designed to work with odd numbers
		long squareRoot = (long) Math.sqrt(numberToFactor);
		for (long i = 3; i <= squareRoot; i += 2) {
			if (numberToFactor % i == 0) { // when the remainder is 0 the number
											// is evenly divisible - hence not
											// prime
				System.out.println("\n" + numberToFactor + " is NOT Prime ... first divisible by " + i);
				return;
			}
		}
		System.out.println("\n" + numberToFactor + " is Prime!");
		return;
	}
}