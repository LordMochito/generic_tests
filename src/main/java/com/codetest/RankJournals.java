package com.codetest;

import java.util.List;

import com.codetest.pojos.JournalScoresRanking;

public interface RankJournals {

	void storeJournalScore(String journalName, Double journalScore, boolean reviewed);

	List<JournalScoresRanking> getJournalsRanked();

	void resetData();

}
