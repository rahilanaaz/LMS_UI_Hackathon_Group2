@Login
Feature: feature to test Login functionality

  Background: Admin or User is on LMS website.


  Scenario: Checking login hyperlink is working
    Given Admin or User is on LMS website page
    When Admin or User clicks Login Hyperlink
    Then Admin or User lands on LoginPage.

  Scenario Outline: Check Login is successful with valid credentials
    Given Admin or User is on Loginpage
    When Admin or User enters <UserName>, <Password> clicks Login Button
    Then Admin or User is navigated to Home Page.

    Examples: 
      | UserName | Password |
      | user1    | pass1    |
      | user2    | pass2    |

  Scenario Outline: Check Login is successful with invalid credentials
    Given Admin or User is on LoginPage
    When Admin or User enters <InvalidUserName>, <InvalidPassword>, clicks Login Button
    Then Admin or User is shown error message on same login page.

    Examples: 
      | InvalidUserName | InvalidPassword |
      | user1           | pass2           |
      | user2           | pass1           |
