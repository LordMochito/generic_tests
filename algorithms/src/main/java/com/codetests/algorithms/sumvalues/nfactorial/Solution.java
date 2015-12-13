package com.codetests.algorithms.sumvalues.nfactorial;

import java.math.BigDecimal;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(14));
	}
	public int solution(int N) {
		double nFactorial = calculateFactorial(N);
		return sumDigits(nFactorial);
    }
	
	private double calculateFactorial(int N) {
		BigDecimal nfactorial = new BigDecimal(1);
		for (int i = N; i > 0; i--) {
			nfactorial = nfactorial.multiply(new BigDecimal(i));
		}
		return nfactorial.longValue();
	}
	
	private int sumDigits(double amount) {
		int resultSum = 0;
		while (amount > 0) {
			resultSum += (amount % 10);
		    amount = amount / 10;
		}
		return resultSum;
	}
}
