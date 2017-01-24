package com.javaboost.core.ds;

import java.util.Arrays;

public class SelectionSortAsc {
	public static void main(String[] args) {
		int[] lArray = { 5, 6, 2, 9, 3, 56, 231, 23, 23, 23, 234, 54, 25, 42, 34, 34, 12, 3, 7 };
		System.out.println("INPUT (" + lArray.length + "):" + Arrays.toString(lArray));

		for (int lI1 = 0; lI1 < lArray.length-1; lI1++) {
			
			int lLast = lArray.length - 1;
			
			for (int lI2 = 0; lI2 < lArray.length - lI1-2; lI2++) {
				if (lArray[lI2] < lArray[lLast]) {
					lLast = lI2;
				}
			}

			int lTemp = lArray[lI1];
			lArray[lI1] = lArray[lLast];
			lArray[lLast] = lTemp;
		}

		System.out.println("OUTPUT (" + lArray.length + "):" + Arrays.toString(lArray));
	}
}
