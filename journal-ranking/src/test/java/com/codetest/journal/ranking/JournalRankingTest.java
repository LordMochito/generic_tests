package com.codetest.journal.ranking;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.codetest.journal.ranking.domain.JournalScoresRanking;
import com.codetest.journal.ranking.impl.JournalRankingImpl;

@RunWith(MockitoJUnitRunner.class)
public class JournalRankingTest {

	@InjectMocks
	JournalRankingImpl journalRanking;
	
	List<JournalScoresRanking> allJournals = new ArrayList<>();
	
	@Test
	public void shouldOrderByRanking() {
		// Fixture
		JournalScoresRanking journalScoresRanking = new JournalScoresRanking();
		journalScoresRanking.setId(1L);
		journalScoresRanking.setName("1");
		journalScoresRanking.setReviewed(false);
		journalScoresRanking.setScore(1.0);
		allJournals.add(journalScoresRanking);
		JournalScoresRanking journalScoresRanking2 = new JournalScoresRanking();
		journalScoresRanking2.setId(1L);
		journalScoresRanking2.setName("2");
		journalScoresRanking2.setReviewed(false);
		journalScoresRanking2.setScore(2.0);
		allJournals.add(journalScoresRanking2);
		JournalScoresRanking journalScoresRanking3 = new JournalScoresRanking();
		journalScoresRanking3.setId(1L);
		journalScoresRanking3.setName("3");
		journalScoresRanking3.setReviewed(false);
		journalScoresRanking3.setScore(2.0);
		allJournals.add(journalScoresRanking3);
		//Experimentation
		List<JournalScoresRanking> ranking = journalRanking.rank(allJournals);

		//Expectations
		assertEquals("1",ranking.get(0).getName());
		assertEquals("2",ranking.get(1).getName());
		assertEquals("3",ranking.get(2).getName());
	}

}
