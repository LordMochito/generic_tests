package com.codetests.algorithms.missingnumber;

/**
 * Given a list of unsorted numbers between 1 and n, one number is missing.
 * Write an efficient program to find it.
 */
public class MissingNumber {
	static int[] origin = {1,2,3,5,4,7};
	static int[] origin2 = {1,2,3,5,4,7,6,10,9};
	static int[] origin3 = {1,2,3,5,7,6,8,9};

	public static void main(String[] args) {
		otherWay(origin);
		otherWay(origin2);
		otherWay(origin3);
	}
	// linear
	private static void otherWay(final int[] list) {
		int[] temp = new int[list.length +2]; //cause the element 0 and the missing one
		for (Integer integer : list) {
			temp[integer] = integer;
		}
		for (int i = 1; i < temp.length; i++) {
			if (temp[i] == 0)
				System.out.println("otherWay: Missing :" + i);

		}
	}
}
