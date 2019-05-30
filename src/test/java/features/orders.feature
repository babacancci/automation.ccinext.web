Feature: Orders functionality

  As a user of CCINEXT
  In order to manage web site
  I want to be able to orders to the system

  Scenario: Give order page opened
    Given I am a user of CCINEXT
    And I log in using valid credentials
    When I go to orders
    Then I should see orders page

    