package com.codetest.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.codetest.AnagramGame;
import com.codetest.UsersScoreStore;
import com.codetest.WordDictionary;

@Named
public class AnagramGameImpl implements AnagramGame {
	
	private String baseSetOfLetters = "";
	
	@Inject
	private WordDictionary dictionary;
	
	@Inject
	private UsersScoreStore usersScoreStore;
	
	public AnagramGameImpl() {
	}		

	@Override
	public int submitWord(String username, String word) {
		if (allLetterIntoSet(word) && existsWordInDictionary(word)){
			int scored = score(word);
			storeScoreUser(username, word, scored);
			return scored;
		}else{
			return 0;
		}
	}
	
	private void storeScoreUser(String username, String word, int scored) {
		usersScoreStore.storeScoreUser(username, word, scored);
		
	}

	/**
	 * Verify if all the word characters are in the set of given letters 
	 * @param word
	 * @return
	 */
	private boolean allLetterIntoSet(String word) {
		char[] wordCharArray = word.toCharArray();
		for (char character : wordCharArray) {
			if (baseSetOfLetters.indexOf(character) == -1)
				return false;
		}
		return true;
	}
	
	/**
	 * returns the score for this word
	 * @param word
	 * @return
	 */
	private int score(String word) {
		return word.toCharArray().length;		
	}
	
	/**
	 * Indicate if that word exists in dictionary
	 * @param word
	 * @return
	 */
	private boolean existsWordInDictionary(String word) {
		return dictionary.contains(word);	
	}

	@Override
	public String getUserNameAtPosition(int position) {
		return usersScoreStore.getUserNameAtPosition(position);
	}

	@Override
	public String getWordEntryAtPosition(int position) {
		return usersScoreStore.getWordEntryAtPosition(position);
	}

	@Override
	public Integer getScoreAtPosition(int position) {
		return usersScoreStore.getScoreAtPosition(position);
	}

	@Override
	public void setBaseSetOfLetters(String baseSetOfLetters) {
		this.baseSetOfLetters = baseSetOfLetters;
	}
}
