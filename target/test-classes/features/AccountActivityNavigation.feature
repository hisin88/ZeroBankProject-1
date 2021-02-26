Feature: Navigating to specific accounts in Accounts Activity


  Scenario Outline: Navigating to different account types <accountType>
    Given the user is logged in
    When the user clicks on "<accountType>" link on the Account Summary page
    Then the "<accountPage>" page should be displayed
    And Account drop down should have "<accountTypeOption>" selected

    Examples:
      | accountType | accountPage      | accountTypeOption |
      | Savings     | Account Activity | Savings           |
      | Brokerage   | Account Activity | Brokerage         |
      | Checking    | Account Activity | Checking          |
      | Credit Card | Account Activity | Credit Card       |
      | Loan        | Account Activity | Loan              |
