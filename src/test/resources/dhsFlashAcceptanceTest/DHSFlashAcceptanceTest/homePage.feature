#Feature: After login, make sure home page loads
#	
#	Scenario: Navigate to kudos app
#		When I login to application
#		Then I should see the home page
Feature: Kudos Home Page
	
	Scenario Outline: Kudos application shows welcome message to users
		When I login to the application <appUrl>
		Then I should see the home page
		
	Examples:
		| appUrl |
		| http://devint.linktecflash.com/DHSFlash/#/home |