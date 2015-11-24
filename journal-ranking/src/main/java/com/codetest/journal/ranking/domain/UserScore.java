package com.codetest.journal.ranking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Pojo to map to the 'database'
 * 
 * @author pablogutierrez
 *
 */
@Entity
@Table(name = "USER_SCORE")
public class UserScore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long identifier;
	
	@Column(name = "USER_ID")
	private String userId; 
	
	@Column(name = "WORD")
	private String wordScored;
	
	@Column(name = "SCORE")
	private Integer score;
	
	public UserScore(){
		super();
	}
	public UserScore(String userId, String wordScored, Integer score) {
		super();
		this.userId = userId;
		this.wordScored = wordScored;
		this.score = score;
	}

	public String getUserId() {
		return userId;
	}

	public String getWordScored() {
		return wordScored;
	}

	public Integer getScore() {
		return score;
	}

}
