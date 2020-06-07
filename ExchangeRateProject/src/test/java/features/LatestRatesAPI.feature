Feature: Rate API for Foreign Exchange Rate Data
  
Background:
	Given Exchange Rate API Uri is accessible
	
Scenario: Verify if we get the Latest Foreign Exchange Rates successfully
	And user calls "latestForeignExchangeRate" endpoint
	When user makes a "Get" http request call
	Then the API call gets status code 200 
		  
Scenario: Verify if we get an error when Foreign Exchange Rates URI is incomplete
	And user calls "incomplete" endpoint
	When user makes a "Get" http request call
	Then the API call gets an error "time data 'api' does not match format '%Y-%m-%d'"
    
Scenario Outline: Verify if we get the Latest Foreign Exchange Rates successfully with specific exchange rates
   And user calls "latestForeignExchangeRate" endpoint
   And request for specific exchange rates with "<queryParam>" "<queryParamValue>" "<queryParam2>" "<queryParamValue2>"
   When user makes a "Get" http request call
   Then the API call gets status code 200

Examples: 
 		| queryParam | queryParamValue | queryParam2 | queryParamValue2 |
		| symbols    | USD,GBP		   |			 |					|
		| base       | USD 			   |			 |					|
		| base 		 | USD 			   | symbols 	 | GBP 				|
	
Scenario: Verify if we get the past conversion rate successfully
	And user calls "pastConversionRate" endpoint
	When user makes a "Get" http request call
	Then the API call gets status code 200
	
Scenario Outline: Verify if we get the Latest Foreign Exchange Rates successfully with specific exchange rates
   And user calls "pastConversionRate" endpoint
   And request for specific exchange rates with "<queryParam>" "<queryParamValue>" "<queryParam2>" "<queryParamValue2>"
   When user makes a "Get" http request call
   Then the API call gets status code 200

Examples: 
 		| queryParam | queryParamValue | queryParam2 | queryParamValue2 |
		| symbols    | USD,GBP		   |			 |					|
		| base       | USD 			   |			 |					|
		| base 		 | USD 			   | symbols 	 | GBP 				|
			