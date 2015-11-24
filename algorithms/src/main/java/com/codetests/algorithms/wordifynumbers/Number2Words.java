package com.codetests.algorithms.wordifynumbers;

/**
 * Take a number and give the equivalent number in british english words e.g.
 * 1 = one
 * 21 = twenty one
 * 105 = one hundred and five
 * 56945781 = fifty six million nine hundred and forty five thousand seven hundred and eighty one etc.. up to 999,999,999 without any external libraries (except testing libraries)
 * 
 *
 */
public class Number2Words implements Constants{
	
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
