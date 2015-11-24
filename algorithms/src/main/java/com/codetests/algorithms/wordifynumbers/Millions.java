package com.codetests.algorithms.wordifynumbers;

public class Millions implements Constants{

	private ThreeDigitsNumbersWithoutZero threeDigitsNumbers = new ThreeDigitsNumbersWithoutZero();
	
	public String convert2Word(int number) throws ThresholdNumberReached {
		if(number >= oneMillion && number < oneBillion){
			String word = threeDigitsNumbers.convert2Word(number / oneMillion) 
					+ space + million + space;
				String thowsandWord =	threeDigitsNumbers.convert2Word((number % oneMillion) / oneThowsand);
				thowsandWord  += (! thowsandWord.equals(""))?	thowsandWord + space + thowsand + space:thowsandWord;
					
				return (word + thowsandWord + threeDigitsNumbers.convert2Word((number % oneThowsand))).trim();
		}
		throw new ThresholdNumberReached();
	}

}
