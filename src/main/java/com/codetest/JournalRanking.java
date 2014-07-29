package com.codetest;

import java.util.List;

import com.codetest.pojos.JournalScoresRanking;

public interface JournalRanking {
	List<JournalScoresRanking> rank(Iterable<JournalScoresRanking> allJournals);
}
