package com.codetest.acceptance.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import com.codetest.journal.ranking.RankJournals;
import com.codetest.journal.ranking.domain.JournalScoresRanking;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RankJournalsAcceptanceTest {
	
	@Inject
	RankJournals rankJournals;
	
	private List<JournalScoresRanking> journalsRanked;

	@Given("^a list of \"([^\"]*)\" with scores \"([^\"]*)\" but  with \"([^\"]*)\" excluded$")
	public void a_list_of_with_scores_but_with_excluded(String journals, String scores, String reviewed) throws Throwable {
		//Fixtures
		rankJournals.resetData();
		String[] journalsArray = journals.split(",");
		String[] scoresArray = scores.split(",");
	    for (int i = 0; i < journalsArray.length; i++) {
	    	rankJournals.storeJournalScore(journalsArray[i], Double.valueOf(scoresArray[i]), (reviewed.indexOf(journalsArray[i]) != -1) );
		}
	}

	@When("^the user views the ranked journals$")
	public void the_user_views_the_ranked_journals() throws Throwable {
		journalsRanked = rankJournals.getJournalsRanked();
	}

	@Then("^the order should be:  \"([^\"]*)\"$")
	public void the_order_should_be(String orderExpected) throws Throwable {
		String[] expectedOrder = orderExpected.split(",");
		int i = 0;
	    for (JournalScoresRanking scoresRanking : journalsRanked) {
	    	assertEquals(expectedOrder[i++], scoresRanking.getName());
		}
	}

}
