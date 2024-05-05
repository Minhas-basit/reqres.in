Feature: User Creation
Scenario Outline: Create user and get User
Given User is created with "<name>" and "<job>" payload
When User is created with http "Post" request
Then User ID is generate 

Examples:
|name|job|
|Naila|HouseWife|


Scenario: Delete user
Given user is created 
When user is deleted with http "Delete" request
Then status code is 400