package com.codetest.impl;
/**
 * String words3Palindrome = "abac"; 
 * 
 * @author pablogutierrez
 *
 */
public class PalindromeCheck {

	public static String returnLongestPalindrome(char[] charArray) {
		
		String longestPalindrome = "";
		for (int i = 0; i < charArray.length; i++) {
			//int j = charArray.length; 
			for (int j = charArray.length; j > 0 ; j--) {
				String substring = String.valueOf(charArray).substring(i, j);
				if (isAPalindrome(substring) 
					&& (substring.length() > longestPalindrome.length())){
					longestPalindrome = substring ; 
				}
			}
		}
		return longestPalindrome;
	}
	public static boolean isAPalindrome(String text) {
		String reverseText = "";
		for (int i = text.length(); i > 0; i--) {
			reverseText  +=  text.charAt(i - 1);
		}
		return (reverseText.equals(text));
	}
}
