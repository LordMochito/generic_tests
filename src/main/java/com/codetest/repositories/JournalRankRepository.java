package com.codetest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codetest.pojos.JournalScoresRanking;

/**
 * Journal Scores Ranking Repository
 *  
 * @author pablogutierrez
 *
 */
public interface JournalRankRepository extends PagingAndSortingRepository<JournalScoresRanking, Long>{
}
