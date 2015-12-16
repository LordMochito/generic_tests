package com.codetests.algorithms.decimalzip;

/**
 * The decimal zip of two non-negative integers A and B is an integer C whose decimal representation 
 * is created from the decimal representations of A and B as follows:
 * 
 * the first (i.e. the most significant) digit of C is the first digit of A;
 * the second digit of C is the first digit of B;
 * the third digit of C is the second digit of A;
 * the fourth digit of C is the second digit of B;
 * etc.
 * 
 * If one of the integers A and B runs out of digits, the remaining digits of the other integer are appended to the result. 
 * The decimal representation of 0 is assumed to be.
 * For example, the decimal zip of 12 and 56 is 1526. The decimal zip of 56 and 12 is 5162. 
 * The decimal zip of 12345 and 678 is 16273845. The decimal zip of 123 and 67890 is 16273890. 
 * The decimal zip of 1234 and 0 is 10234.
 *
 * Given two non-negative integers A and B, returns their decimal zip. 
 * The function should return −1 if the result exceeds 100,000,000.
 * For example, given A = 12345 and B = 678 the function should return 16273845, as explained above.
 * 
 * Assume that:
 * 
 * A and B are integers within the range 100,000,000
 * 
 * 
 */
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
