package com.codetest.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.codetest.JournalRanking;
import com.codetest.RankJournals;
import com.codetest.pojos.JournalScoresRanking;
import com.codetest.repositories.JournalRankRepository;
@Named
public class JournalsScoreImpl implements RankJournals {

	@Inject
	JournalRankRepository journalRankRepository;
	
	@Inject
	JournalRanking journalRanking;
	
	@Override
	/**
	 * Store journals score
	 */
	public void storeJournalScore(String journalName, Double journalScore, boolean reviewed) {
		journalRankRepository.save(new JournalScoresRanking(journalName, journalScore, reviewed));
	}

	@Override
	public List<JournalScoresRanking> getJournalsRanked() {
		Order order = new Order(Direction.DESC, "score");
		List<JournalScoresRanking> allJournals = (List<JournalScoresRanking>) journalRankRepository.findAll(new Sort(order));
		return journalRanking.rank(allJournals);
	}

	@Override
	public void resetData() {
		journalRankRepository.deleteAll();
	}
	
}
