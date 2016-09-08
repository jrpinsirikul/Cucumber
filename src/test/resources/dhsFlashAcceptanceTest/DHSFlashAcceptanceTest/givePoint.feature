#Feature: Give a colleague a point
#	As a user, I can view a give point screen so 
#	that I can select a colleague and give them a point
#	
#	Scenario: Give colleague a point
#		Given I navigate to the give point screen
#		When I select a colleague from list
#		And I click give point button
#		Then The form will submit
Feature: Give a colleague a point
	Scenario Outline: Successfully give colleagee a point
		Given I navigate to the give point screen <form url>
		When I select a colleague from list <colleague>
		And I click give point button
		Then The form will submit
			
	Examples:
		| form url | colleague |
		| http://devint.linktecflash.com/DHSFlash/#/home | John Doe |
			
	Scenario Outline: Submit empty form
		Given I navigate to the give point screen <form url>
		And I click give point button
		Then the form will not submit
		
	Examples:
		| form url |
		| http://devint.linktecflash.com/DHSFlash/#/home |