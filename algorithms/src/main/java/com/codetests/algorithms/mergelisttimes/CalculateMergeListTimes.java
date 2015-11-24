package com.codetests.algorithms.mergelisttimes;

import java.util.Arrays;

public class CalculateMergeListTimes {

	static int[] listSimzes = {1000, 100, 250, 2000 };
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new CalculateMergeListTimes().getTimes(listSimzes));

	}
	
	public int getTimes(int[] A) {
		
		Arrays.sort(A);
		Integer[] sumsList = new Integer[A.length -1];
		int previousListSize = A[0];
		for (int i = 1; i < A.length; i++) {
			sumsList[i-1]= previousListSize = previousListSize + A[i];
		}
		int accum = 0;
		for (int i = 0; i < sumsList.length; i++) {
			accum += sumsList[i];
		}
		return accum;
	}

}
