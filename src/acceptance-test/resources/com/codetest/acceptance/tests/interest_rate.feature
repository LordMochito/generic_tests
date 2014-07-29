@Feature
Feature: Calculates interest rate based on a set of parameters

In order to calculate loan payments
As a broker 
I want to retrieve the interest rate from the CPF system 

Scenario Outline: Successful get a right interest rate
	Given a valid client type "<clientType>"
	And a base interest rate "<Base_Interest_Rate>" 
	When I request to interest rate service
	Then I receive the interest rate "<shouldValue>"
	
	Examples: 
      | clientType | Base_Interest_Rate | shouldValue | right_interest_rate     									 |
      | STANDARD   | 2.23       		| 2.3415      | Base Interest Rate + 5% 									 |
      | PRIVILIGED | 2.23		 		| 2.28575     | Average of Base Interest Rate and “STANDARD” Interest Rate   |
      | SPECIAL    | 2.23    			| 2.28575     | Base Interest Rate + 5% 									 |
	
Scenario: Fail get an invalid client type
	Given an  invalid client type: 
	  | INVALID    |
      | NOT_VALID  |
      | STANDRAS   |
	When I request to interest rate service
	Then I receive the an "invalid client" error