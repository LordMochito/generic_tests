package com.codetest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codetest.pojos.UserScore;

public interface ScoreRepository extends PagingAndSortingRepository<UserScore, Long>{

}
