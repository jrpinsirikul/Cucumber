#Feature: Login to Kudos application
#	As a user, I can view a user log in screen so 
#	that I can enter my user name and password and log into the application
#	
#	Scenario: Navigate to kudos app and log in
#		Given I navigate to login screen
#		When I input my username
#		And I input my password
#		Then I should see the home page of the kudos app
Feature: Kudos Application Login
	
	Scenario Outline: Successfully login with correct username and password
		Given I have a valid username and password
		When I input my username and password <username> <password>
		Then I should be logged in
		
		Examples:
		| username | password |
		| johndoe  | letmein  |