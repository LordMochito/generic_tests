package com.codetest.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.codetest.UsersScoreStore;
import com.codetest.pojos.UserScore;
import com.codetest.repositories.ScoreRepository;

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
		Order order = new Order(Direction.DESC, "score");
		Pageable pageable = new PageRequest(position -1, 1, new Sort(order));
		UserScore userScore = scoreRepository.findAll(pageable).iterator().next();
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
