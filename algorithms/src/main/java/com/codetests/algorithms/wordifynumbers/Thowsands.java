package com.codetests.algorithms.wordifynumbers;


public class Thowsands implements Constants{

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
