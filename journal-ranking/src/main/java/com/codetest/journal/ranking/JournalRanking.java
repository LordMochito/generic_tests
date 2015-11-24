package com.codetest.journal.ranking;

import java.util.List;

import com.codetest.journal.ranking.domain.JournalScoresRanking;

public interface JournalRanking {
	List<JournalScoresRanking> rank(Iterable<JournalScoresRanking> allJournals);
}
