Feature: Education functionality

  As a user of CCINEXT
  In order to manage web site
  I want to be able to education to the system

  Scenario: Education page
    Given I am a user of CCINEXT
    And I log in using valid credentials
    When I go to education
    Then I should see movies