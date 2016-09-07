#Feature: Employee point list
#	As a user, I can list of employees with award points 
#	and a corresponding award level
#	
#	Scenario: View employee point list
#		Given there is at least 1 employee with a point in the system
#		When I navigate to the Home screen
#		Then I will see a list of employees
Feature: View employee point list
	Scenario Outline: Successfully view an employee list
		Given there is at least 1 employee with a point in the system
		When I navigate to the Home screen <form url>
		Then I will see a list of employees
			
	Examples:
		| form url |
		| http://devint.linktecflash.com/DHSFlash/#/home |
