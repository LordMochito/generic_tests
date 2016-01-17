package com.codetests.algorithms.wholesquare;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(1, -2));
	}

	public int solution(int A, int B) {
		if (A < 0)
			return 0;
		if (B < 0)
			return 0;
		int lower = A;
		int higher = B;
		if ( A > B){
			lower = B;
			higher = A;
		}
		if ( A == B){
			if (isIntegerWholeSquare(A))
				return 1;
			else return 0;
		}
		return loopOverInputIntegers(lower, higher);
	}

	private int loopOverInputIntegers(int A, int B) {
		int result = 0;
		for (int i = A; i < B; i++) {
			if (isIntegerWholeSquare(i))
				result++;
		}
		return result;
	}
	private boolean isIntegerWholeSquare(int intNumber) {
		double sqrt = Math.sqrt(intNumber);
		return ((sqrt % 1) == 0);
	}
}
