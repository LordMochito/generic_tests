package com.codetests.algorithms.phrase.reversewords;

import java.util.StringTokenizer;

public class Solution {

	private static String testString = "we test coders";
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution(testString));
	}

	public String solution(String S) {
		StringTokenizer st = new StringTokenizer(S, " ");
		StringBuffer result = new StringBuffer();
		while(st.hasMoreTokens()){
			result.append(" " + reverseWord(st.nextToken()));
		}
		return result.toString().trim();
	}

	private StringBuffer reverseWord(String word) {
		StringBuffer reversedWordResult = new StringBuffer(); 
		for (int i = word.length(); i > 0; i--) {
			reversedWordResult.append(word.charAt(i -1));
		}
		return reversedWordResult;
	}
}
