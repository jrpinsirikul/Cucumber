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
	Scenario Outline: Successfully give colleage a point
		Given I navigate to the give point screen <form url>
		And I am logged in with username <username> and password <password>
		When I select a colleague from list <colleague>
		When I click give point button
		Then The form will not submit with missing category
			
	Examples:
		| form url | colleague | username | password |
		| http://devint.linktecflash.com/DHSFlash/#/home | John Doe | johndoe | letmein |
			
	Scenario Outline: Submit empty form
		Given I navigate to the give point screen <form url>
		And I am logged in with username <username> and password <password>
		When I click give point button
		Then the form will not submit
		
	Examples:
		| form url | username | password |
		| http://devint.linktecflash.com/DHSFlash/#/home | johndoe | letmein |
		
	Scenario Outline: Clear Form
		Given I navigate to the give point screen <form url>
		And I am logged in with username <username> and password <password>
		When I fill out form
		And I click the reset button
		Then the form will clear
		
	Examples:
		| form url | username | password |
		| http://devint.linktecflash.com/DHSFlash/#/home | johndoe | letmein |