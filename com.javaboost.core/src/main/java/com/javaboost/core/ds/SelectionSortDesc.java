package com.javaboost.core.ds;

import java.util.Arrays;

public class SelectionSortDesc {
	public static void main(String[] args) {
		int[] lArray = { 1, 4, 15, 3, 6, 7, 9, 2, 3, 11, 99, 0, 3 };

		System.out.println("INPUT (" + lArray.length + "):" + Arrays.toString(lArray));

		int lTemp = 0;

		int i, j, first, temp;
		for (i = lArray.length - 1; i > 0; i--) {
			first = 0; // initialize to subscript of first element
			for (j = 1; j <= i; j++) { // locate smallest element between positions 1 and i.
							
				int lJElement = lArray[j];
				int lFirstElement = lArray[first];
				
				if (lArray[j] < lArray[first])
					first = j;
			}
			temp = lArray[first]; // swap smallest found with element in
									// position i.
			lArray[first] = lArray[i];
			lArray[i] = temp;
		}
		System.out.println("OUTPUT: " + Arrays.toString(lArray));
	}
}
