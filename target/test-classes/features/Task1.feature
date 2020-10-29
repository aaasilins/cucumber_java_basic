Feature: Verifying input

  Scenario: Verify number too small error
    When Navigate to URL "https://kristinek.github.io/site/tasks/enter_a_number"
    And I enter "51"
    And I click on the Submit button
    Then I will see an error "Number is too small"

  Scenario: Verify number too big error
    When Navigate to URL "https://kristinek.github.io/site/tasks/enter_a_number"
    And I enter "150"
    And I click on the Submit button
    Then I will see an error "Number is too big"

  Scenario: Verify text instead of number error
    When Navigate to URL "https://kristinek.github.io/site/tasks/enter_a_number"
    And I enter "sdgsdg"
    And I click on the Submit button
    Then I will see an error "Please enter a number"

  Scenario: Verify correct number
    When Navigate to URL "https://kristinek.github.io/site/tasks/enter_a_number"
    And I enter "64"
    And I click on the Submit button
    Then I will see a popup with calculation "Square root of 64 is 8.00"