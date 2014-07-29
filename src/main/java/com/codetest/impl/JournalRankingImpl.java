package com.codetest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.codetest.JournalRanking;
import com.codetest.pojos.JournalScoresRanking;

@Named
public class JournalRankingImpl implements JournalRanking{

	@Override
	public List<JournalScoresRanking> rank(Iterable<JournalScoresRanking> allJournals) {
		List<JournalScoresRanking> allJourneys = new ArrayList<>();
		Long currentRank = 1L;
		Double previousScore = null;
		for (JournalScoresRanking journalScoresRanking : allJournals) {
			currentRank = setRank(allJourneys, currentRank, previousScore,
					journalScoresRanking);
		}
		return allJourneys;
	}

	private Long setRank(List<JournalScoresRanking> allJourneys,
			Long currentRank, Double previousScore,
			JournalScoresRanking journalScoresRanking) {
		if (! journalScoresRanking.getReviewed()){
			if (previousScore != null && journalScoresRanking.getScore() < previousScore){
				journalScoresRanking.setRank(currentRank++);
			}else{
				journalScoresRanking.setRank(currentRank);
			}
			allJourneys.add(journalScoresRanking);	
		}
		return currentRank;
	}
}
