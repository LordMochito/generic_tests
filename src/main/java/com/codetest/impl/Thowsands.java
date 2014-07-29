package com.codetest.impl;

import static com.codetest.impl.Number2Words.oneMillion;
import static com.codetest.impl.Number2Words.oneThowsand;
import static com.codetest.impl.Number2Words.thowsand;
import static com.codetest.impl.ThreeDigitsNumbersWithoutZero.space;

import com.codetest.exceptions.ThresholdNumberReached;

public class Thowsands {

	private ThreeDigitsNumbersWithoutZero threeDigitsNumbers = new ThreeDigitsNumbersWithoutZero();
	
	public String convert2Word(int number) throws ThresholdNumberReached {
		if(number >= oneThowsand && number < oneMillion){
				
			return (threeDigitsNumbers.convert2Word((number % oneMillion) / oneThowsand)
				+ space + thowsand + space + 
					threeDigitsNumbers.convert2Word((number % oneThowsand))).trim();
		}
		throw new ThresholdNumberReached();
	}

}
