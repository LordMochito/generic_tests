package com.codetests.algorithms.twopowern;

/**
 *
A non-empty zero-indexed array A consisting of N non-negative integers is given. This array defines a number M as follows:
M = pm2(A[0]) + pm2(A[1]) + ... + pm2(A[N−1])
pm2(N) = (−2)N
For example, array A such that:
  A[0] = 5  A[1] = 4  A[2] = 7
defines the number −144, because:
  pm2(A[0]) + pm2(A[1]) + pm2(A[2]) =
  pm2(5)    + pm2(4)    + pm2(7)    =
  (-32)     + (16)      + (-128)    = -144
Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty zero-indexed array A consisting of N non-negative integers, returns the number M defined by the given array in the above manner. The function should return −1 if the absolute value of the result exceeds 10,000,000.
For example, given array A such that:
  A[0] = 5  A[1] = 4  A[2] = 7
the function should return −144, as explained in the example above.
Assume that:
N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..1,000,000,000].
Complexity:
expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 */
public class TwoPowerNImpl {
	
	static int[] testCase = {5, 4, 7};
	
	public static void main(String[] args) {
		System.out.println(new TwoPowerNImpl().solution(testCase));

	}

	/**
	 * @param A
	 * @return
	 */
	public double solution(int[] A) {
		if (A.length == 0)
			return 0;
		double power2toNSum = 0;
		for (int i : A) {
			power2toNSum += Math.pow(-2, i);
		}
		return power2toNSum;
    }
}
