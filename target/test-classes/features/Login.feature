@login
Feature: Login

  Background:
    Given the user is on the login page

  Scenario: Login with valid credentials
    When the user enters valid username and password
    Then "Account Summary" page should be displayed

  Scenario: Not login with wrong username
    When the user enters "wrong username" and "valid password"
    Then error message should be displayed.

  Scenario: Not login with wrong password
    When the user enters "valid username" and "wrong password"
    Then error message should be displayed.

  Scenario: Not login with blank username
    When the user enters "blank username" and "valid password"
    Then error message should be displayed.

  Scenario: Not login with blank password
    When the user enters "valid username" and "blank password"
    Then error message should be displayed.
