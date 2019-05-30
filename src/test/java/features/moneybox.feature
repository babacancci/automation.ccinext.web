Feature: Money Box functionality

  As a user of CCINEXT
  In order to manage web site
  I want to be able to moneybox the system

  Scenario: What is the moneybox
    Given I am a user of CCINEXT
    And I log in using valid credentials
    And I go to moneybox
    When I go to what is the red moneybox
    Then I should see what the moneybox is

  Scenario: Display points movements
    Given I am a user of CCINEXT
    And I log in using valid credentials
    And I go to moneybox
    When I go to display points movements
    Then I should see points movements

  Scenario: Coca cola box pop-up cancel
    Given I am a user of CCINEXT
    And I log in using valid credentials
    And I go to moneybox
    When I go to gift catalog
    And I cancel Cocacola box
    Then I should see CCINEXT

  Scenario: Coca cola box pop-up where gift cancel
    Given I am a user of CCINEXT
    And I log in using valid credentials
    And I go to moneybox
    When I go to where gift
    And I cancel Cocacola box
    Then I should see CCINEXT






