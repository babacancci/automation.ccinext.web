Feature: Login functionality

  As a user of CCINEXT
  In order to manage web site
  I want to be able to log in to the system

  Scenario: Log in with valid credentials
    Given I am a user of CCINEXT
    When I log in using valid credentials
    Then I should be logged in

  Scenario: Log in with invalid credentials
    Given I am a user of CCINEXT
    When I log in using wrong valid credentials
    Then I should not be logged in

  Scenario: Log in with empty valid password credentials
    Given I am a user of CCINEXT
    When I log in using empty valid credentials
    Then I should not be logged in

  Scenario: Log in with missing valid password credentials
    Given I am a user of CCINEXT
    When I log in using missing valid credentials
    Then I should not be logged in

  Scenario: Log in with empty valid user credentials
    Given I am a user of CCINEXT
    When I log in using empty valid credentials
    Then I should not be logged in

  Scenario: Forget password user credentials
    Given I am a user of CCINEXT
    When I forget password
    And I using user and mobile number
    Then I should see sending message

  Scenario: User info screen pop-up
    Given I am a user of CCINEXT
    When I user info click
    Then I should see user area pop-up
