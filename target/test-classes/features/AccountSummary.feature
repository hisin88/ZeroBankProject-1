@AccountSummary
Feature: Account Summary

  Scenario: Verify Title
    Given the user is on the login page
    When the user enters valid username and password
    Then the page should have the title "Zero - Account Summary"

  Scenario: Verify Account Types
    Given the user is on the login page
    When the user enters valid username and password
    Then the user should see the following options
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Verify Credit Accounts headers
    Given the user is on the login page
    When the user enters valid username and password
    Then the user should see the following options under Credit Accounts
      | Account     |
      | Credit Card |
      | Balance     |




