package com.codetest.impl;
/**
 * Gamesys
 *
 */
public class DivisibleIntsImpl {
	
	static int[] testCase = {6, 11, 2};
	
	public static void main(String[] args) {
		System.out.println(new DivisibleIntsImpl().solution(testCase[0], testCase[1], testCase[2]));

	}
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @param K
	 * @return
	 */
	public int solution(int A, int B, int K) {
		int lower = A;
		int higher = B;
		if (K <= 0)
			return 0;
		if (A > B){
			lower = B;
			higher = A;
		}
		int numberOfDvisibleNumbers = 0;
		for (int i = lower; i <= higher; i++) {
			if (i % K == 0){
				numberOfDvisibleNumbers ++;	
			}
		}
		return numberOfDvisibleNumbers;
    }
}
