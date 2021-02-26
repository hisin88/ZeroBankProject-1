Feature: Account Activity

  Background:
    Given the user is on the login page
    When the user enters valid username and password
    And the user navigates to "Account Activity"


  Scenario: Verify Title
    Then the page should have the title "Zero - Account Activity"


  Scenario: Dropdown Default Option
    Then the Account drop down default option should be "Savings"

  Scenario: Verify All Dropdown Options
    Then Account dropdown should have the following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |


  Scenario: Verify Transaction Table Headers
    Then the Transaction Table should have the following column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
