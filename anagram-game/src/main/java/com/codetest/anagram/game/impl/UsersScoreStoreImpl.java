package com.codetest.anagram.game.impl;

import java.awt.print.Pageable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.criterion.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.codetest.anagram.game.UsersScoreStore;
import com.codetest.anagram.game.domain.UserScore;
import com.codetest.anagram.game.repository.ScoreRepository;

@Named
public class UsersScoreStoreImpl  implements UsersScoreStore{

	@Inject
	ScoreRepository scoreRepository;
	 

	@Override
	public void storeScoreUser(String username, String word, int scored) {
		UserScore  userScore = new UserScore(username, word, scored);
		scoreRepository.save(userScore);
	}
	
	private UserScore getPosition(int position) {
		@SuppressWarnings("unchecked")
		List<org.springframework.data.domain.Sort.Order> asc = (List<org.springframework.data.domain.Sort.Order>) Order.asc("score");
		Pageable pageable = (Pageable) new PageRequest(position -1, 1, new Sort(asc));
		UserScore userScore = scoreRepository.findAll((Sort) pageable).iterator().next();
		return userScore;
	}
	@Override
	public String getWordEntryAtPosition(int position) {
		return getPosition(position).getWordScored();
	}
	@Override
	public Integer getScoreAtPosition(int position) {
		return getPosition(position).getScore();
	}
	@Override
	public String getUserNameAtPosition(int position) {
		return getPosition(position).getUserId();
	}
}
