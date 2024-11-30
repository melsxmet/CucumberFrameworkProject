Feature: Login Scenarios

  Background:
    #Given user is able to access HRMS application

  @login @emptyuser
  Scenario: empty username login
    When user enters only valid password
    And user clicks on login button
    Then user can see username error message
  @login @emptypass
  Scenario: empty password login
    When user enters only valid username
    And user clicks on login button
    Then user can see password error message

  @login @invalid
  Scenario: invalid credential login
    When user enters invalid username or password
    And user clicks on login button
    Then user can see invalid credentials message
    And user enters valid username and password
    And user clicks on login button
    Then user can see dashboard page
