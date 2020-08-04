@me
Feature: Parabank Website Features
	
  Scenario Outline: TestCase ID - <testCaseID> || User should be able to register, login and logout	
  	Given User should pass the vaild data for "<testCaseID>" for "<moduleName>" from DB table "<tableNameOnDB>"
  	When I launch parabank website "https://parabank.parasoft.com/parabank/index.htm"
  	And I click on register link
  	Then System should show the header as "Signing up is easy!" 
  	When I fill the mandatory details
  	And I click on register button
  	Then System should display the user name in home page
  	When I click on logout link
  	Then System should logout the session
  	When I login with registered details
  	Then System should take to parabank home page
  		
  Examples:
  |testCaseID		| moduleName 	| tableNameOnDB 		|
#  |TC001				|	parabank		|	register_details	|
# 	|TC002				|	parabank		|	register_details	|
# 	|TC003				|	parabank		|	register_details	|
# 	|TC004				|	parabank		|	register_details	|
 	|TC005				|	parabank		|	register_details	|
# 	|TC006				|	parabank		|	register_details	|
  	
    



