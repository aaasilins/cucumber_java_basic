Feature: Verifying input

  Scenario Outline: Verify number too small error
    When Navigate to URL "https://kristinek.github.io/site/tasks/enter_a_number"
    And I enter "<number>"
    And I click on the Submit button
    Then I will see an error "<message>"
Examples:
    |number|message|
    |48    |Number is too small|
    |150   |Number is too big  |
    |sdgsdg|Please enter a number|


  Scenario Outline: Verify correct number
    When Navigate to URL "https://kristinek.github.io/site/tasks/enter_a_number"
    And I enter "<number>"
    And I click on the Submit button
    Then I will see a popup with calculation "<message>"
    Examples:
      |number|message|
      |64    |Square root of 64 is 8.00|


