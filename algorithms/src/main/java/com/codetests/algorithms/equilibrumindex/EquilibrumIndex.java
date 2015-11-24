package com.codetests.algorithms.equilibrumindex;

public class EquilibrumIndex {

	static int[] testCase = {-7, 1, 5, 2, -4, 3, 0}; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new EquilibrumIndex().getEquilibrumIndex(testCase));
	}

	public int getEquilibrumIndex(int[] array) {
		if (array == null || array.length == 0)
			return -1;
		else if (array.length == 1)
			return 0;
		
		double accum = 0;
		double total= addAll(array);
		for (int i = 0; i < array.length; i++) {
			total = total - array[i]; 
			if (total == accum)
				return i;
			accum += array[i];
		}
		return -1;
	}
	
	public double addAll(int[] array) {
		double accumulated = 0;
		for (int i = 0; i < array.length; i++) {
			accumulated += array[i];
		}
		return accumulated;
	}
}
