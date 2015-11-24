package com.codetest.journal.ranking.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codetest.journal.ranking.domain.JournalScoresRanking;

public interface JournalRankRepository extends PagingAndSortingRepository<JournalScoresRanking, Long>{

}
