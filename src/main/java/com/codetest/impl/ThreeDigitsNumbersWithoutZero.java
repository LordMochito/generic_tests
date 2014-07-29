package com.codetest.impl;

import com.codetest.exceptions.ThresholdNumberReached;

/**
 * It can convert only less than 1000 numbers 
 * 
 * @author pablogutierrez
 *
 */
public class ThreeDigitsNumbersWithoutZero {


	final private static String[] digits2TwentyWords = {"","One","Two","Three","Four", "Five","Six","Seven","Eight","Nine","Ten", 
														"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	final private static String[] tensWords = {"", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	
    public static final String hundred = "Hundred";
    public static final String space = " ";

	public String convert2Word(int number) throws ThresholdNumberReached {
		//converting single digits number
        if(number >= 0 && number < 20){
        	
        	return digits2TwentyWords[number];
        }
        //converting from 20 to 100 numbers
        else if(number > 19 && number < 100){
        	
        	return (tensWords[(number/10) -1] + space + digits2TwentyWords[number % 10]).trim();
        }
        //converting from 101 to 999
        else if(number >= 100 && number < 1000)
        {
        	return (digits2TwentyWords[number / 100] + space + hundred + tensWords[((number %100 )/10)] + space + digits2TwentyWords[number % 10]).trim();
        }
        
		throw new ThresholdNumberReached();
	}
}
