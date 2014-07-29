package com.codetest.impl;

public class TwoLessSquare {

	static int[] squareNumbers = {5, 4, 7};
			
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new TwoLessSquare().addLessSquare2Number(squareNumbers));

	}
	
	public int addLessSquare2Number(int[] number) {
		double sum = 0; 
		for( int i=0; i<number.length; i++){ 
			sum += Math.pow(-2, number[i]); 
		} 
		
		if (Math.abs(sum) > 10000000)
			return -1;
		
		return new Double(sum).intValue();
	}

}
