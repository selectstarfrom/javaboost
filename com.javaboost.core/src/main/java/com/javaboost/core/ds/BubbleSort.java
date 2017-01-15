package com.javaboost.core.ds;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {

		int[] lArray = { 1, 4, 15, 3, 6, 7, 9, 2, 3, 11, 99, 0, 3 };

		System.out.println("INPUT (" +lArray.length+"):"+ Arrays.toString(lArray));
		for (int lI = 0; lI < lArray.length; lI++) {

			for (int lI2 = 0; lI2 < (lArray.length-1); lI2++) {

				int lFirst = lArray[lI2];
				int lSecond = lArray[lI2 + 1];

				if (lFirst > lSecond) {
					int lTemp = lFirst;
					lArray[lI2] = lSecond;
					lArray[lI2+1] = lTemp;
				}
			}

		}

		System.out.println("OUTPUT: " + Arrays.toString(lArray));
	}
}
