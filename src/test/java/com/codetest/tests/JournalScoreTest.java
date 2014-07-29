package com.codetest.tests;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.codetest.JournalRanking;
import com.codetest.impl.JournalsScoreImpl;
import com.codetest.pojos.JournalScoresRanking;
import com.codetest.repositories.JournalRankRepository;

@RunWith(MockitoJUnitRunner.class)
public class JournalScoreTest {


	@InjectMocks
	JournalsScoreImpl journalsScore;
	
	@Mock
	JournalRankRepository journalRankRepository;
	
	@Mock
	JournalRanking journalRanking;
	
	@Mock
	List<JournalScoresRanking> allJournals;
	
	private String journalName = null;
	private Double journalScore = null;
	private boolean reviewed = false;
	
	@Test
	public void shouldStoreScoredJournals() {
		// Fixture
		journalName = "A";
		journalScore = 1.0;
		//Experimentation
		journalsScore.storeJournalScore(journalName, journalScore, reviewed);		
		//Expectations
		verify(journalRankRepository).save(new JournalScoresRanking(journalName, journalScore, reviewed));
	}

	@Test
	public void shouldGetJournalsRanked() {
		// Fixture
		Order order = new Order(Direction.DESC, "score");
		when(journalRankRepository.findAll(new Sort(order))).thenReturn(allJournals);
		//Experimentation
		journalsScore.getJournalsRanked();
		//Expectations
		verify(journalRanking).rank(allJournals);
	}

}
