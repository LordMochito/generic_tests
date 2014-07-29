package com.codetest.impl;

/**
 * http://www.visualdna.com
 *
 * Task: write a function called GCD that prints the greatest common divisor of two positive integers (a and b).
 * Hint: you can use the fact that GCD(a, b) = GCD(b, a mod b) and GCD(a, 0) = a *
 * Please give us a link to your solution on http://pastebin.com/ or similar.
 *
 */
public class GreatestCommonDivisor {

	static int[] example1 = {10, 90};
	static int[] example2 = {3, 9};
			
	public static void main(String[] args) {
		System.out.println(new GreatestCommonDivisor().getGreatestCommonDivisor(example1[0], example1[1]));
		System.out.println(new GreatestCommonDivisor().getGreatestCommonDivisor(example2[0], example2[1]));
	}

	public int getGreatestCommonDivisor(int a, int b) {
		if(b == 0)
            return a;
		if(a == 0)
            return b;
		if(a == b)
			return b;
		
        return getGreatestCommonDivisor(b, a % b);
	}
	
	
}
