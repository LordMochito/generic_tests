Feature: Rank Journals

In order to highlight the journals which have the biggest impact in a given year
As a user
I want to be able to see journals ordered by their score across a range of years. 
If two or more journals have the same score they should be assigned the same rank, 
ordering within a rank should be done alphabetically on the journal’s name.

Scenario Outline: Rank journals  
	Given a list of "<Journals>" with scores "<Scores>" but  with "<reviewed>" excluded 
	When the user views the ranked journals 
	Then the order should be:  "<expectedRank>"
    
    Examples: 
      | Journals                     | Scores                    | reviewed     |  expectedRank     | 
      | A,B,C	                     | 5.6,3.1,2.4               |              | A,B,C          	|
      | B,C,A	                     | 6.2,6.2,2.2               |              | B,C,A             |
      | C,B,A		                 | 3.1,2.4,5.6        		 | A            | C,B        		|