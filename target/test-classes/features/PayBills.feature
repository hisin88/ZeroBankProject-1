Feature: Pay Bills

  Background:
    Given the user is on the login page
    When the user enters valid username and password
    And the user navigates to "Pay Bills"


  Scenario: Verify Title
    Then the page should have the title "Zero - Pay Bills"

  Scenario: Submitted Payment Message
    When the user enters amount "10" date "2012-02-01" description "other"
    And the user clicks on the pay button
    Then the user should see the payment submitted message

  Scenario: Error Message While Entering Without Amount
    When the user enters amount "" date "2012-02-01" description "other"
    And the user clicks on the pay button
    Then the user should see the error message on "amount" input box

  Scenario: Error Message While Entering Without Date
    When the user enters amount "100" date "" description "other"
    And the user clicks on the pay button
    Then the user should see the error message on "date" input box

