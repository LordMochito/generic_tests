package com.codetest;

public interface UsersScoreStore {

	/**
	 * Store the word score by user
	 *  
	 * @param username
	 * @param word
	 * @param scored
	 */
	void storeScoreUser(String username, String word, int scored);

	String getUserNameAtPosition(int position);

	String getWordEntryAtPosition(int position);

	Integer getScoreAtPosition(int position);

}
