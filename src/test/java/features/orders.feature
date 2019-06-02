Feature: Orders functionality

  As a user of CCINEXT
  In order to manage web site
  I want to be able to orders to the system

  Scenario: Give order page opened
    Given I am a user of CCINEXT
    And I log in using valid credentials
    When I go to orders
    Then I should see orders page

  Scenario: One product order
    Given I am a user of CCINEXT
    And I log in using valid credentials
    When I go to orders
    And I give a orders button click
    And I one product select
    And I go to basket
    And I send order
    Then I should see orders was successfully received



    