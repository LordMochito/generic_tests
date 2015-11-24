package com.codetest.journal.ranking;

import java.util.List;

import com.codetest.journal.ranking.domain.JournalScoresRanking;

public interface RankJournals {

	void storeJournalScore(String journalName, Double journalScore, boolean reviewed);

	List<JournalScoresRanking> getJournalsRanked();

	void resetData();

}
