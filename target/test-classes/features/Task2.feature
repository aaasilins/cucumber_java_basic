Feature: List of people

  Scenario: Add a new person
    When Navigate to URL "https://kristinek.github.io/site/tasks/list_of_people.html"
    And I click on "addPersonBtn"
    And Fill in all the details with "Andrejs" and "Silins"
    And I click on "modal_button"
    Then Person appears in the main list with "Andrejs" and "Silins"

  Scenario: Edit a person
    When Navigate to URL "https://kristinek.github.io/site/tasks/list_of_people.html"
    And I click to reset the list
    And I click on first person Edit button
    And Change the name of the person to "Antons"
    And I click on "modal_button"
    Then Person appears in the main list with "Antons" and "Kid"

  Scenario: Remove a person
    When Navigate to URL "https://kristinek.github.io/site/tasks/list_of_people.html"
    And I click to reset the list
    And I click on first person Remove button
    Then Person "Mike" "Kid" is not present in the list

  Scenario: Reset a list after adding a person
    When Navigate to URL "https://kristinek.github.io/site/tasks/list_of_people.html"
    And I click on "addPersonBtn"
    And Fill in all the details with "Andrejs" and "Silins"
    And I click on "modal_button"
    And Person appears in the main list with "Andrejs" and "Silins"
    And I click to reset the list
    Then List of persons contains only default entries

  Scenario: Reset a list after editing a person
    When Navigate to URL "https://kristinek.github.io/site/tasks/list_of_people.html"
    And I click to reset the list
    And I click on first person Edit button
    And Change the name of the person to "Antons"
    And I click on "modal_button"
    And Person appears in the main list with "Antons" and "Kid"
    And I click to reset the list
    Then List of persons contains only default entries

  Scenario: Reset a list after removing a person
    When Navigate to URL "https://kristinek.github.io/site/tasks/list_of_people.html"
    And I click to reset the list
    And I click on first person Remove button
    And Person "Mike" "Kid" is not present in the list
    And I click to reset the list
    Then List of persons contains only default entries

    Scenario: Check that clear button on adding a user works correctly
      When Navigate to URL "https://kristinek.github.io/site/tasks/list_of_people.html"
      And I click on "addPersonBtn"
      And Fill in all the details with "Andrejs" and "Silins"
      And I click on "addPersonBtn"
      Then All 'Add new person' fields are empty


