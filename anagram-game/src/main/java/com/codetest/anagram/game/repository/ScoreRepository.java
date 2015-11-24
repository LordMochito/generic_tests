package com.codetest.anagram.game.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codetest.anagram.game.domain.UserScore;

public interface ScoreRepository extends PagingAndSortingRepository<UserScore, Long>{

}
