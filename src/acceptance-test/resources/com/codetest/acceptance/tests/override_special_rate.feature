@Feature
Feature: Override the interest special rate


As a broker 
I want to override the interest rate 
In order to provide preferential rates for special clients

Scenario Outline: Successful set a right special rate
	Given a valid client special type
	And a base interest rate "<Base_Interest_Rate>"
	And I request to override a special price "<Overridden_Rate>"
	When I request to interest rate service
	Then I receive the interest rate "<shouldValue>"
	
	Examples: 
      | Base_Interest_Rate | Overridden_Rate | shouldValue | right_interest_rate     									 |
      | 2.23       		   | 3.5             | 3.5         | Overridden Rate ≥ Base Interest Rate + 1%   				 |
      | 2.23		 	   | 2.24            | 2.2523      | Base Interest Rate + 1%									 |
	
Scenario: Fail get an invalid client type
	Given not SPECIAL client type: 
	  | PRIVILIGED    |
      | STANDARD  |
	When I request to override a  not special price "2.34"
	Then I receive the a not special client error