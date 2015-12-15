package com.codetests.algorithms.decimalzip;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(12, 56));
	}

	public int solution(int A, int B) {
		int result = 0;
		while (A > 0 || B > 0) {
			result = result * 10;
			result += (B % 10);
			B = B / 10;
			result = result * 10;
			result += (A % 10);
			A = A / 10;
		}
		return reverse(result);
	}

	private int reverse(int a) {
		int reverse = 0;
        int rest = 0;
        do{
            rest = a % 10;
            reverse = reverse * 10 + rest;
            a = a/10;
          
        }while(a > 0);
        return reverse;

	}
}
