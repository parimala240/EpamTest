Feature: Chrome Login Feature

@chrome
Scenario Outline: Chrome Login Test Scenario

Given user is already on Login Page"<browser>"
When title of login page is Free CRM
Then user enters sourceDestination"<from>" and "<to>" and "<loginPhoneNumber>"
And user clicks on pageScroll 
Then user filterTheFilght bookNOW
Then Close the browser


Examples:
	| from      | to |loginPhoneNumber| browser |
	| Hyderabad |Pune|9441650255|Chrome|
	#| Hyderabad |Pune|9441650255|Safari|