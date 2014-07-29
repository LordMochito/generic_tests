package com.codetest.impl;

import com.codetest.exceptions.ThresholdNumberReached;


/**
 * Take a number and give the equivalent number in british english words e.g.
 * 1 = one
 * 21 = twenty one
 * 105 = one hundred and five
 * 56945781 = fifty six million nine hundred and forty five thousand seven hundred and eighty one etc.. up to 999,999,999 without any external libraries (except testing libraries)
 * 
 * @author pablogutierrez
 *
 */
public class Number2Words {
	
	public static int oneThowsand = 1000; 
	public static int oneMillion = 1000000; 
	public static int oneBillion = 1000000000;
	
	public static final String thowsand = "Thowsand";
    public static final String million = "Million";
    public static final String zero = "Zero";
    
	public String convert2Word(int number) throws ThresholdNumberReached {
		if(number == 0)
			return zero;
		
		if(number < oneThowsand){

			return new ThreeDigitsNumbersWithoutZero().convert2Word(number);
			
		}else if(number >= oneThowsand && number < oneMillion){
			
			return new Thowsands().convert2Word(number); 
						
		}else if(number >= oneMillion && number < oneBillion){
			
			return new Millions().convert2Word(number);
        }
		throw new ThresholdNumberReached();
	}

}
