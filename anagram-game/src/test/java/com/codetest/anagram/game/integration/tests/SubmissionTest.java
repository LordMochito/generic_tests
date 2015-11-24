package com.codetest.anagram.game.integration.tests;

import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.codetest.anagram.game.AnagramGame;
import com.codetest.anagram.game.repository.ScoreRepository;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:applicationContext.xml") 
public class SubmissionTest {
	
	@Inject
    AnagramGame service;
	
	@Inject
	ScoreRepository scoreRepository;

    @Before
    public void setUp() throws Exception {
    	scoreRepository.deleteAll();
        initialTestLoad();
        service.setBaseSetOfLetters("areallylongword");
    }

    private void initialTestLoad() {
    	service.submitWord("1", "no");
        service.submitWord("2", "grow");
        service.submitWord("6", "adder");
        service.submitWord("5", "woolly");
	}
    
    @Test
    public void shouldScore() throws Exception {
        assertEquals(2, service.submitWord("1", "no"));
        assertEquals(4, service.submitWord("2", "grow"));
        assertEquals(5, service.submitWord("6", "adder")); //incongruence in the original test, this word exists in the dictionary
        assertEquals(6, service.submitWord("5", "woolly"));
    }
    
    @Test
    public void shouldNotScore() throws Exception {
        assertEquals(0, service.submitWord("3", "bold"));
        assertEquals(0, service.submitWord("4", "glly"));
        
    }
    
    //@Test
    public void shouldGetUserNameByPosition() throws Exception {
    	assertEquals("5", service.getUserNameAtPosition(1));
    	assertEquals("6", service.getUserNameAtPosition(2));
    	assertEquals("2", service.getUserNameAtPosition(3));
    	assertEquals("1", service.getUserNameAtPosition(4));
	}
    
    @Test
    public void shouldGetWordByPosition() {
    	assertEquals("woolly", service.getWordEntryAtPosition(1));
    	assertEquals("adder", service.getWordEntryAtPosition(2));
    	assertEquals("grow", service.getWordEntryAtPosition(3));
    	assertEquals("no", service.getWordEntryAtPosition(4));
	}
    
    @Test
    public void shouldGetScoreByPosition() {
    	assertEquals(6L, service.getScoreAtPosition(1).longValue());
    	assertEquals(5L, service.getScoreAtPosition(2).longValue());
    	assertEquals(4L, service.getScoreAtPosition(3).longValue());
    	assertEquals(2L, service.getScoreAtPosition(4).longValue());
	}
    
}
