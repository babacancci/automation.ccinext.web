Feature: My orders functionality

  As a user of CCINEXT
  In order to manage web site
  I want to be able to my orders to the system

  Scenario: See My Orders
    Given I am a user of CCINEXT
    And I log in using valid credentials
    And I go to orders
    When I go to my orders
    Then I should see my orders

  Scenario: My orders by selecting the date
    Given I am a user of CCINEXT
    And I log in using valid credentials
    And I go to orders
    When I go to my orders
    And I select selecting the date
    Then I should see my orders details



