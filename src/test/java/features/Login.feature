Feature: Application login

Scenario: Login with valid credentials
Given Open any browser
And Navigate to login page
When User enters user name as "mark@gmail.com" and password as "mark234"
And User clicks on login button
Then Verify user is able to successfully login