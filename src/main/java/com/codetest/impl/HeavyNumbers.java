package com.codetest.impl;
/**
 * Gamesys
A non-negative integer is called heavy if the average value of its digits in decimal representation exceeds 7. Assume that 0 has an average value of its digits equal to 0.
For example, the number 8,698 is heavy because the average value of its digits is (8+6+9+8)/4 = 7.75. The number 53,141 has an average value of its digits of (5+3+1+4+1)/5 = 2.8, so it is not heavy.
Write a function:
class Solution { public int solution(int A, int B); }
that, given two non-negative integers A and B, returns the number of heavy integers within the interval [A..B] (both ends included).
Assume that:
A is an integer within the range [0..200,000,000];
B is an integer within the range [0..200,000,000];
A ≤ B.
For example, given A=8,675 and B=8,689 the function should return 5, because there are five heavy integers within the range [8,675..8,689]:
8675    avg=6.50
8676    avg=6.75
8677    avg=7.00
8678    avg=7.25    HEAVY
8679    avg=7.50    HEAVY
8680    avg=5.50
8681    avg=5.75
8682    avg=6.00
8683    avg=6.25
8684    avg=6.50
8685    avg=6.75
8686    avg=7.00
8687    avg=7.25    HEAVY
8688    avg=7.50    HEAVY
8689    avg=7.75    HEAVY
Complexity:
expected worst-case time complexity is O((log(A)+log(B))3);
expected worst-case space complexity is O(log(A)+log(B)).
 *
 */
public class HeavyNumbers {

	static int[] testCase = { 8675, 8689 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new HeavyNumbers().totalizeHeavyNumbers(testCase[0], testCase[1]));

	}

	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int totalizeHeavyNumbers(int A, int B) {
		int totalHeavyNumbers = 0;
		for (int i = A; i <= B; i++) {
			if (isHeavy(i)) {
				totalHeavyNumbers++;
			}
		}
		return totalHeavyNumbers;
	}

	public boolean isHeavy(int integerNumber) {
		float average = 0;
		float digits = 0;
		while (integerNumber > 0) {
			average += integerNumber % 10;
			integerNumber /= 10;
			digits++;
		}
		return ((average / digits) > 7);
	}

}
