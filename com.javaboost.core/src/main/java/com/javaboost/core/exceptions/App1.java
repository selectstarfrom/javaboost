package com.javaboost.core.exceptions;

public class App1 {
	public static void main(String[] args) throws Throwable {

		App1 lApp1 = new App1();
		lApp1.test();
		lApp1 = null;
		System.gc();
		for (int lI = 0; lI < 1000000000; lI++) {
			for (int k = 0; k < 1000000000; k++) {
				for (int j = 0; j < 1000000000; j++) {
					
				}
			}
		}
		try {
			String lValue = null;
			// System.out.println(lValue.length());
			//System.exit(0);
		} catch (NullPointerException pException) {
			System.out.println("NullPointerException Block");
		} catch (Exception pException) {
			System.out.println("Exception Block");
		} finally {
			System.out.println("Final Block");
		}
	}

	void test() throws Exception {

	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize");
	}
}
