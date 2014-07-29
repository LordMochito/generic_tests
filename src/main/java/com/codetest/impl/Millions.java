package com.codetest.impl;

import static com.codetest.impl.ThreeDigitsNumbersWithoutZero.space;
import static com.codetest.impl.Number2Words.oneBillion;
import static com.codetest.impl.Number2Words.thowsand;
import static com.codetest.impl.Number2Words.oneMillion;
import static com.codetest.impl.Number2Words.oneThowsand;
import static com.codetest.impl.Number2Words.million;

import com.codetest.exceptions.ThresholdNumberReached;

public class Millions {

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
