#Feature: Check Kudos Application is showing welcome message
#	As a user, I can view a message on the home page that says
#	Hello World
#	
#	Scenario: Navigate to kudos app
#		When I navigate to home page
#		Then I should see the welcome message
Feature: Kudos Welcome Message
	
	Scenario Outline: Kudos application shows welcome message to users
		When I navigate to home page <environment>
		Then I should see message "Hello World"
		
		Examples:
		| environment									   |
		| http://devint.linktecflash.com/DHSFlash/#/home   |