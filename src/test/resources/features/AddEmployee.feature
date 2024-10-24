Feature: Add employee

  Background:
    #Given user is able to access HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user can see dashboard page
    When user clicks on PIM option
    And user clicks on add employee option

  @add @name
  Scenario: add employee by firstname and lastname
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @add @id
  Scenario: add employee by id
    And user enters firstname and lastname
    And user clears id field
    And user enters id
    And user clicks on save button
    Then employee added successfully

  @add @incomplete
  Scenario:  add employee without lastname
    And user enters firstname
    And user clicks on save button
    Then user can see lastname error message

  @add @incomplete
  Scenario: add employee without firstname
    And user enters lastname
    And user clicks on save button
    Then user can see firstname error message