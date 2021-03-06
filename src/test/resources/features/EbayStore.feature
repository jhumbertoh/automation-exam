Feature: EbayStore 
	As a customer 
  I want to search my 'PUMA'  shoes in the list produts using filters search
  In order to buy

@EbayStore
Scenario: The number of results for brand PUMA 
	Given I go to the Ebay page on URL "https://www.ebay.com" 
	When I fill the value "shoes" in the text field 
	And I click on the search button 
	And I select the brand PUMA 
	And I select the size 10 
	Then I should see the number of results 
	
@Pending
Scenario: Assert the order taking the first 5 results 
	Given I go to the Ebay page on URL "https://www.ebay.com" 
	When I fill the value "shoes" in the text field 
	And I click on the search button 
	And I select the brand PUMA 
	And I select the size 10 
	And I order by price ascendant 
	Then I should assert the order taking the first 5 results 
	
@EbayStore	
Scenario: Print the first products with their prices in console 
	Given I go to the Ebay page on URL "https://www.ebay.com" 
	When I fill the value "shoes" in the text field 
	And I click on the search button 
	And I select the brand PUMA 
	And I select the size 10 
	And I order by price ascendant 
	Then I should print the first "1" products with their prices in console 
	
@EbayStore
Scenario: Order and print the products by price in descendant mode 
	Given I go to the Ebay page on URL "https://www.ebay.com" 
	When I fill the value "shoes" in the text field 
	And I click on the search button 
	And I select the brand PUMA 
	And I select the size 10 
	And I order by price descendant 
	Then I should print the first "2" products with their prices in descendant mode 
	
	