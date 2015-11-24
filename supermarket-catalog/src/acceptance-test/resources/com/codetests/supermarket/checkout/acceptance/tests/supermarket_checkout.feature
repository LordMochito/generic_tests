Feature: get receipt supermarket checkout

As a supermarket teller 
I want to retrieve a receipt after all the items are scanned for a customer 
in order to get all discounts applied

Background:
	Given a set of this stored goods:
	  | Item_set                     | Item_name                    | Price                    | 
      | Vegetables                   | Potatoes                     | 1.20                     |
      | Fruit	                     | Oranges                      | 1.70                     |
      | Electronics                  | Radio                        | 12.00                    |
      | Pharmacy                     | Toothpaste                   | 3.00                     |
      | Fruit                        | Apples                       | 1.60                     |
	And the 3 rules stablished
	
Scenario Outline: Different items without any rule  
	Given a list of "<Item_name>" with a single identifier "<Item_id>" in a group of "<Item_set>" items with "<quantity>" of which one
	When I ask for the receipt 
	Then I get an list of the items with their prices
    And I get a total number with the sum of all of them  "<expectedTotalAmount>"
    
    Examples: 
      | Item_set                     | Item_name                    | Item_id         | quantity | expectedTotalAmount | 
      | Vegetables                   | Potatoes                     | 1 			  | 1        | 1.20                |
      | Fruit	                     | Oranges                      | 2               | 1        | 2.90                |
      | Electronics                  | Radio                        | 3 			  | 1        | 14.90               |
      | Pharmacy                     | Toothpaste                   | 4 			  | 1        | 17.90               |
   
Scenario Outline: 3 equals items and get 1 free 
	Given a list of "<Item_name>" with a single identifier "<Item_id>" in a group of "<Item_set>" items with "<quantity>" of which one
	When I ask for the receipt 
	Then I get an list of the items with their prices
    And I get a total number with the sum of all of them  "<expectedTotalAmount>"
    
    Examples: 
      | Item_set                     | Item_name                    | Item_id         | quantity | expectedTotalAmount | 
      | Vegetables                   | Potatoes                     | 1 			  | 2        | 19.10               |

Scenario Outline: 2 equals items and get special price for both 
	Given a list of "<Item_name>" with a single identifier "<Item_id>" in a group of "<Item_set>" items with "<quantity>" of which one 
	When I ask for the receipt 
	Then I get an list of the items with their prices
    And I get a total number with the sum of all of them  "<expectedTotalAmount>"
    
    Examples: 
      | Item_set                     | Item_name                    | Item_id         | quantity | expectedTotalAmount | 
      | Fruit	                     | Oranges                      | 2               | 1        | 19.40               |

Scenario Outline: 3 items in the same set and the cheaper is free 
	Given a list of "<Item_name>" with a single identifier "<Item_id>" in a group of "<Item_set>" items with "<quantity>" of which one
	When I ask for the receipt 
	Then I get an list of the items with their prices
    And I get a total number with the sum of all of them  "<expectedTotalAmount>"
    
    Examples: 
      | Item_set                     | Item_name                    | Item_id         | quantity | expectedTotalAmount | 
      | Fruit                        | Apples                       | 5 			  | 1        | 21.00               |
