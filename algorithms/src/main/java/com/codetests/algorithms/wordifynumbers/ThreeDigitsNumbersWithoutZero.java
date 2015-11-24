package com.codetests.algorithms.wordifynumbers;

/**
 * It can convert only less than 1000 numbers 
 * 
 * @author pablogutierrez
 *
 */
public class ThreeDigitsNumbersWithoutZero implements NumbersAsWords{

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
